#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int a,b;
	scanf("%d %d",&a,&b);
	
	if(b>0)
	{
		printf("%d/%d=%.2f",a,b,a*1.0/b);
	}
	else if(b<0)
	{
		printf("%d/(%d)=%.2f",a,b,a*1.0/b);
	}
	else{
		printf("%d/%d=Error",a,b);
	}
	return 0;
}
