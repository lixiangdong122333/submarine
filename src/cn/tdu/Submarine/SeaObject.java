package cn.tdu.Submarine;

import java.util.Random;
import javax.swing.ImageIcon;
import java.awt.Graphics;
/**海洋对象*/
public abstract class SeaObject {
    //声明两个常量用于表示生或死
    public static final int LIVE=0;
    public static final int DEAD=1;
    //当前状态，默认初始为活着的
    protected int state=LIVE;
    //宽
    protected int width;
    //高
    protected int height;
    //x坐标
    protected int x;
    //y坐标
    protected int y;
    //移动速度
    protected int speed;

    //潜艇使用的构造方法，图片大小需要传参，需要写活，其他完全一致，直接写死
    public SeaObject(int width, int height){
        Random random=new Random();
        this.width=width;
        this.height=height;
        x=-width;
        y=random.nextInt(World.HEIGHT-height-150+1)+150;
        speed=random.nextInt(3)+1;
    }
    //雷类使用的构造方法
    SeaObject(int width,int height,int x,int y,int speed){
        this.width=width;
        this.height=height;
        this.x=x;
        this.y=y;
        this.speed=speed;
    }

    //战舰移动的抽象方法
     public abstract void step();
    //导入图片的抽象方法
    public abstract ImageIcon getImage();
    //判断是否活着
    public boolean isLive(){
        return state==LIVE;
    }
    //判断是否死了
    public boolean isDead(){
        return state==DEAD;
    }
    //画图片
    public void paintImage(Graphics g){
        //如果活着
        if (isLive()) {
            getImage().paintIcon(null, g, x, y);
        }
    }
    //生成并返回雷对象
    public SeaObject shootThunder(){
        //根据潜艇原点的位置计算出雷的生成位置
        int x=this.x+this.width;
        int y=this.y-5;
        if (this instanceof TorpedoSubmarine){
            return new Torpedo(x,y);
        }else if (this instanceof MineSubmarine){
            return new Mine(x,y);
        }else {
            return null;
        }
    }
    /**潜艇越界检查*/
    public boolean isOutOfBounds(){
        return this.x>=World.WIDTH;
    }
    /**检测碰撞*/
    public boolean isHit(SeaObject other){
        int x1=this.x-other.width;
        int x2=this.x+this.width;
        int y1=this.y-other.height;
        int y2=this.y+this.height;
        int x=other.x;
        int y=other.y;
        return x>=x1&&x<=x2&&y>=y1&&y<=y2;
    }
    /**更改存活状态*/
    public void goDead(){
        state=DEAD;
    }

}
