// problem statement: https://codeforces.com/problemset/problem/1472/C

#include<iostream>
#include<bits/stdc++.h>
 
using namespace std;
 
void solve() {
    int n;
    cin >>n;
    vector<int> a(n, 0);
    for (int i=0; i<n; i++)
        cin >>a[i];
    vector<int> dp(n, 0);
    dp[n-1] = a[n-1];
    int answer = a[n-1];
    for (int i=n-2; i>=0; i--) {
        dp[i] = a[i];
        if (i + a[i] < n)
            dp[i] += dp[i + a[i]];
        if (dp[i] > answer)
            answer = dp[i];
    }
    cout <<answer <<'\n';
    return;
}
 
int main() {
    int t;
    cin >>t;
    while (t--)
        solve();
 
    return 0;
}