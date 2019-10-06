class SquaredDigits {
    public boolean isHappy(int n) {
        HashSet found = new HashSet();
        int sum = helper(0, n);
        
        while (sum != 1) {
            sum = helper(0, sum);
            if (found.contains(sum)) {
                return false;
            } else {
                found.add(sum);
            }
        } 
        return true;
    }
    
    public int helper (int sum, int n) {
        if (n == 0) {
            return sum;
        }
        sum += Math.pow((n % 10), 2);
        return helper(sum, (n / 10));
    }
}
