/**
 * tags: dynamic programming
 * statement: https://leetcode.com/problems/maximum-subarray/description
 */

class Solution {
    public:
        int maxSubArray(vector<int>& a) {
        int max_so_far = INT_MIN, max_ending_here = 0; 
        int n = a.size();
        for (int i = 0; i < n; i++) 
        { 
            max_ending_here = max_ending_here + a[i]; 
            if (max_so_far < max_ending_here) 
                max_so_far = max_ending_here; 
  
            if (max_ending_here < 0) 
                max_ending_here = 0; 
        }    
        return max_so_far; 
    }
};
