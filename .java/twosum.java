Class Solution {
 
    // less efficient O(n^2)
    public int[] twoSum(int[] nums, int target) {
        boolean not_found = true;
        int[] answer = new int[2];
        while (not_found) {
            for (int i = 0 ; i < nums.length; i ++) {
                for (int j = 0; j < nums.length; j++ ) {
                    if (nums[i] + nums[j] == target && (i != j)) {
                        answer[0] = i;
                        answer[1] = j;
                        not_found = false;
                    }
                }
            } 
        }
        return answer;
    }

    // more efficient O(n)
    public int[] twoSum(int[] nums, int target) {
        // will be <value of int, index of int>
        Map<Integer, Integer> mapped = new HashMap<>();
        int[] answer = new int[2];
        
        for (int i = 0 ; i < nums.length; i ++ ) {
            // compute remainder needed to reach sum
            int complement = target - nums[i];
            if (mapped.containsKey(complement)) {
                // return array {index of complement, index og}
                answer[0] = mapped.get(complement);
                answer[1] = i;
            }
            // if complement not in the map
            mapped.put(nums[i], i);
        }
        return answer;
    }
}
