class Solution {
    
    public boolean isValid(String s) {
        Stack<Character> mapped = new Stack();
        HashMap<Character, Character> pairs = new HashMap<>();
        pairs.put(']', '[');
        pairs.put('}', '{');
        pairs.put(')', '(');

        // iterate through all parentheses
        for (int i = 0; i < s.length(); i++) {
            // check if is an opening bracket
            char curr = s.charAt(i);
            // if this is an opening bracket
            if (pairs.containsKey(curr)) {
                if (mapped.empty() == true) {
                    return false;
                }
                if (mapped.pop() != pairs.get(curr)) {
                    return false;
                }
            } else {
                mapped.push(curr);
            }
        }
        
        if (mapped.size() != 0) {
            return false;
        }
        return true;
    }
}
