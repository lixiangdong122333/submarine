package cn.tdu.Submarine;
import javax.swing.ImageIcon;
public class Images {
    public static ImageIcon sea;        //海洋图
    public static ImageIcon battleship; //战舰
    public static ImageIcon obsersubm;  //侦察潜艇
    public static ImageIcon torpesubm;  //鱼雷潜艇
    public static ImageIcon minesubm;   //水雷潜艇
    public static ImageIcon torpedo;    //鱼雷
    public static ImageIcon mine;       //水雷
    public static ImageIcon bomb;       //炸弹

    //静态块，初始化静态资源
    static {
        sea=new ImageIcon("img/sea.png");
        battleship=new ImageIcon("img/battleship.png");
        obsersubm=new ImageIcon("img/obsersubm.png");
        torpesubm=new ImageIcon("img/torpesubm.png");
        minesubm=new ImageIcon("img/minesubm.png");
        torpedo=new ImageIcon("img/torpedo.png");
        mine=new ImageIcon("img/mine.png");
        bomb=new ImageIcon("img/bomb.png");
    }

    public static void main(String[] args) {
        System.out.println(sea.getImageLoadStatus());
        System.out.println(battleship.getImageLoadStatus());
        System.out.println(obsersubm.getImageLoadStatus());
        System.out.println(torpesubm.getImageLoadStatus());
        System.out.println(minesubm.getImageLoadStatus());
        System.out.println(torpedo.getImageLoadStatus());
        System.out.println(mine.getImageLoadStatus());
        System.out.println(bomb.getImageLoadStatus());
    }
}
