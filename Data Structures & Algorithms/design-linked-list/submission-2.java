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
   private ListNode head;
   private ListNode tail;

    MyLinkedList() {
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int index) {
        var cur = head.next;

        for(int i=0;i<index&&cur!=null;i++){
            cur=cur.next;
        }

        if(cur!=null&&cur!=tail){
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
        node.prev = last;
        node.next = tail;
        last.next = node;
    }
    
    public void addAtIndex(int index, int val) {
        var node = new ListNode(val);
        var cur = head.next;

        for(int i=0;i<index&&cur!=null;i++){
            cur=cur.next;
        }
        if (cur == null) return; 
        
        var tmp = cur.prev;
        tmp.next=node;
        node.prev=tmp;
        node.next=cur;
        cur.prev=node;
        
    }
    
    public void deleteAtIndex(int index) {
        var cur = head.next;

        for(int i=0;i<index&&cur!=null;i++){
            cur=cur.next;
        }
        if (cur == null|| cur == tail) return; 
        
        var prev = cur.prev;
        var next=cur.next;

        prev.next=cur.next;
        next.prev=cur.prev;

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