class FindSingleNumber {
    public int singleNumber(int[] nums) {
        // MORE EFFICIENT WAY
        // based on XOR-ing every value since a XOR a = 0, a XOR a XOR a = a, etc
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
        
        // LESS EFFICIENT WAY
        // HashMap<Integer, Integer> mapped = new HashMap<>();
        // for (int i : nums) {
        //     int ret = mapped.getOrDefault(i, 0);
        //     if (ret == 0) {
        //         mapped.put(i, 1);
        //     } else {
        //         mapped.remove(i);
        //     }
        // }
        // if (mapped.size() == 0) {
        //     System.out.println("all elements are matched");
        //     return -1;
        // }
        // Object[] o = mapped.keySet().toArray();
        // return (int)o[0];
    }
}
