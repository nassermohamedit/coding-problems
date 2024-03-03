// https://codeforces.com/contest/1543/problem/A

#include<bits/stdc++.h>
using namespace std;



int main() {
    int t;
    long long a, b;
    cin >>t;
    while (t--) {
        cin >>a;
        cin >>b;
        if (a == b)
            cout <<0<<" "<<0 <<endl;
        else {
            cout <<abs(a - b)<<" "<<min(abs(abs(a - b)*(b/abs(a - b)) - b), abs(abs(a - b)*(b/abs(a - b) + 1) - b))<<endl;
        }
    }
    return 0;
}
