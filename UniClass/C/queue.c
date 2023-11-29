#include <stdio.h>
#include <stdlib.h>
int size;
int* create(){
	int *arr = (int*)(malloc(sizeof(int)*100));
	return arr;
	size = 0;
}

void insert(int* a, int value){
	if(size==99){
	printf("queue full");
	return;
	}
	a[size] = value;
	size++;

}

int rem(int *a){
	if(size==0){
		return -1;
	}
 	int temp = a[0];
	for(int i = 0;i<size;i++){
		a[i] = a[i+1];
	}
	return temp;
	size--;
	
}

void delete(int *a){
	free(a);
	size=-1;
}


int main(){
	int *arr = create();
	insert(arr, 5);
	insert(arr, 4);
	insert(arr, 3);
	insert(arr, 2);
	printf("%d ",rem(arr));
	printf("%d ",rem(arr));
	printf("%d ",rem(arr));
	printf("%d ",rem(arr));
	delete(arr);
}

