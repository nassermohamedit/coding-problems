/**
 * tags: classic, dsu, dfs, graphs
 * statement: https://codeforces.com/problemset/problem/1167/C
*/


#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>


int n, m, k, u, v;

int arr[500005];

int find(int i) {
    if (arr[i] < 0) return i;
    arr[i] = find(arr[i]);
    return arr[i];
}

void union_sets(int i, int j) {
    int a = find(i);
    int b = find(j);
    if (a == b)
        return;
    if (arr[a] < arr[b]) {
        arr[a] += arr[b];
        arr[b] = a;
    }
    else {
        arr[b] += arr[a];
        arr[a] = b;
   }
}



int main(int argc, char* argv[]) {
    scanf("%d%d", &n, &m);
    for (int i=0; i<n; i++) {
        arr[i] = -1;
    }
    for (int i=0; i<m; i++) {
        scanf("%d", &k);
        if (k > 0) {
            scanf("%d", &u);
            while (--k) {
                scanf("%d", &v);
                union_sets(u-1, v-1);
            }
        }
    }
    for (int i=0; i<n; i++) {
        printf("%d ", -arr[find(i)]);
    }
    return 0;
}

