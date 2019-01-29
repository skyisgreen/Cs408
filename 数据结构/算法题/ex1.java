import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。
//1.程序分析：关键是计算出每一项的值。
public class ex1 {
    public static void main(String[] args) throws IOException
    {
        int s =0;
        String output="";
        BufferedReader stadin =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入a的值：");
        String input = stadin.readLine();
        for(int i=1 ;i<=Integer.parseInt(input);i++)
        {
            output+=input;
            int a=Integer.parseInt(output);
            s+=a;
        }
        System.out.println(s);
    }

}
