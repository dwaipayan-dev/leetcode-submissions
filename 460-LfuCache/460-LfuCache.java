// Last updated: 6/25/2026, 8:37:23 AM
class Node {
    int key, value, cnt;
    Node prev, next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
        cnt = 1;
    }
}

class DLList {
    int size;
    Node head, tail;

    public DLList(){
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void add(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    public void remove(Node node){
        if(node == null) return;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
        size--;
    }

    public Node removeLast(){
        if(size > 0){
            Node node = tail.prev;
            remove(node);
            return node;
        }
        return null;
    }
}
class LFUCache {
    int min, size, capacity;
    //Store key: Node
    Map<Integer, Node> nodeMap;
    //Store freq: DLList
    Map<Integer, DLList> listMap;

    public LFUCache(int capacity) {
        nodeMap = new HashMap<>();
        listMap = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = nodeMap.get(key);
        if(node != null){
            update(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        Node node = nodeMap.get(key);
        //It is existing node
        if(node != null){
            node.value = value;
            update(node);
            return;
        }
        //It is new node
        node = new Node(key, value);
        nodeMap.put(key, node);
        if(size == capacity){
            DLList oldList = listMap.get(min);
            nodeMap.remove(oldList.removeLast().key);
            size--;
        }
        size++;
        min = 1;
        DLList newList = listMap.getOrDefault(node.cnt, new DLList());
        newList.add(node);
        listMap.put(node.cnt, newList);
    }

    public void update(Node node){
        DLList oldList = listMap.get(node.cnt);
        oldList.remove(node);
        if(node.cnt == min && oldList.size == 0){
            listMap.remove(min);
            min++;
        }
        node.cnt++;
        DLList newList = listMap.getOrDefault(node.cnt, new DLList());
        newList.add(node);
        listMap.put(node.cnt, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */