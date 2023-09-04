public class Karatsuba {
    public static String add(String str, String str1) {
        int i = str.length() - 1;
        int j = str1.length() - 1;
        String ans = "";
        int carry = 0;
    
        while (i >= 0 || j >= 0) {
            int digit1 = (i >= 0) ? str.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? str1.charAt(j) - '0' : 0;
    
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            
            ans = sum + ans;
    
            if (i >= 0) {
                i--;
            }
            if (j >= 0) {
                j--;
            }
        }
    
        if (carry > 0) {
            ans = carry + ans;
        }
    
        return ans;
    }
    

    public static long karatsuba(String str, String str1){
        
        if(str.length()==1 && str1.length()==1){
            return (str.charAt(0)-'0')*(str1.charAt(0)-'0');
        }

        int n = Math.max(str.length(), str1.length());
        n = (int)Math.ceil(n/2);
        if(str.length()<str1.length()){
            for(int i = str.length();i<str1.length();i++){
                str = '0'+ str;
            }
        }

        else if(str.length()>str1.length()){
            for(int i = str1.length();i<str.length();i++){
                str1 = '0'+ str1;
            }
        }
        n++;
        String xl = str.substring(0, n);
        String yl = str1.substring(0,n);
        String xr = str.substring(n);
        String yr = str1.substring(n);

        long a = karatsuba(xl, yl);
        long c = karatsuba(xr, yr);
        long d = karatsuba(add(xr,xl),add(yl,yr));
        long b = ((long)Math.pow(10, n))*(d-a-c);
        if (b < 0) {
        b += (long) Math.pow(10, n * 2);
        }
        long ans=a*(long)Math.pow(10, n*2)+c+b;
        return ans;

    }
    public static void main(String[] args) {
        String str = "100";
        String str1 = "100";
        long ans = karatsuba(str,str1);
        System.out.println(ans);
        // assert(add(str,str1).equals("6912"));
        // System.out.println(add(str, str1));
    }
    
}
