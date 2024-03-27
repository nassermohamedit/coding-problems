/**
 * tags: dp
 * statement: https://leetcode.com/problems/longest-palindromic-substring/description/
 */

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i == j) dp[i][j] = 1;
                else dp[i][j] = -1;
            }
        }
        longestPalindromeUtil(s, 0, n-1, dp);
        int left = 0;
        int right = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (dp[i][j] == 1 && j-i > right-left) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    int longestPalindromeUtil(String s, int i, int j, int[][] dp) {
        if (i > j) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = longestPalindromeUtil(s, i+1, j-1, dp);
        }
        else dp[i][j] = 0;
        if (dp[i][j] == 0) {
            dp[i][j-1] = longestPalindromeUtil(s, i, j-1, dp);
            dp[i+1][j] = longestPalindromeUtil(s, i+1, j, dp);
            return 0;
        }
        return 1;
    }
}
