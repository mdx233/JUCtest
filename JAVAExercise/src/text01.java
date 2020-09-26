import java.util.Scanner;

public class text01 {
    static{
        System.out.println("1");
    }
    public static void main(String[] arg){
        wuhu dasima = new wuhu();
        dasima.setQifei("这波啊，这波是肉蛋葱鸡");
        dasima.setHero("啤酒人");
        dasima.setXiafan("拖，就硬拖！");

        Scanner s = new Scanner(System.in);

        String zhubo = s.next();
        System.out.println(zhubo);
        if(zhubo.equals("大司马")){
            System.out.println(dasima.getHero());
            System.out.println(dasima.getQifei());
            System.out.println(dasima.getXiafan());
        }
        else{
            System.out.println("我不知道你说的什么jb");
        }

    }

    static{
        System.out.println("2");
    }
}
