public class test {
    int[] a=new int[5];

    public test(){
        a[0]=0;
        a[1]=1;
        a[2]=2;
        a[3]=3;
        a[4]=4;
    }
    public int methods1(int i)
            throws RuntimeException,ArithmeticException,IndexOutOfBoundsException
    {
        if(i==0){
            throw new ArithmeticException();
        }
        if(i>4){
            throw new IndexOutOfBoundsException();
        }
        return 10/i;
    }

    public static void main(String args[]){
        try{
            test demo=new test();
            demo.methods1(0);
            demo.methods1(5);
        } catch (ArithmeticException ex){
            System.out.print(ex);
        } catch (IndexOutOfBoundsException ex){
            System.out.print(ex);
        }
    }
}
