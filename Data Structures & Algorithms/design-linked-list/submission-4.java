class ListNode {
    int val;
    ListNode prev;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class MyLinkedList {
    ListNode head = new ListNode(0);
    ListNode tail = new ListNode(0);

    public MyLinkedList() {
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int index) {
        var cur = head.next;

        for (int i=0; i<index && cur != null; i++){
            cur = cur.next;
        }

        if(cur != null && cur != tail){
            return cur.val;
        }

        return -1;
    }
    
    public void addAtHead(int val) {
        var node = new ListNode(val);
        var first = head.next;

        head.next = node;
        node.prev = head;
        node.next = first;
        first.prev = node;
        
    }
    
    public void addAtTail(int val) {
        var node = new ListNode(val);
        var last = tail.prev;

        tail.prev = node;
        node.next = tail;
        node.prev = last;
        last.next = node;
    }
    
    public void addAtIndex(int index, int val) {
        var node = new ListNode(val);
        var cur = head.next;

        for (int i=0; i<index && cur != null; i++){
            cur = cur.next;
        }

        if(cur == null){
            return;
        }

        var prev = cur.prev;

        cur.prev = node;
        prev.next = node;
        node.prev = prev;
        node.next = cur;
    }
    
    public void deleteAtIndex(int index) {
        var cur = head.next;

        for (int i=0; i<index && cur != null; i++){
            cur = cur.next;
        }

        if(cur == null || cur == tail){
            return;
        }

        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */