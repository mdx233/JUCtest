package Random;

import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RandomText01 {
    public static void main(String[] args) {
        int[] a = new int[100];
        Random random = new Random();
        for(int i= 0;i<100;i++){
            int n = random.nextInt(102);
            while (true){
                boolean flag = true;

                for(int j = i;j>=0;j--){
                    if(a[j] == n){
                        flag = false;
                    }
                }
                if(flag){
                    break;
                }
                else {
                    n = random.nextInt(102);
                }
            }
            a[i] = n;
        }

        Arrays.sort(a);
        for (int i=0;i<100;i++){
            System.out.println(a[i]);
        }
    }
}
