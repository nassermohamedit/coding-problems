/**
 * tags: classic, dsu, dfs, graphs
 * statement: https://codeforces.com/problemset/problem/1167/C
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>


int n, m;

int arr[500005], size[500005];

int find(int i) {
    if (i == arr[i])
       return i;
    arr[i] = find(arr[i]);
    return arr[i];
}

void union_sets(int i, int j) {
    int a = find(i);
    int b = find(j);
    if (a == b)
        return;
    if (size[a] > size[b]) {
        size[a] += size[b];
        arr[b] = a;
    }
    else {
        size[b] += size[a];
        arr[a] = b;
   }
}



int main(int argc, char* argv[]) {
    scanf("%d%d", &n, &m);
    for (int i=0; i<n; i++) {
        arr[i] = i;
        size[i] = 1;
    }
    for (int i=0; i<m; i++) {
        int k;
        scanf("%d", &k);
        if (k > 0) {
            int u;
            scanf("%d", &u);
            --u;
            while (--k) {
                int v;
                scanf("%d", &v);
                --v;
                union_sets(u, v);
                u = v;
            }
        }
    }
    for (int i=0; i<n; i++) {
        printf("%d ", size[find(i)]);
    }
    return 0;
}
