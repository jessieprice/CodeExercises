class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int[][] cost = new int[words.length][words.length];
        String[] breaks = {"", " ", "  ", "   ", "    ", "     ", "      "};
        List<String> answer = new ArrayList<>();
        
        
        for (int i = 0; i < words.length; i++) {
            // calculate remaining chars with each word by itself
            cost[i][i] = maxWidth - words[i].length();
            for (int j = i + 1; j < words.length; j++) {
                // calculate remaining chars following first word
                cost[i][j] = cost[i][j - 1] - words[j].length() - 1;
            }
        }
        
        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                if (cost[i][j] < 0) {
                    cost[i][j] = Integer.MAX_VALUE;
                } else {
                    cost[i][j] = (int)Math.pow(cost[i][j] , 2);
                }
            }
        }
        
        int mincost[] = new int[words.length];
        int result[] = new int[words.length];
        
        for (int i = words.length - 1; i >= 0; i--) {
            mincost[i] = cost[i][words.length - 1];
            result[i] = words.length;
            for (int j = words.length - 1; j > i; j--) {
                if (cost[i][j - 1] == Integer.MAX_VALUE) {
                    continue;
                }
                if (mincost[i] > mincost[j] + cost[i][j - 1]) {
                    mincost[i] = mincost[j] + cost[i][j - 1];
                    result[i] = j;
                }
            }
        }
        
        int i = 0; 
        int j;
        
        do {
            StringBuilder sb = new StringBuilder();
            j = result[i];
            int sum = -1;
            int num_words = 0;
            for (int k = i; k < j; k++) {
                // calculate how many spaces are left
                sum += words[k].length() + 1;
                num_words++;
            }
            // if there are more leftover characters
            sum += words[j].length();
            int remainder = maxWidth - sum + 1;
            System.out.println("sum: " + sum + " for line starting with " + words[i]);
            System.out.println("length: " + words[i]);
            System.out.println("remaining chars: " + remainder + " for line starting with " + words[i]);
            int mult;
            int rem ;
            if ((j - 1 - i) > 0) {
                mult = remainder / (j - 1 - i);
                rem = remainder % (j - 1 - i);
            } else {
                mult = 0;
                rem = 0;
            }
            for (int l = i; l < j - 1; l++) {
                sb.append(words[l]);
                sb.append(" ");
                sb.append(breaks[mult]);
                if(rem > 0) {
                    sb.append(" ");
                    rem --;
                }
            }
            sb.append(words[j - 1]);
            if (j - i == 1) {
                sb.append(breaks[maxWidth - words[j - 1].length()]);
            }
            answer.add(sb.toString());
            i = j;
        } while (j < words.length);
        return answer; 
    } 
}
