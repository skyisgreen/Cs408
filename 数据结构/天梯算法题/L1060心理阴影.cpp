#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	int x,y; 
	scanf("%d %d",&x,&y);
	int s=5000;
	s=s-(100-x)*y;
	s=s-(100-x)*(100-y)/2;
	s=s-x*y/2;
	printf("%d",s);
	return 0;
}
