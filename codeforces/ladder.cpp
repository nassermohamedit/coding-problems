// problem statement: https://codeforces.com/problemset/problem/279/C

#include<iostream>
#include<bits/stdc++.h>
 
using namespace std;
 
/*void print(vector<int> a, int n) {
    int i = 0;
    for (int i=0; i<n; i++)
        cout <<a[i] <<" ";
    cout <<"\n";
    return;
}*/
 
int main() {
    int n, m;
    cin >>n;
    cin >>m;
    int l, r;
    vector<int> a(n, 0);
    for (int i=0; i<n; i++)
        cin >>a[i];
    //largest j such that a[i:j] is an increasing segment, for all i.
    vector<int> inc(n, 0);
    inc[n-1] = n-1;
    for (int i=n-2; i>=0; i--) {
        if (a[i]<=a[i+1])
            inc[i] = inc[i+1];
        else
            inc[i] = i;
    }
    //smallest i such that a[i:j] is an decreasing segment, for all j.
    vector<int> dec(n, 0);
    dec[0] = 0;
    for (int i=1; i<n; i++) {
        if (a[i]<=a[i-1])
            dec[i] = dec[i-1];
        else
            dec[i] = i;
    }
    while (m--) {
        cin >>l;
        cin >>r;
        l--;
        r--;
        if (dec[r]<=inc[l])
            cout <<"Yes" <<"\n";
        else
            cout <<"No" <<"\n";
    }
 
    return 0;
}