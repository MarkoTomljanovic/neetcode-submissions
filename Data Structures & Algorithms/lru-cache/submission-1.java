class LRUCache {
    int capacity;
    Map<Integer, Integer> cache;
    List<Integer> order;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.order = new ArrayList<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        order.remove(Integer.valueOf(key));
        order.add(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            order.remove(Integer.valueOf(key));
            order.add(key);
            return;
        }
        if (cache.size() == capacity) {
            int eldest = order.remove(0);
            cache.remove(eldest);
        }
        cache.put(key, value);
        order.add(key);
    }
}
