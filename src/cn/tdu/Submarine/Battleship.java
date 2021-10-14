package cn.tdu.Submarine;
//战舰类
public class Battleship {
    //宽
    int width;
    //高
    int height;
    //x坐标
    int x;
    //y坐标
    int y;
    //移动速度
    int speed;
    //命
    int life;
    /**构造方法*/
    Battleship(){
        width=66;
        height=26;
        x=270;
        y=124;
        speed=20;
        life=5;
    }
    void step(){
        System.out.println("战舰移动");
    }
}
