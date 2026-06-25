// Last updated: 6/25/2026, 8:38:45 AM
class Node {
    int key;
    int val;
    Node left;
    Node right;

    public Node() {}
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    Node head;
    Node tail;
    int maxCap;

    Map<Integer, Node> nodeMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.right = tail;
        tail.left = head;
        this.maxCap = capacity;
    }

    private void add(Node t) {
        t.right = this.head.right;
        t.left = this.head;
        this.head.right.left = t;
        this.head.right = t;
        this.capacity -= 1;
        this.nodeMap.put(t.key, t);
    }

    private Node remove(Node t) {
        t.left.right = t.right;
        t.right.left = t.left;
        t.left = null;
        t.right = null;
        this.nodeMap.remove(t.key);
        this.capacity += 1;
        return t;
    }

    private void removeLast() {
        Node temp = this.tail.left;
        this.tail.left = temp.left;
        temp.left.right = this.tail;
        temp.left = null;
        temp.right = null;
        this.nodeMap.remove(temp.key);
        this.capacity += 1;

    }
    
    public int get(int key) {
        if(this.capacity == maxCap) return -1;
        if(nodeMap.containsKey(key)) {
            Node t = remove(nodeMap.get(key));
            add(t);
            return t.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(maxCap == 0) return;
        if(nodeMap.containsKey(key)) {
            Node oldNode = remove(nodeMap.get(key));
            oldNode.val = value;
            add(oldNode);
        } else {
            if(capacity == 0) {
                removeLast();
            }
            Node newNode = new Node(key, value);
            add(newNode);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */