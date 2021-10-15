package cn.tdu.Submarine;
//鱼雷类
public class Torpedo extends SeaObject{
    /**构造方法*/
    Torpedo(int x,int y){
        width =5;
        height=18;
        this.x=x;
        this.y=y;
        speed=1;
    }
}
