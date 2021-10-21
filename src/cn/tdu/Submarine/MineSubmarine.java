package cn.tdu.Submarine;

import javax.swing.*;

//水雷潜艇类
public class MineSubmarine extends SeaObject implements EnemyAaward{
    /**构造方法*/
    MineSubmarine(){
        super(63,19);
    }
    public void step(){
        //向右移动
        x+=speed;
    }

    public ImageIcon getImage() {
        return Images.minesubm;
    }

    @Override
    public int getLife() {
        return 1;
    }
}
