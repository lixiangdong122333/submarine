package cn.tdu.Submarine;
//水雷类
public class Mine {
    int width;
    int height;
    int x;
    int y;
    int speed;
    /**构造方法*/
    Mine(int x,int y){
        width=11;
        height=11;
        this.x=x;
        this.y=y;
        speed=1;
    }
    void step(){
        System.out.println("水雷移动");
    }
}
