import java.lang.Object;

/**
* INSTRUCTIONS
* task: create a function that turns a string into a Mexican Wave.
*       will be passed a string and you must return that string in an array
*       where an uppercase letter is a person standing up.
*
* rules: 1.  The input string will always be lower case but maybe empty.
*        2.  If the character in the string is whitespace then pass over it
*            as if it was an empty seat.
*
* example: wave("hello") => ["Hello", "hEllo", "heLlo", "helLo", "hellO"]
*/
public class MexicanWave {

  /**
  * purpose: with a string of all lowercase chars as template, return an array
  *          of strings where the i-th string has the i-th character uppercase,
  *          and whitespaces are skipped over like an empty "seat" in a wave.
  *
  * @param str: string to be converted into wave
  * @return array of strings constituting the wave
  */
    public static String[] wave(String str) {

        // determine how many valid chars contained in string
        int no_whitespace = str.replaceAll("\\s","").length();
        String[] waves = new String[no_whitespace];

        // str_index = index within String str
        // builder_index = index within string builder
        // both needed since str_index will advance when char != whitespace
        // builder_index should not advance when char = whitespace
        int str_index = 0;
        int builder_index = 0;

        while (str_index < str.length()) {
          if (str.charAt(str_index) != ' ') {
            StringBuilder temp = new StringBuilder(str);
            char lowercase = str.charAt(str_index);
            char uppercase = (char)(((int)lowercase) - 32);

            // change current char to uppercase version; ASCII - 32
            temp.setCharAt(str_index, uppercase);
            waves[builder_index] = temp.toString();
            builder_index++;
          }
          str_index++;
        }

        return waves;
    }

}
