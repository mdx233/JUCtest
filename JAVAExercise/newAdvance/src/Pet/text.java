package Pet;


public class text {
    public static void main(String[] args) {
        Master dasima = new Master();
        Pet dog = new Dog();
        Pet cat = new Cat();
        Pet yingwu = new YingWu();

        dasima.feed(dog);
        dasima.feed(cat);
        dasima.feed(yingwu);
    }
}
