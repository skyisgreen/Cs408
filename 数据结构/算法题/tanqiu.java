//球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，
// 求它在第10次落地时，共经过多少米？第10次反弹多高？
public class tanqiu {
    public static void main(String[] args)
    {
        double s=0;
        double t=100;
        for(int i=1;i<=10;i++)
        {
            s+=t;
            t=t/2;
        }
        System.out.println(s);
        System.out.println(t);
    }
}
