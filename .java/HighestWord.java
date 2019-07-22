/**
* INSTRUCTIONS
* task: given a string, return the highest value word, where the value of
*       a word equals the sum of the values of the chars within it. values of
*       chars equal their position in the alphabet, so a = 1, b = 2, etc.
*
* rules: 1. all words will be lowercase
*        2. all strings will be valid (none NULL)
*/
public class HighestValue {

  /**
  * purpose: determine and return the highest value word in a string
  *
  * @param s: string containing all words to be considered
  * @return the highest value word in the string
  */
  public static String high(String s) {
    if (s.length() == 0) {
      return "";
    }

    String[] words = s.split("\\s+");
    if (words.length == 1) {
      return words[0];
    }
    int max = 0;
    String highest = words[0];

    for (int i = 0; i < words.length; i++) {
      int sum = 0;
      for (int j = 0; j < words[i].length(); j++) {
        sum += (int)words[i].charAt(j) - 96;
      }
      if (sum > max) {
        max = sum;
        highest = words[i];
      }
    }

    return highest;
  }

}
