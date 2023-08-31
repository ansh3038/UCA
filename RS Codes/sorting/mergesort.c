#include<stdio.h>
#include<stdlib.h>

void merge(int *arr, int start, int mid, int end){
    int subarray = mid-start +1;
    int subarray2 = end - mid;

    int arr1[subarray2];
    int arr2[subarray2];

    for(int i = 0;i<subarray;i++){
        arr1[i] = arr[start+i];
    }
    for(int i = 0;i<subarray2;i++){
        arr2[i] = arr[i+mid+1];
    }
    int i = 0, j = 0, k = start;
    while(i<subarray && j<subarray2){
        if(arr1[i]<arr2[j]){
            arr[k++] = arr1[i++];
        }
        else{
            arr[k++] = arr2[j++];
        }
    }
    while(i<subarray){
        arr[k++] = arr1[i++];
    }
    while(j<subarray2){
        arr[k++] = arr2[j++];
    }
}

void mergeSort(int *arr, int start, int end){
    if(start>=end){
        return;
    }
    int mid = start+end;
    mid/=2;
    mergeSort(arr,start,mid);
    mergeSort(arr,mid+1,end);
    merge(arr,start,mid,end);
}
int main(){
    int arr[] = {6,4,3,1,7,86,23};
    mergeSort(arr,0,7-1);
    for(int i = 0; i<7 ; i++){
        printf("%d ",arr[i]);
    }
    
}