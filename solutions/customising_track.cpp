// https://codeforces.com/contest/1543/problem/B

#include<bits/stdc++.h>
using namespace std;

/*
long long u(long long n) {
    if (n == 1)
        return 3;

    if (n%2 == 0)
        return u(n/2) + 3 + 2*(n - 2);

    if (n%2 == 1)
        return u(n/2) + 2*((n/2) + 1);

}

long long f(long long n) {
    if (n == 1)
        return 2;

    if (n == 2)
        return 5;

    if (n%2 == 0)
        return u(n/2) + n;

    if (n%2 == 1)
        return 2 + f(n - 1);
}*/

int main() {
    int t;
    int n;
    long long a;
    long long b;
    long long r;
    cin >>t;
    while (t--) {
        a = 0;
        cin >>n;
        for (int i = 0; i < n; i++) {
            cin >>b;
            a+=b;
        }
        r = a%n;

        cout <<r*(n - r)<<endl;
    }

    return 0;
}
