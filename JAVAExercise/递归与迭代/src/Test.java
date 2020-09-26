/**
 * 题目:假设有一个楼梯，每次只能走一步或者两步，求有几种方法可以走上楼梯。
 * n为楼梯层数
 *
 * 假设n=1，则说明只能走一层，设方法f(n)表示求出走上第n层的方法数。
 * f(1)=1
 * 假设方法n=2，则f(2)=2，走一步，或者走两步
 *
 * 题解:
 *
 * 有题目可知，每次只能迈1步或者2步，
 * 则走到每层楼梯的最上方只有两种情况，最后一次迈步只能为1步或者2步。
 *
 * 假设n=3
 * （1）最后一步迈一步，首先先到达第二层，则有f(2)种走法
 * （2）最后一步迈两步，首先先到达第一层，则有f(1)种走法
 * 将两种情况合起来，就是走上n=3层的全部走法
 * f(3)=f(1)+f(2)
 * 推出公式，在n不等于1或者2的情况下
 * f(1)=1
 * f(2)=2
 * f(n)=f(n-2)+f(n-1)
 *
 *
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(loop(40));
        System.out.println(f(40));
    }
    //迭代实现
    public static int loop(int n){
        if (n < 1) {
            throw new IllegalArgumentException(n+"不能小于1");
        }
        if(n==1||n==2){
            return n;
        }

        int one = 2;//最后只走一步，默认值为走到第二级台阶的走法,类似于f(n-1)
        int two = 1;//最后走两步，初始化值为走到第一级台阶的走法,类似于f(n-2)
        int sum = 0;

        for(int i= 3;i<= n;i++){
            sum = one + two;
            two = one;
            one = sum;

        }

        return sum;
    }
    //递归实现
    public static int f(int n){
        if (n < 1) {
            throw new IllegalArgumentException(n+"不能小于1");
        }
        if(n==1||n==2){
            return n;
        }

        return f(n-1)+f(n-2);
    }
}
