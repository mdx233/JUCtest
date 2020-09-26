package Music;

public class Piano extends Instrument{

    @Override
    public void makeSound() {
        System.out.println("钢琴音");
        System.out.println(this);
    }
}
