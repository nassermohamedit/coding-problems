// problem statement: https://codeforces.com/problemset/problem/1350/B

#include<bits/stdc++.h>
using namespace std;
 
int main() {
    int t;
    int n;
    int s[100007];
    int dp[100007];
    int k;
    int ma;
    cin>>t;
    for (int i = 0; i < t; i++) {
        cin>>n;
        for (int j = 1; j <= n; j++) {
            cin>>s[j];
            dp[j] = 1;
        }
        ma = 1;
        for (int j = n; j > 0; j--) {
            k = 2;
            while (k*j <= n) {
                if (s[k*j] > s[j]) {
                    dp[j] = max(dp[j], 1 + dp[k*j]);
                }
                k++;
            }
            ma = max(ma, dp[j]);
        }
        cout<<ma<<endl;
    }
    return 0;
}