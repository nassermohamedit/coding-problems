#include<iostream>
#include<bits/stdc++.h>

//problem: https://cses.fi/problemset/task/1094/
 
using namespace std;
 
 
 
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int n;
    cin >>n;
    int a, b;
    cin >>a;
    long long ans = 0;
    for (int i = 0; i < n - 1; ++i) {
        cin >>b;
        if (b < a) {
            ans += a - b;
        } else {
            a = b;
        }
    }
    cout <<ans;
}
