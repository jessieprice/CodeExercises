Class Solution {
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
}
