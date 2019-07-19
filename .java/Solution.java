public class Solution {

  /**
  * purpose: determine if a PIN is valid, where a valid PIN has either 4 or 6
  *          digits, all of which are ints between [0, 9] inclusive.
  * @param pin: inputted PIN to be verified
  * @return true if PIN is valid; false otherwise
  */
  public static boolean validatePin(String pin) {
    if (pin.length() != 4 && pin.length() != 6) {
      return false;
    }
    String[] split = pin.split("\\d");
    if (split.length != 0) {
      return false;
    }
    return true;
  }

  /* alternative solutions
   * return pin.matches("\\d{4}|\\d{6}");
   *
   * for (int i = 0; i < pin.length(); i++) {
   *  if (!Character.isDigit(pin.charAt(i))) {
   *    return false;
   *    }
   *  }
   *  return true;
   *
   * return pin.matches("[0-9]{4}|[0-9]{6}");
   */
}
