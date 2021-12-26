package gp.DP.L1143;

class Solution1 {
    public int longestCommonSubsequence(String A, String B) {
        if (A == null || A.length() == 0 || B == null || B.length() == 0) {
            return 0;
        }
        int aLength = A.length();
        int bLength = B.length();
        int[][] longest = new int[aLength + 1][bLength + 1];
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i- 1) == B.charAt(j - 1)) {
                    longest[i][j] = longest[i - 1][j - 1] + 1;
                } else {
                    longest[i][j] = Math.max(longest[i - 1][j], longest[i][j - 1]);
                }
            }
        }
        return longest[aLength][bLength];
    }
}