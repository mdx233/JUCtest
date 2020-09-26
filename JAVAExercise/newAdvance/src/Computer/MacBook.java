package Computer;

public class MacBook {
    private InsertDrawable insert;

    public MacBook(InsertDrawable insert) {
        this.insert = insert;
    }
    public MacBook() {
    }

    public InsertDrawable getInsert() {
        return insert;
    }

    public void setInsert(InsertDrawable insert) {
        this.insert = insert;
    }

    public void order(){
        this.insert.transfer();
    }
}
