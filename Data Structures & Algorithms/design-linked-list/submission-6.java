class ListNode {
    public int val;
    public ListNode next;
    public ListNode prev;

    ListNode(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    private ListNode head;
    private ListNode tail;

    public MyLinkedList() {
        head = new ListNode(0);
        tail = new ListNode(0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        var cur = head.next;

        for (int i = 0; i < index && cur != null; i++) {
            cur = cur.next;
        }

        if (cur != null && cur != tail) {
            return cur.val;
        }

        return -1;
    }

    public void addAtHead(int val) {
        var node = new ListNode(val);
        var first = head.next;

        node.next = first;
        node.prev = head;
        head.next = node;
        first.prev = node;
    }

    public void addAtTail(int val) {
        var node = new ListNode(val);
        var last = tail.prev;

        node.next = tail;
        node.prev = last;
        last.next = node;
        tail.prev = node;
    }

    public void addAtIndex(int index, int val) {
        var node = new ListNode(val);
        var cur = head.next;

        for (int i = 0; i < index && cur != null; i++) {
            cur = cur.next;
        }

        if (cur == null) {
            return;
        }

        var left = cur.prev;

        node.next = cur;
        node.prev = left;
        cur.prev = node;
        left.next = node;
    }

    public void deleteAtIndex(int index) {
        var cur = head.next;

        for (int i = 0; i < index && cur != null; i++) {
            cur = cur.next;
        }

        if (cur == null || cur == tail) {
            return;
        }

        var left = cur.prev;
        var right = cur.next;

        left.next = right;
        right.prev = left;
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