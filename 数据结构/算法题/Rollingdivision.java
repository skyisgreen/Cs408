import java.util.Scanner;

//题目：输入两个正整数m和n，求其最大公约数和最小公倍数。
//1.程序分析：利用辗除法。
public class Rollingdivision {
    public static int gcd(int m, int n)
    {
        while(true)
        {
            if((m=m%n)==0)
                return n;
            if((n=n%m)==0)
                return m;
        }
    }
    public static void main(String arg[]) throws Exception
    {
        Scanner chin = new Scanner(System.in);
        int a =chin.nextInt();
        int b =chin.nextInt();
        int c =gcd(a,b);
        System.out.println("最小公倍数："+a*b/c+"\n最大公约数："+c);////最小公倍数等于两数之积除以其最大公约数
    }

}
