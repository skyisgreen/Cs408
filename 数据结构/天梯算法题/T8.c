#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int n,i,j,len;
	char f;
	char str[32289];
	scanf("%d %c\n",&n,&f);
	gets(str);//从标准输入设备读字符串函数，其可以无限读取，
	//不会判断上限，以回车结束读取，所以程序员应该确保buffer的空间足够大，以便在执行读操作时不发生溢出。
	
	len = strlen(str);
	if(n>=len)
	{
		for(i=0;i<n-len;i++)
		{
			putchar(f);
		}
		
		for(j=0;str[j]!='\0';j++)//str[j]!='\0'表示字符串结束 
		{
			printf("%c",str[j]);
		}
	}
	else{
		for(i=len-n;str[i]!='\0';i++)
		{
				printf("%c",str[i]);
		}
	}
	return 0;
}
