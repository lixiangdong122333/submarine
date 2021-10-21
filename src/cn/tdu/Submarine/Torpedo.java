package cn.tdu.Submarine;

import javax.swing.*;

//鱼雷类
public class Torpedo extends SeaObject{
    /**构造方法*/
    Torpedo(int x,int y){
        super(5,18,x,y,1);
    }
    public void step(){
        //向上移动
        y-=speed;
    }

    @Override
    public ImageIcon getImage() {
        return Images.torpedo;
    }
    /**重写isOutOfBounds  检查鱼雷越界*/
    public boolean isOutOfBounds(){
        return this.y<=0-this.height;
    }
}
