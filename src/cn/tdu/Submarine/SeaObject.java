package cn.tdu.Submarine;

import java.util.Random;

/**海洋对象*/
public class SeaObject {
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
        y=random.nextInt(479-height-150+1)+150;
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

    //战舰移动
     public void step(){
        System.out.println("海洋对象移动");
    }
}
