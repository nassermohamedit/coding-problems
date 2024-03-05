#include<stdlib.h>
#include<stdbool.h>

typedef struct {
    int n;
    int *arr;
    int sets;
} dsu_t;

dsu_t* init_dsu(int n) {
    dsu_t *dsu = (dsu_t*) malloc(sizeof(dsu_t));
    dsu->n = n;
    dsu->arr = (int*)malloc(n*sizeof(int));
    dsu->sets = n;
    for (int i=0; i<n; i++) {
        *(dsu->arr + i) = -1;
    }
    return dsu;
}

int find(dsu_t *dsu, int i) {
    int j = (dsu->arr)[i];
    if (j < 0)
        return i;
    (dsu->arr)[i] = find(dsu, j);
    return (dsu->arr)[i];  
}

void union_sets(dsu_t *dsu, int i, int j) {
    int a = find(dsu, i);
    int b = find(dsu, j);
    if (a == b)
        return;
    dsu->sets--;
    int *p = dsu->arr;
    if (p[a] > p[b]) {
        p[a] += p[b];
        p[b] = a;
    }
    else {
        p[b] += p[a];
        p[a] = b;
   }
}

bool is_same_set(dsu_t *dsu, int i, int j) {
    int a = find(dsu, i);
    int b = find(dsu, j);
    if (a != b || a == -1 || b == -1)
        return false;
    return true;
}


int set_size(dsu_t *dsu, int i) {
    int a = find(dsu, i);
    if (a == -1)
        return -1;
    return - *(dsu->arr + a);
}

