public class selectionsort {
    public static void main (String[] args)
    {
        //升序
        int a[] = new int[5];
        a[0]=3;
        a[1]=4;
        a[2]=1;
        a[3]=5;
        a[4]=2;

        //选择排序法
        int temp;
       for(int i=0;i<a.length;i++)
       {
           int lowIndex = i;
           //找出最小的一个索引
           for(int j=i+1;j<a.length;j++)
           {
               if(a[j]<a[lowIndex])
               {
                   lowIndex = j;
               }
           }
           //交换
           temp = a[i];
           a[i]=a[lowIndex];
           a[lowIndex]=temp;

        }
        for (int i:a
             ) {
           System.out.println("i="+ i);

        }
    }
}
