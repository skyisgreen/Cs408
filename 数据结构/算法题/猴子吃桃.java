public class 猴子吃桃 {
    static int total(int day)
    {
        if(day==10)
        {
            return 1;
        }
        else{
            return (total(day+1)+1)*2;
        }
    }
public static void main(String[] args)
{
    System.out.println(total(1));
}
}
