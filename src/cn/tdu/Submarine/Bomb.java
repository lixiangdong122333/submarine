package cn.tdu.Submarine;

import javax.swing.*;

//深水炸弹类
public class Bomb extends SeaObject{
    /**构造方法*/
    Bomb(int x,int y){
        super(9,12,x,y,3);
    }
    public void step(){
        //向下移动
        y+=speed;
    }

    @Override
    public ImageIcon getImage() {
        return Images.bomb;
    }
    /**重写isOutOfBounds  检查炸弹越界*/
    public boolean isOutOfBounds(){
        return this.y>=World.HEIGHT;
    }
}
