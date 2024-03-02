// problem statement: https://codeforces.com/problemset/problem/1215/B

#include<iostream>
#include<bits/stdc++.h>
 
using namespace std;
 
typedef vector<int> vi;
typedef vector<vi> vii;
typedef vector<long long> vl;
typedef long long ll;
typedef pair<int, int> pi;
#define F first
#define S seconf
 
 
#define read(a, n) {for(int i=0; i<n; i++) cin >>a[i];}
#define br '\n'
 
template<typename... Args>
void get(Args&... args)
{
    ((cin >> args), ...);
}
 
template<typename... Args>
void put(Args... args)
{
    ((cout << args << " "), ...);
    cout<<br;
}
 
int main() {
    int n;
    get(n);
    vi a(n, 0);
    read(a, n);
    vl dpp(n, 0);
    vl dpn(n, 0);
    if (a[0] > 0)
        dpp[0] = 1;
    else
        dpn[0] = 1;
    ll pos = dpp[0];
    ll neg = dpn[0];
    for (int i=1; i<n; i++) {
        if (a[i] > 0) {
            dpp[i] = dpp[i-1] + 1;
            dpn[i] = dpn[i-1];
        }
        else {
            dpp[i] = dpn[i-1];
            dpn[i] = dpp[i-1] + 1;
        }
        pos += dpp[i];
        neg += dpn[i];
    }
    put(neg, pos);
    return 0;
}