public class Xbonacci {

  public double[] tribonacci(double[] s, int n) {

      double [] trib = new double[n];

      if (n == 0) {
        return trib;
      }

      int i = 0;
      while (i < n && i < 3) {
        trib[i] = s[i];
        i++;
      }
      return rec_trib(trib, i, n);
  }

  public double[] rec_trib(double[] s, int index, int n) {
    if (index >= n) {
      return s;
    }
    s[index] = s[index - 3] + s[index - 2] + s[index - 1];
    return rec_trib(s, ++index, n);
  }
}
