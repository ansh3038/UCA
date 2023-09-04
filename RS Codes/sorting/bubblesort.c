#include <stdio.h>
int main(){
    int arr[5] = {5,4,3,2,1};
    // int *arr2 = {5,4,3,2,1};
    // int x = sizeof(arr)/sizeof(arr[0]);
    for(int i=0;i<5;i++){
        for(int j=0; j<5-i;j++){
            if(arr[j]>arr[j+1]){
                arr[j] = arr[j+1]^arr[j];
                arr[j+1] = arr[j+1]^arr[j];
                arr[j] = arr[j+1]^arr[j];
            }
        }

    }
    for(int i =0; i<5;i++) {
        printf("%d \n",arr[i]);
    }
}