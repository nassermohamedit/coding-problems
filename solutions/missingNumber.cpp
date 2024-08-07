#include<iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int n;
    int a;
    unsigned long long sum = 0;
    cin >>n;
    for (int i = 0; i < n - 1; ++i) {
        cin >>a;
        sum += a;
    }
    cout <<(unsigned long long)n*(n + 1)/2 - sum;
    return 0;
}
