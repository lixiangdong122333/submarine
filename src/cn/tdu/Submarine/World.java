package cn.tdu.Submarine;
/*整个游戏世界*/
public class World {
    Battleship s;
    ObserveSubmarine os1;
    ObserveSubmarine os2;
    TorpedoSubmarine ts1;
    TorpedoSubmarine ts2;
    MineSubmarine ms1;
    MineSubmarine ms2;
    Torpedo t1;
    Torpedo t2;
    Mine m1;
    Mine m2;
    Bomb b1;
    Bomb b2;
    //存放测试代码
    void action(){
        s=new Battleship();
        s.width=1;
        s.height=2;
        s.life=3;
        s.step();
    }


    public static void main(String[] args) {
        World w=new World();
        w.action();
    }
}
