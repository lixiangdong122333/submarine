package cn.tdu.Submarine;

import javax.swing.*;

//鱼雷潜艇类
public class TorpedoSubmarine extends SeaObject implements EnemyScore{
    /**构造方法*/
    TorpedoSubmarine(){
        super(64,20);
    }
    public void step(){
        //向右移动
        x+=speed;
    }

    public ImageIcon getImage() {
        return Images.torpesubm;
    }

    public int getScore() {
        return 40;
    }
}
