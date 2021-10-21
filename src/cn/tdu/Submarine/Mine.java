package cn.tdu.Submarine;

import javax.swing.*;

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

    @Override
    public ImageIcon getImage() {
        return Images.mine;
    }
    /**重写isOutOfBounds  检查水雷越界*/
    public boolean isOutOfBounds(){
        return this.y<=150-this.height;
    }
}
