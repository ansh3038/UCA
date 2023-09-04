//DP question triangle 21st august
class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        int arr[][] = new int [n][m];
        int sum = 99999;
        arr[0][0]= triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    arr[i][j] = arr[i-1][j] + triangle.get(i).get(j);
                    continue;
                }
                if(j==i){
                    arr[i][j] = arr[i-1][j-1] + triangle.get(i).get(j);
                    continue;
                }
                arr[i][j] = Math.min(arr[i-1][j-1],arr[i-1][j]) + triangle.get(i).get(j);
            }

        }
        for(int i =0;i<m;i++){
            if(arr[n-1][i]<sum){
                sum = arr[n-1][i];
            }
        }
        return sum;        
    }
}