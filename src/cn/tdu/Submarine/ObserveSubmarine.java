package cn.tdu.Submarine;

import javax.swing.*;

//侦察潜艇类
public class ObserveSubmarine extends SeaObject{
    /**构造方法*/
    ObserveSubmarine(){
        super(63,19);
    }

    public void step(){
        //向右移动
        x+=speed;
    }

    @Override
    public ImageIcon getImage() {
        return Images.obsersubm;
    }

}
