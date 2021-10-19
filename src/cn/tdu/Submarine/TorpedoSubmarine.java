package cn.tdu.Submarine;

import javax.swing.*;

//鱼雷潜艇类
public class TorpedoSubmarine extends SeaObject{
    /**构造方法*/
    TorpedoSubmarine(){
        super(64,20);
    }
    public void step(){
        //向右移动
        x+=speed;
    }

    @Override
    public ImageIcon getImage() {
        return Images.torpesubm;
    }
}
