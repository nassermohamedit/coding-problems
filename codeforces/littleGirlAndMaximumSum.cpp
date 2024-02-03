// problem_statement: https://codeforces.com/problemset/problem/276/C

#include<iostream>
#include<bits/stdc++.h>
 
using namespace std;


int main() {
    int n;
    int q;
    cin >>n >>q;
    vector<int> a(n);
    for (int i = 0; i < n; i++) {
        cin >>a[i];
    }
    int l;
    int r;
    vector<int> pos(n, 0);
    while (q--) {
        cin >>l >>r;
        pos[l - 1]++;
        if (r < n)
            pos[r]--;
    }
    int x = pos[0];
    for (int i = 1; i < n; i++) {
        pos[i] += x;
        x = pos[i];
    }
    sort(pos.begin(), pos.end());
    sort(a.begin(), a.end());
    long long int  ans = 0;
    for (int i = 0; i < n; i++) {
        ans += (long long) pos[i]* (long long) a[i];
    }
    cout <<ans;
 
 
    return 0;
}