public class ArrayDeque<T> {
    private T[] items;
    private int front;//First
    private int back;//Last
    private int factor=2;
    private int size;

    public ArrayDeque() {
        items = (T []) new Object[8];
        front = 0;
        back = 1;
        size=0;
    }

    public  boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }

    //when size=items.length, back=front+1
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int i = (front+1)%items.length;
        int count=1;
        for (; count<size+1; count++) {
            a[count]=items[i];
            i= (i+1)%items.length;
        }
        front=0;
        back=size+1;
        items = a;
    }

    public void addLast(T x) {
        if (size == items.length) {
            resize(size*factor);
        }
        items[back] = x;
        back =(back+1)%items.length;
        size++;
    }

    public void addFirst(T x){
        if(size==items.length){
            resize(size*factor);
        }
        items[front]=x;
        front=(front+items.length-1)%items.length;
        size++;
    }

    public void printDeque(){
        if(!isEmpty()) {
            int i = (front+1)%items.length;
            int count=0;
            for (; count<size; count++) {
                System.out.print(items[i]);
                System.out.print(" ");
                i= (i+1)%items.length;
            }
        }
    }

    public T removeLast() {
        if (isEmpty()){
            return null;
        }
        if(size/(double)items.length<0.25){
            resize(items.length/4+1);
        }
        back=(back+items.length-1)%items.length;
        size--;
        return items[back];
    }

    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        if (size/(double)items.length<0.25){
            resize(items.length/4+1);
        }
        front =(front+1)%items.length;
        size--;
        return items[front];
    }

    public T get(int i) {
        if (isEmpty()){
            return null;
        }
        int k = (front+1)%items.length;
        int count=1;
        for (; count<i; count++)
            k= (k+1)%items.length;
        return items[k];
    }

    public int size() {
        return size;
    }

    public static void main(String args[]){
        ArrayDeque<String> aq=new ArrayDeque<String>();
        aq.addFirst("a");
        aq.addFirst("b");
        aq.addLast("c");
        System.out.print(aq.get(2));
        aq.removeLast();
        aq.removeLast();
        aq.printDeque();

    }

}

