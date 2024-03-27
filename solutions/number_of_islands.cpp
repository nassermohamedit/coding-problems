/**
 * tags: disjoint union find
 * statement: https://leetcode.com/problems/number-of-islands/description/
 */


class Solution {
public:
    int numIslands(vector<vector<char>>& grid)
    {
        int numOfIslands = 0;
        if (grid.empty() || grid[0].empty())
            return numOfIslands;
        int n = grid.size();
        int m = grid[0].size();
        auto inside = [&](int i, int j) {
            return (-1 < i && i < n && -1 < j && j < m);
        };
        int count = 0;
        vector<vector<bool>> vis(n, vector<bool>(m, false));
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (!vis[i][j] && grid[i][j] == '1')
                {
                    numOfIslands++;
                    queue<pair<int, int>> q;
                    q.push({i, j});
                    vis[i][j] = true;
                    while (!q.empty())
                    {
                        pair<int, int> p = q.front();
                        q.pop();
                        int f = p.first;
                        int s = p.second;
                        vector<pair<int, int>> neigh = {{f + 1, s}, {f - 1, s}, {f, s + 1}, {f, s - 1}};
                        for (pair<int, int> it : neigh)
                        {
                            if (inside(it.first, it.second) && !vis[it.first][it.second] && grid[it.first][it.second] == '1')
                            {
                                q.push(it);
                                vis[it.first][it.second] = true;
                            }
                        }
                    }
                }
            }
        }
        return numOfIslands;
    }
};
