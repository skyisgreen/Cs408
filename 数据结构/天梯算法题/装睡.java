import java.util.Scanner;

public class 装睡 {
    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();

         for(int i=0;i<n;++i)   //while(n-->0)循环n次
        {
            String name =sc.next();
            int sm =sc.nextInt();
            int mb =sc.nextInt();

            if(sm<15||sm>20||mb<50||mb>70)
            {
                System.out.println(name);
            }
        }
    }

}
