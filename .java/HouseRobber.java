class HouseRobber {
    public int rob(int[] nums) {
        int robbed[] = new int[nums.length];
        
        if (robbed.length == 1) {
            return nums[0];
        }
        if (robbed.length < 1) {
            return 0;
        }
    
        robbed[0] = nums[0];
        robbed[1] = Math.max(nums[0],nums[1]);
        
        int max = Math.max(robbed[0],robbed[1]); 
        
        for (int i = 2; i < nums.length; i++) {
            robbed[i] = Math.max(nums[i] + robbed[i - 2], robbed[i - 1]);
            max = (max < robbed[i]) ? robbed[i] : max;
        }
        return max;
    }
}
