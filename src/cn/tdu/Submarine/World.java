package cn.tdu.Submarine;
/*整个游戏世界*/
public class World {
    Battleship s;
    ObserveSubmarine os1;
    ObserveSubmarine os2;
    ObserveSubmarine os3;
    ObserveSubmarine os4;
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
        s= new Battleship();
        os1= new ObserveSubmarine();
        os2=new ObserveSubmarine();
        os3= new ObserveSubmarine();
        os4= new ObserveSubmarine();
        ts1=new TorpedoSubmarine();
        ts2=new TorpedoSubmarine();
        ms1=new MineSubmarine();
        ms2=new MineSubmarine();
        t1=new Torpedo(132,465);
        t2=new Torpedo(656,465);
        m1=new Mine(465,321);
        m2=new Mine(413,458);
        b1=new Bomb(457,456);
        b2=new Bomb(453,645);
        System.out.println(s.x+","+s.y+","+s.width+","+s.height+","+s.speed);
        System.out.println(os1.x+","+os1.y+","+os1.width+","+os1.height+","+os1.speed);
        System.out.println(os2.x+","+os2.y+","+os2.width+","+os2.height+","+os2.speed);
        System.out.println(os3.x+","+os3.y+","+os3.width+","+os3.height+","+os3.speed);
        System.out.println(os4.x+","+os4.y+","+os4.width+","+os4.height+","+os4.speed);
    }


    public static void main(String[] args) {
        World w=new World();
        w.action();
    }
}
