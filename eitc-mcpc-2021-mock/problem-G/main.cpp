/*
problem: Chess Ranking
Author: Mohamed Nasser
*/

#include<iostream>
#include<bits/stdc++.h>
 
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

	int t;
	cin >>t;
	int n;
	int q;
	int l;
	int r;
	int x;
	while (t--) {
		cin >>n;
		cin >>q;
		vector<int> a(n + 1, 0);
		vector<int> p(n + 1, 0);
		vector<int> ans(n + 1, 0);
		for (int i = 1; i <= n; i++) {
			cin >>a[i];
			p[a[i]] = i;
			ans[i] = ans[0]^i;
		}
		while (q--) {
			cin >>l;
			cin >>r;
			x = 0;
			do {
				x++;
			} while (l <= p[x] <= r);
			cout <<ans[x - 1] <<" ";
		}	
	}

	return 0;
}
