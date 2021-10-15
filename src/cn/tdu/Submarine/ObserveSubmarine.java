package cn.tdu.Submarine;

import java.util.Random;

//侦察潜艇类
public class ObserveSubmarine extends SeaObject{
    /**构造方法*/
    ObserveSubmarine(){
        Random random=new Random();
        width=63;
        height=19;
        x=-width;
        y=random.nextInt(479-height-150+1)+150;
        speed=random.nextInt(3)+1;
    }
}
