package cn.tdu.Submarine;

//水雷潜艇类
public class MineSubmarine extends SeaObject{
    /**构造方法*/
    MineSubmarine(){
        super(63,19);
    }
    public void step(){
        //向右移动
        x+=speed;
    }
}
