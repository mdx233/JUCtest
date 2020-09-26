import java.util.Scanner;

public class Test01 {
    public static int n;
    public static int[] p = new int[11];
    public static boolean[] h = new boolean[11];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        generateP(1);
    }

    private static void generateP(int index) {
        //递归边界，需要返回值
        if(index == n+1){
            System.out.print("{");
            for (int i = 1;i <= n ;i++){
                System.out.print(p[i]);
            }
            System.out.print("}\n");
            return;
        }

        //递归调用
        for(int i=1;i<=n;i++){
            if(h[i] == false){
                p[index] = i;
                h[i] = true;
                generateP(index+1);
                h[i] = false;
            }
        }

    }
}
