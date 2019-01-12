public class primenumber {
    //题目：判断101-200之间有多少个素数，并输出所有素数
    public static void main(String args[]){
        int i=0;
        math mymath = new math();
        for(i=2;i<=200;i++)
            if(mymath.prime(i)==true)
                System.out.println(i);
    }
}
class math
{
    public boolean prime(int x)
    {
        for(int i=2;i<=x/2;i++)
            if (x % i==0 )
                return false;
        return true;
    }

}
