public class bubblesort {
    public static void main (String[] args)
    {
        //需要排序的数组，目前是按照升序排列的
        int a[] = new int[5];
        a[0] = 300;
        a[1] = 4;
        a[2] = 500;
        a[3] = 10;
        a[4] = 100;

        //冒泡排序
        for(int i=0; i<a.length;i++)
        {
            for(int j=i+1;j<a.length;j++)//j+1开始，按照规则比a[i]大的都在它后面
            {
               if(a[i]>a[j])
               {
                   int temp =a[j];
                   a[j]=a[i];
                   a[i]=temp;
               }
            }
        }
        for(int i:a)
        {
            System.out.println("i:"+i);
        }
    }
}
