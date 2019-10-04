enum Matched { TRUE, FALSE }

class Solution {
    
    Matched[][] matched;
    
    public boolean isMatch(String s, String p) {
        matched = new Matched[s.length() + 1][p.length() + 1];
        return match_recurse(0, 0, s, p);
    }
    
    public boolean match_recurse(int text_ind, int patt_ind, String text, String pattern) {
        // if there is already value in the table 
        if (matched[text_ind][patt_ind] != null) {
            return matched[text_ind][patt_ind] == Matched.TRUE;
        }
        
        // otherwise no value at [text_ind, pattern_ind]
        boolean answer = true;
        if (patt_ind == pattern.length()) {
            // at the end of pattern but not end of text
            if (text_ind != text.length()) {
                answer = false;
            }
        } else {
            // check if current characters match or pattern character is .
            boolean current_match = (text_ind < text.length() &&
                                    (text.charAt(text_ind) == pattern.charAt(patt_ind) ||
                                    pattern.charAt(patt_ind) == '.'));
            
            // check if there is a star at next char in pattern
            if ((patt_ind + 1 < pattern.length()) && pattern.charAt(patt_ind + 1) == '*') {
                answer = (match_recurse(text_ind, patt_ind + 2, text, pattern) ||
                         current_match && match_recurse(text_ind + 1, patt_ind,
                                                       text, pattern));
            } else {
                answer = current_match && match_recurse(text_ind + 1, patt_ind + 1, 
                                                       text, pattern);
            }
        }
        matched[text_ind][patt_ind] = answer ? Matched.TRUE : Matched.FALSE;
        return answer;
    }
}
