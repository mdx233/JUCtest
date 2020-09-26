package Date;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateText01 {
    public static void main(String[] args) {
        Date nowdate = new Date();
        SimpleDateFormat nowcndate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String cntime = nowcndate.format(nowdate);
        System.out.println(cntime);


    }
}
