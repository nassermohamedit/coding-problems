use std::io::stdin;

fn heap_sort(n: &usize, a: &mut [i32]) {
    build_max_heap(a, n);
    for i in (1..*n).rev() {
        let temp = a[0];
        a[0] = a[i];
        a[i] = temp;
        max_heapify(0, a, &i);
    }
}

fn build_max_heap(a: &mut [i32], n: &usize) {
    for i in (0..=(n >> 1)).rev() {
        max_heapify(i, a, n);
    }
}

fn max_heapify(i: usize, a: &mut [i32], n: &usize) {
    let mut p = i;
    while p < *n {
        let mut largest = p;
        let l = (p << 1) + 1;
        let r = l + 1;
        if l < *n && a[largest] < a[l] {
            largest = l;
        }
        if r < *n && a[largest] < a[r] {
            largest = r;
        }
        if p == largest {
            return;
        }
        let temp = a[p];
        a[p] = a[largest];
        a[largest] = temp;
        p = largest;
    }
}

