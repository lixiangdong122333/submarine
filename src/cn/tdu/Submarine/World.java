package cn.tdu.Submarine;
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;
/*整个游戏世界*/
public class World extends JPanel {
    public static final int WIDTH=641;
    public static final int HEIGHT=479;
    /*
    //战舰
    Battleship ship=new Battleship();
    //潜艇数组
    SeaObject[] submariner={};
    //雷数组
    SeaObject[] thunders={};
    //炸弹数组
    Bomb[] bombs={};

     */


    private Battleship ship=new Battleship();
    private SeaObject[] submariner= {
            new ObserveSubmarine(),
            new TorpedoSubmarine(),
            new MineSubmarine()
    };
    private SeaObject[] thunders={
            new Torpedo(120,50),
            new Mine(260,100)
    };
    private Bomb[] bombs={
            new Bomb(200,190)
    };
    //存放测试代码
    void action() {

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

        world.action();
    }
}
