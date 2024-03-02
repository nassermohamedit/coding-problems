// problem statement: https://codeforces.com/problemset/problem/1462/A

#include<iostream>
#include<bits/stdc++.h>
 
using namespace std;
 
void solve() {
    int n;
    cin >>n;
    vector<int> b(n, 0);
    for (int i=0; i<n; i++)
        cin >>b[i];
    int left = 0;
    int right = n-1;
    while (left <= right) {
        if (left != right)
            cout <<b[left] <<" " <<b[right] <<" ";
        else
            cout <<b[left];
        left++;
        right--;
    }
    cout <<'\n';
}
 
int main() {
    int t;
    cin >>t;
    while (t--) {
        solve();
    }
    return 0;
}