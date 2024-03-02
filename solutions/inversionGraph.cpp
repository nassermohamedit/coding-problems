// problem statement: https://codeforces.com/problemset/problem/1638/C

#include<iostream>
#include<bits/stdc++.h>
 
using namespace std;
 
/* merging condition :
    stack mm = {(min(1), max(1)), ...(min(n-1), max(n-1), (min(n), max(n))}
    if min(n) < max(n-1) then merge  
*/
int number_of_components() {
    int n;
    cin >>n;
    vector<int> p(n, 0);
    vector<int> mi(n, 0);
    vector<int> ma(n, 0);
    int k;
    for (int i=0; i<n; i++)
        cin >>p[i];
    mi[0] = p[0];
    ma[0] = p[0];
    k = 0;
    for (int i=1; i<n; i++) {
        if (p[i]<mi[k]) {
            mi[k] = p[i];
            while (k >= 1 && mi[k]<ma[k-1]) {
                ma[k-1] = ma[k];
                mi[k-1] = min(mi[k-1], mi[k]);
                k--;
            }
        }
        if (p[i]>ma[k]) {
            k++;
            mi[k] = p[i];
            ma[k] = p[i];
        }
    }
    return k+1;
}
 
int main() {
    int t;
    cin >>t;
    while (t--) {
        cout <<number_of_components() <<"\n";
    }
    return 0;
}