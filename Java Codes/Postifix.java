import java.util.Stack;

public class Postifix {
    public static int calculate(String str){
        int ans = 0;
        char ch[] = str.toCharArray();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<ch.length;i++){
            if(ch[i]<='9' && ch[i]>='0'){
                st.push(ch[i]-'0');
            }
            else if(ch[i]=='+'){
                ans=st.pop()+st.pop();
                st.push(ans);
            }
            else if(ch[i]=='-'){
                ans=-(st.pop()-st.pop());
                st.push(ans);
            }
            else if(ch[i]=='*'){
                ans=st.pop()*st.pop();
                st.push(ans);
            }
            else if(ch[i]=='/'){
                int a = st.pop();
                int b = st.pop();
                ans=b/a;
                st.push(ans);
            }

        }
        return ans;
    }
    public static void print(String str){
        int ans = calculate(str);
        System.out.println(str + " " +ans);
    }
    public static void main(String[] args) {
                print("32+5*");
                print("22+8*");
        
    }
    
}
