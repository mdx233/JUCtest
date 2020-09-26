package Array;

public class Text01 {
    public static void main(String[] args) {
        MyStack a = new MyStack(new Object[11]);
        for(int i=0 ;i < 11;i++){
            a.Push(i);
            for(int j = 0;j < a.getElements().length;j++){
                System.out.print(a.getElements()[j]);
            }
            System.out.println("");
            System.out.println("==================================");
        }
        for(int i=0 ;i < 11;i++){
            a.Pop();
            for(int j = 0;j < a.getElements().length;j++){
                System.out.print(a.getElements()[j]);
            }
            System.out.println("");
            System.out.println("==================================");
        }

    }


}
