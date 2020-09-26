package Music;

public class Test {
    public static void main(String[] args) {
        Instrument erhu = new Erhu();
        Instrument piano = new Piano();
        Instrument violin = new Violin();

        Musician dasima = new Musician();

        dasima.paly(erhu);
        dasima.paly(piano);
    }
}
