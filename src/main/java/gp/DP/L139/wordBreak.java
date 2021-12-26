package gp.DP.L139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for (String word: wordDict) {
            dict.add(word);
        }
        boolean[] canSegment = new boolean[s.length() + 1];
        canSegment[0] = true;
        int largetlengthWord = getLargest(dict);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= largetlengthWord && j <= i; j++) {
                if (!canSegment[i - j]) {
                    continue;
                }
                if (dict.contains(s.substring(i - j, i))) {
                    canSegment[i] = true;
                }
            }
        }
        return canSegment[s.length()];
    }
    
    public int getLargest(Set<String> dict) {
        int max = 0;
        for (String word: dict) {
            max = Math.max(max, word.length());
        }
        return max;
    }
}


//               l e e t c o d e
//cansegment// 1 0 0 0 1       1
    //index//  0 1 2 3 4 5 6 7 8