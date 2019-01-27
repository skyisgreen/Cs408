import javax.swing.*;

public class yunsuanfu {
    public static void main(String[] args){
        String str="";
        str=JOptionPane.showInputDialog("请输入N的值（输入exit退出）：");
        int N;
        N=0;
        try{
            N=Integer.parseInt(str);
        }
        catch(NumberFormatException e){
            e.printStackTrace();
        }
        str=(N>90?"A":(N>60?"B":"C"));
        System.out.println(str);
    }

}
