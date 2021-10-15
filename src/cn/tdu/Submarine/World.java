package cn.tdu.Submarine;
/*整个游戏世界*/
public class World {
    Battleship s;
    ObserveSubmarine[] oses;
    TorpedoSubmarine[] tses;
    MineSubmarine[] mses;
    Torpedo[] ts;
    Mine[] ms;
    Bomb[] bs;
    //存放测试代码
    void action() {
        oses=new ObserveSubmarine[3];
        oses[0]=new ObserveSubmarine();
        oses[1]=new ObserveSubmarine();
        oses[2]=new ObserveSubmarine();
        for (ObserveSubmarine ose : oses) {
            System.out.println(ose.x + "," + ose.y);
            ose.step();
        }
    }


    public static void main(String[] args) {
        World w=new World();
        w.action();
    }
}
