// problem statement: https://codeforces.com/problemset/problem/1553/D

#include<iostream>
#include<bits/stdc++.h>
 
using namespace std;
 
void solve() {
    string s, t;
    cin >>s;
    cin >>t;
    int n = s.length();
    int m = t.length();
    int x = 0;
    int left = 0;
    while (left < n && s[left] != t[x])
        left++;
    if (left >= n) {
        cout <<"NO" <<'\n';
        return;
    }
    int y = left;
    x++;
    int right = left + 1;
    while (right < n && x < m) {
        if (s[right] == t[x] && (right - y)%2 == 1) {
            y = right;
            x++;
        }
        right++;
    }
    if (x >= m && (n-y)%2 == 1) {
        cout <<"YES" <<'\n';
        return;
    }
    x = 0;
    y = left;
    left++;
    while (left < n) {
        if (s[left] == t[x] && (left - y)%2 == 1)
            break;
        left++;
    }
    if (left >= n) {
        cout <<"NO" <<'\n';
        return;
    }
    right = left + 1;
    y = left;
    x++;
    while (right < n && x < m) {
        if (s[right] == t[x] && (right - y)%2 == 1) {
            y = right;
            x++;
        }
        right++;
    }
    if (x >= m && (n-y)%2 == 1) {
        cout <<"YES" <<'\n';
        return;
    }
    cout <<"NO" <<'\n';
}
 
int main() {
    int q;
    cin >>q;
    while (q--)
        solve();
 
 
    return 0;
}