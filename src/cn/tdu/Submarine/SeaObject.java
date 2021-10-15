package cn.tdu.Submarine;

import javax.swing.text.html.MinimalHTMLWriter;
import java.util.Random;

/**海洋对象*/
public class SeaObject {
    //宽
    int width;
    //高
    int height;
    //x坐标
    int x;
    //y坐标
    int y;
    //移动速度
    int speed;
    //战舰移动
    //*三种潜艇专供*/
    //图片大小需要传参，需要写活，其他完全一致，直接写死
    SeaObject(int width, int height){
        Random random=new Random();
        this.width=width;
        this.height=height;
        x=-width;
        y=random.nextInt(479-height-150+1)+150;
        speed=random.nextInt(3)+1;
    }
    SeaObject(int width,int height,int x,int y,int speed){
        this.width=width;
        this.height=height;
        this.x=x;
        this.y=y;
        this.speed=speed;
    }


    void step(){
        System.out.println("海洋对象移动");
    }
}
