#include <stdio.h>
int power(int number) {
	if(number<0){
		number = -number;
	}
	int ans = number & (number-1);
	if(ans == 0) {
	return 1;
	}
 	return 0;
}

