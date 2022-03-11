public class LinkedListDeque<T> {
    public int size;
    public Node sentinel;

    //链表里的节点对象
    public class Node{
        public T item;
        public Node previous;
        public Node next;

        public Node(T i,Node previous,Node next){
            item=i;
            this.previous=previous;
            this.next=next;
        }

        public Node(Node previous,Node next){
            this.previous=previous;
            this.next=next;
        }
    }

    //返回链表总元素个数
    public int size(){
        return size;
    }

    //初始化，链表的真实首节点未知
    public LinkedListDeque(){
        sentinel=new Node(null,null);
        sentinel.previous=sentinel;
        sentinel.next=sentinel;
        size=0;
    }

    public void addFirst(T item){
        //建立新联系
        sentinel.next=new Node(item,sentinel,sentinel.next);
        //切断老联系
        sentinel.next.next.previous=sentinel.next;
        size+=1;
    }

    public void addLast(T item){
        //建立新联系
        sentinel.previous=new Node(item,sentinel.previous,sentinel);
        //切断老联系
        sentinel.previous.previous.next=sentinel.previous;
        size+=1;
    }

    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }

    public void printDeque(){
        if(!isEmpty()){
            Node p=sentinel.next;
            for(int i=0;i<size;i++){
                System.out.print(p.item);
                System.out.print(" ");
                p=p.next;
            }
        }
    }

    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        T i=sentinel.next.item;
        sentinel.next.next=sentinel.next.next.next;
        sentinel.next.next.previous=sentinel.next;
        size-=1;
        return i;
    }

    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        T i=sentinel.next.previous.item;
        sentinel.next.previous=sentinel.next.previous.previous;
        sentinel.next.previous.next=sentinel.next;
        size-=1;
        return i;
    }

    public T get(int index){
        if(!isEmpty()&&index<=size){
            Node p=sentinel;
            if(index==0){
                return p.previous.item;
            }
            for(int i=0;i<index;i++){
                p=p.next;
            }
            return p.item;
        }
        return null;
    }

    public T getRecursive(int index){
        if(index==0){
            return sentinel.previous.item;
        } else{
            return getRecursivehelp(sentinel,index);
        }
    }

    public T getRecursivehelp(Node p,int index){
        if(isEmpty()){
            return null;
        }
        if(index==0){
            return p.item;
        } else{
            return getRecursivehelp(p.next,index-1);
        }

    }

    public static void main(String args[]){
        LinkedListDeque<String> dq=new LinkedListDeque<>();
        dq.addFirst("B");
        dq.addFirst("A");
        dq.addLast("C");
        dq.printDeque();
        System.out.println(dq.getRecursive(0));
        System.out.println(dq.getRecursive(3));
    }
}
