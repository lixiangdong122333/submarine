package cn.tdu.Submarine;
/*整个游戏世界*/
public class World {
    //战舰
    Battleship ship=new Battleship();
    //潜艇数组
    SeaObject[] submariner={};
    //雷数组
    SeaObject[] thunders={};
    //炸弹数组
    Bomb[] bombs={};

    //存放测试代码
    void action() {
        submariner=new SeaObject[3];
        submariner[0]= new ObserveSubmarine();
        submariner[1]= new MineSubmarine();
        submariner[2]= new TorpedoSubmarine();
        for (int i=0;i<submariner.length;i++){
            SeaObject s=submariner[i];
            System.out.println(s.x+","+s.y);
            s.step();
        }
        thunders=new SeaObject[2];
        thunders[0]=new Mine(233,221);
        thunders[1]=new Torpedo(123,223);
        for (int i=0;i<thunders.length;i++){
            SeaObject t=thunders[i];
            System.out.println(t.x+","+t.y);
            t.step();
        }
    }


    public static void main(String[] args) {
        World w=new World();
        w.action();
    }
}
