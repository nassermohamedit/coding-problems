
fn quick_sort(i: usize, j: usize, a: &mut [i32]) {
    if i >= j {
        return
    }
    let mut q: i32 = i as i32 - 1;
    for k in i..j {
        if a[k] <= a[j] {
            q += 1;
            (a[q as usize], a[k]) = (a[k], a[q as usize]);
        }
    }
    q += 1;
    (a[q as usize], a[j]) = (a[j], a[q as usize]);
    if q - 1 >= 0 {
        quick_sort(i, q as usize - 1, a);
    }
    quick_sort(q as usize + 1, j, a);
}

