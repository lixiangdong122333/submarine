package cn.tdu.Submarine;

import java.util.Random;

//侦察潜艇类
public class ObserveSubmarine extends SeaObject{
    /**构造方法*/
    ObserveSubmarine(){
        super(63,19);
    }

    void step(){
        //向右移动
        x+=speed;
    }

}
