#include <stdio.h>
int setbits(int number){
	int ans = 0;
	while(number !=0){
		if((number&1)==1){
			ans++;
		}
		number>>=1;
	}
}
