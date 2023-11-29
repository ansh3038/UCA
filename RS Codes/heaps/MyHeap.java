class MyHeap{
    private int[] a;
    private int size = 0;
    private boolean reverse;

    public MyHeap(int capacity){
        this(capacity, false);
    }
    public MyHeap(int capacity, boolean reverse){
        a = new int[capacity];
        this.reverse = reverse;
    }
    
}