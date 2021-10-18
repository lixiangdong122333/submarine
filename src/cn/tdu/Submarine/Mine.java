package cn.tdu.Submarine;
//水雷类
public class Mine extends  SeaObject{

    /**构造方法*/
    Mine(int x,int y){
        super(11,11,x,y,1);
    }
    public void step(){
        //向上移动
        y-=speed;
    }
}
