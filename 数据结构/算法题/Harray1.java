public class Harray1 {

    private int[] array;
    private int size;

    public Harray1(int capacity)
    {
        this.array=new int[capacity];
        size=0;
    }

    public void insert(int element , int index)throws Exception{
        //判断访问下标是否超出范围
        if(index<0||index>size)
        {
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }
        //从右向左循环，将元素逐个往右挪1位
        for(int i=size-1; i>=i ;i--)
        {
            array[i+1]=array[index];
            size++
        }

        //输出数组

        public void output()
        {
            for(int i=0; i<size;i++)
            {
                System.out.println(array[i]);
            }
        }

        public static void main(String[] args)throw Exception{

            
        }
    }
}
