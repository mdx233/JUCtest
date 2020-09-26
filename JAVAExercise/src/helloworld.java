public class helloworld {
    public static  void main(String[] args){
        int i,j;
        int count=0;
        Boolean flag;

        for(i=2;i<=10000;i++){
            flag = true;

            for(j=1;j<=i;j++){
                if(i % j == 0 && j != 1 && j != i){
                    flag = false;
                }
            }
            if(count == 8){
                count = 0;
                System.out.print('\n');

            }
            if(flag){
                System.out.print(i);
                System.out.print(' ');
                count++;
            }
        }

    }
}