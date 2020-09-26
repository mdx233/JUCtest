package Room;

import java.util.Scanner;

public class HotelText {
    public static void main(String[] args) {

        Hotel hotel = new Hotel();


        while (true){
            System.out.println("1.查看全部房间信息");
            System.out.println("2.预订房间");
            System.out.println("3.退订房间");
            System.out.println("0.退出系统");
            Scanner sc = new Scanner(System.in);
            Scanner c = new Scanner(System.in);
            int i = sc.nextInt();
            if(i == 1){
                hotel.Order(1);
            }
            else if(i == 2){
                System.out.println("请输入房间号");
                int no = c.nextInt();
                hotel.Order(2,no);
            }
            else if(i == 3){
                System.out.println("请输入房间号");
                int no = c.nextInt();
                hotel.Order(3,no);
            }
            else if(i == 0){
                return;
            }
            else {
                System.out.println("输入信息错误，请重新输入！");
            }
        }
    }
}
