class ListNode {
    public String val;
    public ListNode prev;
    public ListNode next;

    ListNode(String val) {
        this.val = val;
    }
}

class BrowserHistory {
    private ListNode history;
    private ListNode cur;

    public BrowserHistory(String homepage) {
        history = new ListNode(homepage);
        cur = history;
    }

    public void visit(String url) {
        var node = new ListNode(url);

        cur.next = node;
        node.prev = cur;
        cur = node;
    }

    public String back(int steps) {
        for (int i = 0; i < steps && cur != history; i++) {
            cur = cur.prev;
        }

        return cur.val;
    }

    public String forward(int steps) {
        for (int i = 0; i < steps && cur.next != null; i++) {
            cur = cur.next;
        }

        return cur.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */