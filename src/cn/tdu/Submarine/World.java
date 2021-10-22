package cn.tdu.Submarine;
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Arrays;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

/*整个游戏世界*/
public class World extends JPanel {
    public static final int WIDTH=641;
    public static final int HEIGHT=479;
    private boolean stop=false;
    //战舰
    private Battleship ship=new Battleship();
    //潜艇数组
    private SeaObject[] submariner={};
    //雷数组
    private SeaObject[] thunders={};
    //炸弹数组
    private Bomb[] bombs={};
    /**随机返回一个潜艇类型*/
    public SeaObject nextSubmarine(){
        //实例化随机数
        Random random=new Random();
        int type=random.nextInt(30);
        //根据随机数范围返回不同类型的潜艇
        if (type<10){
            return new ObserveSubmarine();
        }else if (type<15){
            return new TorpedoSubmarine();
        }else {
            return new MineSubmarine();
        }
    }
    private int subEnterIndex=0;//用以控制频率的变量
    /** 生成潜艇对象 */
    public void submarinerEnterAction(){//每十毫秒走一次，需要控制频率
        subEnterIndex++;
        //控制频率
        if (subEnterIndex%40==0){
            SeaObject obj=nextSubmarine();
            //数组扩容并把随机的潜艇对象赋给最后一位
            submariner=Arrays.copyOf(submariner,submariner.length+1);
            submariner[submariner.length-1]=obj;
        }
    }
    private int thunderEnterIndex=0;
    /** 生成雷对象 */
    public void thunderEnterAction(){
        thunderEnterIndex++;
        if (thunderEnterIndex%100==0) {
            for (int i = 0; i < submariner.length; i++) {
                SeaObject obj = submariner[i].shootThunder();
                if (obj != null) {
                    thunders = Arrays.copyOf(thunders, thunders.length + 1);
                    thunders[thunders.length - 1] = obj;
                }
            }
        }
    }
    /** 移动*/
    public void steoAction(){
        for (int i=0;i<submariner.length;i++){
            submariner[i].step();
        }
        for (int i=0;i<thunders.length;i++){
            thunders[i].step();
        }
        for (int i=0;i<bombs.length;i++){
            bombs[i].step();
        }
    }
    /**删越界*/
    public void outOfBoundsAction(){
        //遍历并删除越界潜艇
        for (int i=0;i<submariner.length;i++){
            if (submariner[i].isOutOfBounds()||submariner[i].isDead()){
                submariner[i]=submariner[submariner.length-1];
                submariner=Arrays.copyOf(submariner,submariner.length-1);
            }
        }
        //遍历并删除越界雷
        for (int i=0;i<thunders.length;i++){
            if (thunders[i].isOutOfBounds()||thunders[i].isDead()){
                thunders[i]=thunders[thunders.length-1];
                thunders=Arrays.copyOf(thunders,thunders.length-1);
            }
        }
        //遍历并删除越界炸弹
        for (int i=0;i<bombs.length;i++){
            if (bombs[i].isOutOfBounds()||bombs[i].isDead()){
                bombs[i]=bombs[bombs.length-1];
                bombs=Arrays.copyOf(bombs,bombs.length-1);
            }
        }
    }
    private int score=0;//玩家得分
    /**深水炸弹与潜艇碰撞*/
    public void bombBangAction(){
        for (int i=0;i<bombs.length;i++) {
            Bomb b=bombs[i];
            for (int j=0;j<submariner.length;j++) {
                SeaObject s=submariner[j];
                if (b.isLive()&&s.isLive()&&s.isHit(b)){
                    b.goDead();
                    s.goDead();
                    if(s instanceof EnemyScore){
                        EnemyScore es= (EnemyScore) s;
                        score+=es.getScore();
                    }
                    if (s instanceof EnemyAaward){
                        EnemyAaward ea= (EnemyAaward) s;
                        int num=ea.getLife();
                        ship.addLife(num);
                    }
                }
            }
        }
    }
    /** 程序的执行 */
    void action() {
        //按空格触发扔炸弹
        KeyAdapter k=new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                //若按下空格执行
                if (e.getKeyCode()==KeyEvent.VK_SPACE){
                    Bomb obj =ship.shoot();
                    bombs=Arrays.copyOf(bombs,bombs.length+1);
                    bombs[bombs.length-1]=obj;
                }
                //按下左键执行
                if (e.getKeyCode()==KeyEvent.VK_LEFT){
                    if (ship.x>0) {
                        ship.moveLeft();
                    }
                }
                //按下右键执行
                if (e.getKeyCode()==KeyEvent.VK_RIGHT){
                    if (ship.x<WIDTH-ship.width) {
                        ship.moveRight();
                    }
                }
                //esc暂停
                if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
                    stop=!stop;
                }
            }
        };
        this.addKeyListener(k);

        Timer timer=new Timer();
        int interval=10;

        //创建TimerTask的匿名内部类
        timer.schedule(new TimerTask() {
            /** 重写run方法， */
            public void run() {//定时干的事
                //暂停
                if (stop) {
                    timer.cancel();
                }
                submarinerEnterAction();//潜艇入场
                thunderEnterAction();//雷入场
                steoAction();//海洋对象移动
                outOfBoundsAction();
                bombBangAction();//深水炸弹与潜艇碰撞
                repaint();//重画(重新调用paint()方法)
            }
        }, interval, interval);
    }

    /** 重写paint()画  g:画笔 */
    public void paint (Graphics g){
        Images.sea.paintIcon(null,g,0,0);
        ship.paintImage(g);
        for (int i=0;i<submariner.length;i++){
            submariner[i].paintImage(g);
        }
        for (int i=0;i<thunders.length;i++){
            thunders[i].paintImage(g);
        }
        for (int i=0;i<bombs.length;i++){
            bombs[i].paintImage(g);
        }
        g.drawString("SCORE  "+score,200,50);
        g.drawString("LIFT  "+ship.gitLift(),400,50);
    }
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        World world=new World();
        world.setFocusable(true);
        frame.add(world);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH+16,HEIGHT+39);
        frame.setLocationRelativeTo(null);
        //设置窗口可见并尽快调用paint()方法
        frame.setVisible(true);

        world.action();//启动程序的执行
    }
}
