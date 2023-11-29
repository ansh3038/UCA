#include <stdio.h>
#include <stdlib.h>

int merge(int *arr, int s, int mid, int e){
    int sub1 = mid - s + 1;
    int sub2 = e - mid; 
    int arr1[sub1];
    int arr2[sub2];
    for(int i = 0; i < sub1; i++){
        arr1[i] = arr[i + s]; 
    }  
    for(int j = 0; j < sub2; j++){
        arr2[j] = arr[j + mid + 1];
    }
    int i = 0;
    int j = 0;
    int k = s;
    int swap = 0;
    while(i < sub1 && j < sub2){
        if(arr1[i] <= arr2[j]){
            arr[k++] = arr1[i++]; 
        }
        else {
            arr[k++] = arr2[j++];  
            swap++;          
        }
    } 
    while(i < sub1){
        arr[k++] = arr1[i++];
    }
    while(j < sub2){
        arr[k++] = arr2[j++];
    }
    return swap;
}

int mergesort(int *arr, int s, int e){
    if(s < e){
        int swaps = 0;
        int mid = (s + e) / 2;
        swaps = mergesort(arr, s, mid);
        swaps += mergesort(arr, mid + 1, e);
        swaps += merge(arr, s, mid, e);
        return swaps;
    }
    return 0;
}

int main(){
    int arr[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    int swaps = mergesort(arr, 0, 9);
    printf("%d", swaps);
    return 0;
}
