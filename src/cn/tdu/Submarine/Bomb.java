package cn.tdu.Submarine;
//深水炸弹类
public class Bomb extends SeaObject{
    /**构造方法*/
    Bomb(int x,int y){
        super(9,12,x,y,3);
    }
    void step(){
        //向下移动
        y+=speed;
    }
}
