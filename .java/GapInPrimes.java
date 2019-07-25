import java.util.Arrays;
import java.math.BigInteger;
import java.util.ArrayList;

/**
* INSTRUCTIONS
* task: given two numbers and an integer g (gap), find two consecutive prime
*       numbers (consecutive meaning that there are only composite numbers
*       between the two) with a gap of g (so prime1 - prime2 = g) that are
*       within the range [m, n] inclusively. if no pair exists, return NULL.
*
*
* examples:
*   gap(2, 3, 50) --> [3, 5]
*/
class GapInPrimes {

  /**
  * purpose: find two prime numbers between m and n inclusive with gap g
  *
  * @param m: lower bound of longs allowed
  * @param n: upper bound of longs allowed
  * @param g: gap between primes required
  *
  * @return pair of consecutive primes within [m, n] with difference g
  */
    public static long[] gap(int g, long m, long n) {

        if ((n - m) < g || (n < m)){
          return null;
        }

        BigInteger curr = BigInteger.valueOf(m);
        BigInteger second = BigInteger.valueOf(n);
        long[] answer = new long[2];

        if (!curr.isProbablePrime(6)) {
            curr = curr.nextProbablePrime();
        }

        while (curr.nextProbablePrime().intValue() <= second.intValue()) {
          BigInteger next = curr.nextProbablePrime();
          if (next.intValue() - curr.intValue() == g) {
            answer[0] = curr.longValue();
            answer[1] = next.longValue();
            return answer;
          }
          curr = next;
        }
        return null;
    }
}
