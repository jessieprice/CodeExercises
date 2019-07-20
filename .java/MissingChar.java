public class MissingChar {

  /**
  * purpose: find the missing char in an array of consecutive
  *          increasing letters
  *
  * @param array: array of chars
  * @return missing char in the sequence
  */
  public static char findMissingLetter(char[] array) {

    if (array.length == 0 || array == null) {
      return (char)0;
    }

    int curr = 0;
    int prev = 0;
    while (((int)array[curr] - (int)array[prev]) != 2 && curr < array.length) {
      prev = curr;
      curr++;
    }

    return (char)((int)array[prev] + 1);
  }
}
