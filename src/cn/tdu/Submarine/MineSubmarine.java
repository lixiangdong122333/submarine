package cn.tdu.Submarine;

import java.util.Random;

//水雷潜艇类
public class MineSubmarine {
    int width;
    int height;
    int x;
    int y;
    int speed;
    /**构造方法*/
    MineSubmarine(){
        Random random=new Random();
        width=63;
        height=19;
        x=-width;
        y=random.nextInt(479-height-150+1)+150;
        speed=random.nextInt(3)+1;

    }
    void step(){
        System.out.println("水雷潜艇移动");
    }

}
