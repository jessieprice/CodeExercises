/**
* INSTRUCTIONS
* task: given an array of strings and a number k, find the k consecutive
*       strings with the longest length of all possible k consecutive strings.
*
*
* examples:
*   longest_consec(["zone", "abigail", "theta", "form", "libe",
*                 "zas", "theta", "abigail"], 2) --> "abigailtheta"
*/
class LongestConsecutive {

  /**
  * purpose: find the k strings with longest combined length
  *
  * @param strarr: array of strings to be considered
  * @param k: number of consecutive strings to consider
  * @return longest k strings (combined as one string
  */
    public static String longestConsec(String[] strarr, int k) {

        int n = strarr.length;
        if (n == 0 || k > n || k <= 0) {
          return "";
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        int longest = 0;

        while (index <= (n - k)) {
          int len = 0;
          StringBuilder temp = new StringBuilder();
          for (int i = index; i < (index + k); i++) {
            len += strarr[i].length();
            temp.append(strarr[i]);
          }
          if (len > longest) {
              sb = temp;
              longest = len;
          }
          index++;
        }
        return sb.toString();
    }
}
