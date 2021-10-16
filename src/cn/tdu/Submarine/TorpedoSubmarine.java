package cn.tdu.Submarine;

import java.util.Random;

//鱼雷潜艇类
public class TorpedoSubmarine extends SeaObject{
    /**构造方法*/
    TorpedoSubmarine(){
        super(64,20);
    }
    void step(){
        //向右移动
        x+=speed;
    }
}
