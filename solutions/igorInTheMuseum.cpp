// problem statement: https://codeforces.com/problemset/problem/598/D */

#include<iostream>
#include<bits/stdc++.h>
 
using namespace std;
 
typedef vector<int> vi;
typedef vector<char> vc;
typedef vector<vc> vvc;
typedef vector<vi> vvi;
typedef pair<int, int> pi;
typedef vector<pi> vii;
typedef vector<vector<pi>> vvii;
typedef vector<long long> vl;
typedef long long ll;
typedef pair<int, int> pi;
#define F first
#define S seconf
 
 
#define read(a, n) {for(int i=0; i<n; i++) cin >>a[i];}
#define br '\n'
#define lpi(i, a, b) for (int i=a; i<b; i++)
#define lpd(i, a, b) for (int i=a; i>=b; i--)
#define loop(i, n) lpi(i, 1, n+1)
 
template<typename... Args>
void get(Args&... args)
{
    ((cin >> args), ...);
}
 
template<typename... Args>
void put(Args... args)
{
    ((cout << args << " "), ...);
    cout<<br;
}
 
int n, m, k;
int x, y;
vvc mus(1001, vc(1001, '*'));
vvi vis(1001, vi(1001, 0));
vi answers(100001, 0);
 
void dfs(int x, int y, int k) {
    if (x > n || x < 1 || y > m || y < 1 || vis[x][y] > 0) return;
    if (mus[x][y] == '*') answers[k]++;
    else {
        vis[x][y] = k;
        dfs(x+1, y, k);
        dfs(x-1, y, k);
        dfs(x, y+1, k);
        dfs(x, y-1, k);
        return;
    }
}
 
void solve(int x, int y, int k) {
    if (vis[x][y] == 0) {
        dfs(x, y, k);
    }
    put(answers[vis[x][y]]);
}
 
int main() {
    get(n, m, k);
    loop(i, n)
        loop(j, m)
            get(mus[i][j]);
    loop(i, k) {
        get(x, y);
        solve(x, y, i);
    }
    return 0;
}