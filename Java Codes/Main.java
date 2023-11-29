class Main{
    public static void add(int data,LinkedList ans){
        LinkedList temp = ans;
        while(temp.next!=null){
            temp = temp.next;
        }        
        temp.next = new LinkedList(data);
    }

    public static LinkedList reverse(LinkedList li,LinkedList ans){
    if(li == null){
        return ans;
    }
    if(li.next == null){
        ans = new LinkedList(li.data);
    }
    reverse(li.next,ans);
    add(li.data,ans);
    return ans;

}
    public static void main(String[] args) {
        LinkedList li = new LinkedList(1);
        li.next= new LinkedList(2);

        li.next.next = (new LinkedList(3));
        li.next.next.next = (new LinkedList(4));
        li.next.next.next.next = (new LinkedList(5));
        LinkedList ans = null;
        ans = reverse(li,ans);
        while(ans != null){
            System.out.println(ans.data);
            ans = ans.next;
        }


    }
}
class LinkedList{
    int data;
    LinkedList next;
    LinkedList(int data){
        this.data = data;
        this.next = null;
    }

}

