public class text {

    public static void main(String[] args){


        java.util.Scanner s = new java.util.Scanner(System.in);
        System.out.print("请输入学生成绩：");
        double z = s.nextDouble();
        int c = (int)z/10;
        if(z<0||z>100){
            System.out.println("输入数据应该在【0-100】之间");
        }
        else{
            switch (c){
                case  10 : case 9 :
                    System.out.println('A');
                    break;
                case 8 :
                    System.out.println('B');
                    break;
                case 7 :
                    System.out.println('C');
                case 6 :
                    System.out.println('D');
                default:
                    System.out.println('E');
            }
        }


    }

}
