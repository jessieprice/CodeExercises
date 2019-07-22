/**
* INSTRUCTIONS
* task: complete a function that sums the digits in an integer. if the sum is
*       more than one digit, repeat the process. continue until a single digit
*       (int < 10) is reached, and return.
*
* examples:
*   digital_root(16)
*   => 1 + 6
*   => 7
*   digital_root(493193)
*   => 4 + 9 + 3 + 1 + 9 + 3
*   => 29 ...
*   => 2 + 9
*   => 11 ...
*   => 1 + 1
*   => 2
*/
public class DigitalRoot {

  /**
  * purpose: calculate the sum of all the digits in an integer. if the sum has
  *          more than one digit, repeat the process until single digit found
  *
  * @param n: int whose digits are to be summed
  * @return single digit sum
  */
  public static int digital_root(int n) {

    if (n < 10) {
      return n;
    }

    int sum = 0;
    do {
      sum += n % 10;
      n /= 10;
    } while (n > 0);
    return digital_root(sum);
  }
}
