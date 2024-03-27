/**
 * tags: dynamic programming
 * statement: https://leetcode.com/problems/minimum-path-sum/description/
 */


class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
      int m = grid.size();
      int n = grid[0].size();

      vector<vector<int>> dp(m,vector<int>(n,0)); //another m*n array

      dp[0][0] = grid[0][0];


      for(int i = 1; i < n; i++) dp[0][i] = grid[0][i] + dp[0][i-1];
      for(int j = 1; j < m; j++) dp[j][0] = grid[j][0] + dp[j-1][0];

      for(int i = 1; i < n; i++)
      for(int j = 1; j < m; j++)
      dp[j][i] = grid[j][i] + min(dp[j-1][i],dp[j][i-1]);




      return dp[m-1][n-1];
    }
};
