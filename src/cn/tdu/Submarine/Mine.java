package cn.tdu.Submarine;
//水雷类
public class Mine extends  SeaObject{

    /**构造方法*/
    Mine(int x,int y){
        width=11;
        height=11;
        this.x=x;
        this.y=y;
        speed=1;
    }
}
