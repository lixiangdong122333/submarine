package cn.tdu.Submarine;
//深水炸弹类
public class Bomb extends SeaObject{
    /**构造方法*/
    Bomb(int x,int y){//
        width=9;
        height=12;
        this.x=x;
        this.y=y;
        speed=3;
    }
}
