public class Recursion {
    public static void main(String[] args){
        int b = 4;

        long begin = System.currentTimeMillis();
        System.out.println("some ++b that result is " + some(++b));
        long end1 = System.currentTimeMillis();
        System.out.println("第一个递归耗时"+(end1-begin)+"毫秒");
        System.out.println("some b that result is " + some(b));
        long end2 = System.currentTimeMillis();
        System.out.println("第二个递归耗时"+(end2-end1)+"毫秒");
    }

    public static int some(int i){
       System.out.println("some" + i);
       if(i == 1){
           return 1;
       }
       return i * some(--i);
    }
}
