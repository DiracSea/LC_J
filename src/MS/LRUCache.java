class LRUCache extends LinkedHashMap<Integer, Integer>{ // parent class
    // ordered dict
    private int capacity; 
    /*
    * Get the key / Check if the key exists
    * Put the key
    * Delete the first added key
    */

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true); 
        this.capacity = capacity; 
    }
    
    public int get(int key) {
        return super.getOrDefault(key, -1); 
    }
    
    public void put(int key, int value) {
        super.put(key, value);  
        
    }
    
    @Override 
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity; 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class LRUCache1{
    // HashMap + DoubleLinkedList 
    class DLinkedNode {
        int key; 
        int value; 
        DLinkedNode prev; 
        DLinkedNode next; 
    }
    
    private void addNode(DLinkedNode node) {
        // add the new node right after head 
        node.prev = head; 
        node.next = head.next; 
        
        head.next.prev = node; 
        head.next = node; 
    }
    
    private void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev; 
        DLinkedNode next = node.next; 
        
        prev.next = next; 
        next.prev = prev; 
    }
    
    private void moveToHead(DLinkedNode node) {
        // move certain node in between to the head 
        removeNode(node); 
        addNode(node); 
    }
    
    private DLinkedNode popTail() {
        // Pop the current tail 
        DLinkedNode res = tail.prev; 
        removeNode(res); 
        return res;
    }
    
    private Map<Integer, DLinkedNode> cache = new HashMap<>(); 
    private int size; 
    private int capacity; 
    private DLinkedNode head, tail; 
    
    public LRUCache(int capacity) {
        this.size = 0; 
        this.capacity = capacity; 
        
        head = new DLinkedNode(); 
        tail = new DLinkedNode(); 
        
        head.next = tail; 
        tail.prev = head; 
    }
    public int get(int key) {
        DLinkedNode node = cache.get(key); 
        
        if (node == null) return -1; 
        
        // move accessed node to the head; 
        moveToHead(node); 
        
        return node.value;
    }
        
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key); 
        
        if(node == null) {
            DLinkedNode newNode = new DLinkedNode(); 
            newNode.key = key; 
            newNode.value = value; 
            
            cache.put(key, newNode); 
            addNode(newNode); 
            
            ++size; 
            
            if(size > capacity) {
                // pop the tail 
                DLinkedNode tail = popTail(); 
                cache.remove(tail.key); 
                --size; 
            }
        }
        else {
            // update the tail
            node.value = value;
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */