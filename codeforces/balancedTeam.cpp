// problem statement: https://codeforces.com/problemset/problem/1133/C

#include<iostream>
#include<bits/stdc++.h>
 
using namespace std;
 
void max_balanced() {
    int n;
    cin >>n;
    vector<int> a(n, 0);
    for (int i=0; i<n; i++) {
        cin >>a[i];
    }
    sort(a.begin(), a.end());
    int start = 0;
    int end = 1;
    int answer = 1;
 
    while (end < n) {
        if (a[end] - a[start] <= 5) {
            end++;
        }
        else {
            if (end - start > answer)
                answer = end - start;
            start++;
        }
    }
 
    if (end - start > answer)
        cout << end - start;
    else
        cout <<answer;
    return;
}
 
int main() {
    max_balanced();
    return 0;
}