// problem statement: https://codeforces.com/problemset/problem/1344/A

#include<bits/stdc++.h>
using namespace std;
  
 
int main() {
    int t;
    int n;
    long long a;
    cin >>t;
    vector<int> li(200007);
    bool yes;
    while (t--) {
        yes = true;
        cin >>n;
        for (int i = 1; i <= n; i++) {
            cin >>a;
            if ((a + i)%n >= 0)
                li[i] = (int) ((a + i)%n);
            else
                li[i] = (int) ((a + i)%n + n);
        }
        vector<bool> deja(n, false);
        for (int i = 1; i <= n; i++) {
            if (deja[li[i]] == false) {
                deja[li[i]] = true;
            }
            else {
                yes = false;
            }
        }
        if (yes)
            cout <<"YES" <<endl;
        else
            cout <<"NO" <<endl;
    }
}