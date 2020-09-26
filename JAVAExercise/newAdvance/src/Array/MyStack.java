package Array;

public class MyStack {
    private Object[] elements;
    private int index;

    public MyStack(Object[] elements) {
        this.elements = elements;
        this.index = 0;
    }

    public MyStack() {
        Object[] elements = new Object[10];
        this.index = 0;
        this.elements = elements;
    }

    public void Push(Object elements){
        if(this.index >= this.elements.length){
            System.out.println("压栈失败！");
        }
        else{
            this.elements[index] = elements;
            ++this.index;
            System.out.println("压栈成功！当前栈内元素有"+index+"个");
        }
    }

    public void Pop(){
        if(this.index <= 0){
            System.out.println("弹栈失败！");
        }
        else{
            this.elements[index - 1] = null;
            --this.index;
            System.out.println("弹栈成功！当前栈内元素有"+index+"个");
        }
    }

    public Object[] getElements() {
        return elements;
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
