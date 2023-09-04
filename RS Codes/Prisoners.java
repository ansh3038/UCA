class Prisoners{
    private int Black = -1;
    private int White = 1;
    private int prisoners[];
    public Prisoners(int n){
        prisoners = new int[n];
        for(int i =0; i<n; i++){
            prisoners[i] = (int)(Math.random()*100)%2==0 ? Black : White;
        }   
    }
    public int getCode( int p ){
        int code=1;
        for(int i =0; i<p;i++){
            code*=prisoners[i];
        }
        return code;
    }
    public boolean deadOrAlive(int p, int c){
        return c ==prisoners[p];
    }
}
class Solution{
    public static void main(String[] args) {
        int n =10;
        int expectedcode = 1;
        Prisoners p = new Prisoners(n);
        for(int i= n-1;i>=0;i++){
            int code = p.getCode(i)*expectedcode;
            if(p.deadOrAlive(i, code)){
                System.out.println("You are safe");
            }
            else{
                System.out.println("Dead");
            }
            expectedcode = code*expectedcode;
        }

    }
}