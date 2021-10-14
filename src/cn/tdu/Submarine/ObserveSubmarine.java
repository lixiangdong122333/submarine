package cn.tdu.Submarine;

import java.util.Random;

//侦察潜艇类
public class ObserveSubmarine {
    int width;
    int height;
    int x;
    int y;
    int speed;
    /**构造方法*/
    ObserveSubmarine(){
        Random random=new Random();
        width=63;
        height=19;
        x=-width;
        y=random.nextInt(311)+150;
    }
    void step(){
        System.out.println("侦察潜艇移动");
    }
}
