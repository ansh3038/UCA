#include<stdio.h>
#include<stdlib.h>

int partition(int *arr, int s, int e){
    int pivot = arr[e];
    int i = s;
    for(int j = s; j<e; j++){
        if(arr[j]>pivot){
            int temp = arr[i];
            arr[i] = arr[j];  
            arr[j] = temp;  
            i++;              
        }
    }
    int temp = arr[e];
    arr[e] = arr[i];
    arr[i] = temp;
    return i;
}

int  quicksort(int k, int *arr, int s, int e){
    if(s>e){
        return arr[s];
    }
    int p = partition(arr,s,e);
    if(p>k){
        return quicksort(k, arr, s,p-1);
    }
    else if(p<k){
        return quicksort(k,arr,p+1,e);
    }
    else{
        return arr[p];
    }
}
int main(){
   int a = 1;
   int arr[] = {5,4,3,7,2,1};
   int ans = quicksort(a-1, arr,0,6); 
   printf("%d",ans);
}