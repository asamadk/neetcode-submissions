class LRUCache {

    Map<Integer,Integer> map;
    LinkedHashSet<Integer> set;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        set = new LinkedHashSet<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            set.remove(key);
            set.add(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            set.remove(key);
        } else {
            if (map.size() == capacity) {
                Integer oldKey = set.getFirst();
                map.remove(oldKey);
                set.remove(oldKey);
            }
        }
        set.add(key);
        map.put(key,value);
    }
}
