#include<stdio.h>
#include<stdlib.h>

void push(int *arr, int *size, int val){
    int n = sizeof(arr)/sizeof(arr[0]);
    if(size==n-1){
        printf("queue is full");
        return;
    }
    arr[*size++] = val;
}
int pop(int *arr, int *size){
    if(size ==-1){
        return -1;
    }
    else{
        if(*size==0){
            return arr[*size--];
        }
        else{
            int a = arr[0];
            for(int i = 0; i<*size-1;i++){
                arr[i] = arr[i+1];
                *size--;
            }
            return a;
        }
    }
}
int main(){
    int arr[7];
    int capacity = 7;
    int size = -1;
    int pointer=0;

    // int n=7;


}