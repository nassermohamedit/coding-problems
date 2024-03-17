/**
 * tags: math, sorting
 * statement: https://codeforces.com/problemset/problem/1933/D
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
        let a: Vec<u32> = (0..n).map(|_| sc.next()).collect();
        let mut min_i = 0;
        for i in 1..n {
            if a[i] < a[min_i] {
                min_i = i;
            }
        }
        let mut duplicate = false;
        let mut ans = false;
        for i in 0..n {
            if i != min_i && a[i] == a[min_i] {
                duplicate = true;
            }
            if a[i] % a[min_i] > 0 {
                ans = true;
            }
        }
        if !duplicate || ans {
            println!("Yes");
        }
        else {
            println!("No");
        }

    }
}

