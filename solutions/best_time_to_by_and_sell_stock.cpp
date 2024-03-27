/**
 * tags: dynamic programming
 * statement: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */


class Solution {
public:
    int maxProfit(vector<int>& p) {
        int pr;
        int b = 0;
        int s = 0;
        bool buy = false;
        int ans_pr = 0;
        int n = p.size();
        for (int i = 1; i < n; i++) {
            if (p[i] > p[s]) {
                s = i;
                pr = p[s] - p[b];
                buy = true;
                continue;
            }
            if (p[i] < p[b]) {
                if (pr > ans_pr) {
                    ans_pr = pr;
                }
                b = i;
                s = i;
                pr = 0;
            }
        }
        if (pr > ans_pr)
            ans_pr = pr;
        if (buy) {
            return ans_pr;
        }
        else
            return 0;
    }
};
