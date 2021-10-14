package cn.tdu.Submarine;

import java.util.Random;

//鱼雷潜艇类
public class TorpedoSubmarine {
    int width;
    int height;
    int x;
    int y;
    int speed;
    /**构造方法*/
    TorpedoSubmarine(){
        Random random=new Random();
        width=64;
        height=20;
        x=-width;
        y=random.nextInt(479-height-150+1)+150;
        speed=random.nextInt(3)+1;

    }
    void step(){
        System.out.println("鱼雷潜艇移动");
    }
}
