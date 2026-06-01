class TimeMap {
    private HashMap<String, List<Store>> map;

    public TimeMap() {
        this.map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        List<Store> stores = new ArrayList<>();
        if (this.map.containsKey(key)) {
            stores = this.map.get(key);
        }
        stores.add(new Store(value, timestamp));
        this.map.put(key, stores);
    }
    
    public String get(String key, int timestamp) {
        if (!this.map.containsKey(key)) {
            return "";
        }
        List<Store> stores = this.map.get(key);

        int l = 0;
        int r = stores.size() - 1;

        String res = "";

        while (l <= r) {
            int m = (int) Math.ceil(l + (r - l) / 2);
            Store store = stores.get(m);

            if (store.timestamp <= timestamp) {
                res = store.value;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return res;
    }
}

class Store {
    String value;
    int timestamp;

    Store(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}