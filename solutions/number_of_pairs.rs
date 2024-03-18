/**
 * tags: tp, math
 * statement: https://codeforces.com/problemset/problem/1538/C
 */

#[allow(unused_imports)]
use std::cmp::{min,max};
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
    
    let t = sc.next::<usize>();
    for _ in 0..t {
        let n = sc.next::<usize>();
        let l = sc.next::<u32>();
        let r = sc.next::<u32>();
        let mut a: Vec<u32> = (0..n).map(|_| sc.next::<u32>()).collect();
        a.sort();
        let mut cr = 0;
        let mut ll: usize = 0;
        let mut rr = n - 1;
        while ll < rr {
            if a[ll] + a[rr] <= r {
                cr += rr - ll;
                ll += 1;
            }
            else {
                rr -= 1;
            }
        }
        let mut cl = 0;
        ll = 0;
        rr = n - 1;
        while ll < rr {
            if a[ll] + a[rr] < l {
                cl += rr - ll;
                ll += 1;
            }
            else {
                rr -= 1;
            }
        }
        println!("{}", cr - cl);
    }
}

