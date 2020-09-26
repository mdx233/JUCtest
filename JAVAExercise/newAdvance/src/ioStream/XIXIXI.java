package ioStream;

import java.io.Serializable;

public class XIXIXI implements Serializable {
    private String name;
    private int no;

    public XIXIXI(String name, int no) {
        this.name = name;
        this.no = no;
    }

    public XIXIXI() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "XIXIXI{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }

}
