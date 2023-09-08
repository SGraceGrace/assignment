package java_practice;

public class Myclass {
    public static void run(int a)
    {
        a++;
        run(a);
    }
    public static void main(String args[])
    {
        try{
            run(10);
        }  
        catch(Error e)
        {
            e.printStackTrace();
            System.out.println("Caught");;
        }     
    }  
}

