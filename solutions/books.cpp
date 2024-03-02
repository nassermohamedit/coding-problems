// problem statement: https://codeforces.com/problemset/problem/279/B

#include<iostream>
#include<bits/stdc++.h>
 
using namespace std;
 
void answer(vector<int> a, int n, int t) {
    int start = 0;
    while (a[start] > t && start < n)
        start++;
    if (start >= n) {
        cout <<0;
        return;
    }
    int end = start + 1;
    int total_time = a[start];
    int length = 1;
    while (end < n) {
        if (total_time + a[end] <= t) {
            total_time = total_time + a[end];
            end++;
        }
        else {
            if (end - start > length)
                length = end - start;
            total_time = total_time - a[start];
            start++;
        }
    }
    if (end - start > length)
        cout << end - start;
    else
        cout <<length;
    return;
}
 
int main() {
    int n;
    int t;
    cin >>n;
    cin >>t;
    vector<int> a(n, 0);
    for (int i=0; i<n; i++)
        cin >>a[i];
    answer(a, n, t);
    return 0;
}