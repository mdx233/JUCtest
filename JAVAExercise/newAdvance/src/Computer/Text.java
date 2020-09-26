package Computer;

public class Text {
    public static void main(String[] args) {
        MacBook myMac = new MacBook();
        InsertDrawable mouse = new Mouse();
        InsertDrawable display = new Display();
        InsertDrawable keyboard = new KeyBoard();
        InsertDrawable dayingji = new Machine();

        myMac.setInsert(mouse);

        myMac.order();

        System.out.println(myMac.getClass().getName());

        System.out.println("==========================");

        int[][] a = {
            {1,2,3},
            {1,2,3},
            {1,2,3},
            {1,2}
        };

    }
}
