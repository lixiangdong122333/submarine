package cn.tdu.Submarine;
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.lang.reflect.Array;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Arrays;
/*整个游戏世界*/
public class World extends JPanel {
    public static final int WIDTH=641;
    public static final int HEIGHT=479;

    //战舰
    private Battleship ship=new Battleship();
    //潜艇数组
    private SeaObject[] submariner={};
    //雷数组
    private SeaObject[] thunders={};
    //炸弹数组
    private Bomb[] bombs={};
    /**返回一个潜艇类型*/
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
    /** 程序的执行 */
    void action() {
        Timer timer=new Timer();
        int interval=10;
        //创建TimerTask的匿名内部类
        timer.schedule(new TimerTask() {
            /** 重写run方法， */
            public void run() {//定时干的事
                submarinerEnterAction();//潜艇入场
                thunderEnterAction();//雷入场
                steoAction();//海洋对象移动

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
