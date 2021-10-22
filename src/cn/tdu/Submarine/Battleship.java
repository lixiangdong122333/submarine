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
    /**生成深水炸弹*/
    public Bomb shoot(){
        return new Bomb(this.x,this.y);
    }
    public void moveLeft(){
        x-=speed;
    }
    public void moveRight(){
        x+=speed;
    }
    public void addLife(int num){
        life+=num;
    }
    public int gitLift(){
        return life;
    }
}
