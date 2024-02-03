// problem statement: https://codeforces.com/contest/1593/problem/A

#include<iostream>
#include<bits/stdc++.h>
 
using namespace std;
 
 
 
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t;
    cin >>t;
    int a;
    int b;
    int c;
    int m;
 
    while (t--) {
        cin >>a;
        cin >>b;
        cin >>c;
        m = max(max(a, b), c);
        if (a > b && a > c)
            cout <<0 <<" ";
        else
            cout <<m - a + 1 <<" ";
        
        if (b > a && b > c)
            cout <<0 <<" ";
        else
            cout <<m - b + 1 <<" ";
 
        if (c > b && c > a)
            cout <<0;
        else
            cout <<m - c + 1;
        cout <<"\n";
    
    }
    return 0;
}