class LRUCache {

    private class Node{
        int key,val;
        Node prev,next;
        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }

    private void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    private void insertFront(Node node){
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
    }
    private final int capacity;
    private final Node head=new Node(0,0),tail=new Node(0,0);
    private final Map<Integer,Node> map=new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))return -1;
        Node node=map.get(key);
        remove(node);
        insertFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value;
            remove(node);
            insertFront(node);
            return;
        }
        else if(map.size()==capacity){
            Node lru=tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
        //Insert new node
        Node node=new Node(key,value);
        insertFront(node);
        map.put(key,node);
    }
}
