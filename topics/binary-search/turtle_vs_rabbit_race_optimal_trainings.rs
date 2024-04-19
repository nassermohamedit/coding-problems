/**
 * Statement: https://codeforces.com/problemset/problem/1933/E
 */


#[allow(unused_imports)]
use std::cmp::{min, max};
use std::io::{BufWriter, stdin, stdout, Write};

#[derive(Default)]
struct Scanner {
    buffer: Vec<String>
}

impl Scanner {
    fn next<T: std::str::FromStr>(&mut self) -> T {
        loop {
            if let Some(token) = self.buffer.pop() {
                return token.parse().ok().expect("Failed parse");
            }
            let mut input = String::new();
            stdin().read_line(&mut input).expect("Failed read");
            self.buffer = input.split_whitespace().rev().map(String::from).collect();
        }
    }
}


fn main() {

    let mut sc = Scanner::default();
    let out = &mut BufWriter::new(stdout());

    let t: u32 = sc.next();
    let mut a= [0i32; 100007];
    for _ in 0..t {
        let n: usize = sc.next();
        for i in 1..=n {
            a[i] = a[i - 1] + sc.next::<i32>();
        }
        let q = sc.next();
        for __ in 0..q {
            let l: usize = sc.next();
            let u: i32 = sc.next();
            if n == 1 {
                write!(out, "{} ", 1).ok();
                continue;
            }
            let mut left: usize = l;
            let mut right: usize = n;
            while left < right {
                let mid = (left + right)/2;
                let (diff1, diff2): (i64, i64) = (a[mid]as i64 - a[l - 1] as i64, a[mid + 1] as i64 - a[l - 1] as i64);
                let e1: i64 = diff1*(u as i64) - diff1*(diff1 - 1)/2;
                let e2: i64 = diff2*(u as i64) - diff2*(diff2 - 1)/2;
                if e2 > e1 {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            write!(out, "{} ", left).ok();
        }
        writeln!(out, "\n").ok();
    }
}


