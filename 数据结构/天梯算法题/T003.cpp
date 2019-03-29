#include<stdio.h>
#include<string.h>
int main()
{   
  int y,n;
  int a,b,c,d;//各个位数上的值，a为千位，b为百位，c为十位，d为个位
  int f[10];
  int x=0;
  scanf("%d %d",&y,&n);
  for(int i=y;i<10000;i++)
  {
    a=i/1000;
    b=i/100%10;
    c=i%100/10;
    d=i%10;
    memset(f,0,sizeof(f));//将数组f中所以的元素初始化为0
    f[a]=1;
    if(f[b]!=1)
    f[b]=1;
    if(f[c]!=1)
    f[c]=1;
    if(f[d]!=1)
    f[d]=1;//将下标为a,b,c,d的数组元素赋值为1，若下标相同则不会赋值，最后计算数组中有几个为1的元素，则就是不同数字的个数
    int sum=0;
    for(int j=0;j<10;j++)
    {
      sum=sum+f[j];//计算为1的元素个数，即为不同数字的总和
    }
    if(sum==n&&x==0)
    {
      printf("%d %04d",i-y,i);
      x++;
    }
  }
  return 0;
}
