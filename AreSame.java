import java.util.*;

public class AreSame {

	public static boolean comp(int[] a, int[] b) {

    /* CASE: one or both arrays null */
    if (a == null || b == null) {
      return false;
    }

    /* CASE: both arrays empty */
    if (a.length == 0 && b.length == 0) {
      return true;
    }

    /* CASE: one array empty */
    if ((a.length == 0 && b.length != 0) || (a.length != 0 && b.length == 0)) {
      return false;
    }

    /* CASE: arrays not equal size */
    if (a.length != b.length) {
      return false;
    }

    /* CASE: check arrays against each other
       check elements of a (squared) against b */
    for (int i = 0; i < a.length; i++) {
      int a_squared = a[i] * a[i];
      if (contains(a_squared, b) == false) {
        return false;
      }
    }
    return true;
  }

  public static boolean contains(int a, int[] b) {
    for (int i = 0; i < b.length; i++) {
      if (b[i] == a) {
        b[i] = -1;
        return true;
      }
    }
    return false;
 }
}
