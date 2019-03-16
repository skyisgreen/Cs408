import java.util.Scanner;

public class 打印沙漏 {
    public static void main(String argc[])
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();

        if(s.length()==1&&n>0&&n<=1000)
        {
            char c =s.charAt(0);
            int row=0,rest=0;
            int tmp=n,num=1;
            boolean flag;
            while (true)
            {
                if(row==0)
                {
                    tmp -= num;
                    row += 1;
                    num += 2;
                }
                else
                {
                    tmp -= 2*num;
                    if(tmp<=0)
                    {
                        if (tmp==0)
                        {
                            flag=true;
                            row += 2;
                            break;
                        }
                    }
                    row += 2;
                    num += 2;
                }
            }
            if(flag)
            {
                rest = 0;
            }
            else
            {
                rest = tmp += 2*num;
            }
        }
    }
}
