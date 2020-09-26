package Room;

import java.util.Arrays;

public class Hotel {

    private Room[][] room;

    public Hotel() {
        room = new Room[3][5];
        for(int i = 0;i < 3;i++){
            for(int j= 0 ;j<5;j++){
                room[i][j] = new Room((i+1)*100+j+1,i,true);
            }
        }
    }

    private void  Reserve(int number){
        Room room = this.room[number/100-1][number%100-1];
        if(!room.isLive()){
            System.out.println("该房间已被预订，请重新预订！");
        }
        else {
            room.setLive(false);
            System.out.println("房间预订成功！");
        }
    }

    private void Check_Out(int number){
        Room room = this.room[number/100-1][number%100-1];
        if(room.isLive()){
            System.out.println("该房间未被预订，请先预订！");
        }
        else {
            room.setLive(true);
            System.out.println("房间退订成功！");
        }

    }

    private void Show_All(){
        for(int i = 0;i < room.length;i++){
            for(int j= 0 ;j< room[i].length;j++){
                System.out.println("房间号："+room[i][j].getNumber()+" 房间类型："+room[i][j].getType()+" 房间状态："+(room[i][j].isLive() ? "可预订":"已被预定"));
            }
        }
    }


    public  void Order(int number){
        if(number == 1){
            Show_All();
        }

    }


    public  void Order(int number,int index){
        if(number == 2){
            Reserve(index);
        }
        else if(number == 3){
            Check_Out(index);
        }
    }
}
