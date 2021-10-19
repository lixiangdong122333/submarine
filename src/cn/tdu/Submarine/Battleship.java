package cn.tdu.Submarine;

import javax.swing.*;

//战舰类
public class Battleship extends SeaObject{
    //命
    int life;
    /**构造方法*/
    Battleship(){
        super(66,26,270,124,20);
        life=5;
    }
    public void step(){
    }

    @Override
    public ImageIcon getImage() {
        return Images.battleship;
    }
}
