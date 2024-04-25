use std::arch::x86_64::_mm_sha1nexte_epu32;
#[allow(unused_imports)]
use std::cmp::{min, max};
use std::io::{BufWriter, stdin, stdout, Write};

///https://cses.fi/problemset/task/1081/


fn main() {
    let mut sc = Scanner::default();
    let mut out = BufWriter::new(stdout());
    let mut a = [0u32; 1000007];
    let n: usize = sc.next();
    let mut max_num = 0usize;
    for _i in 0..n {
        let j: usize = sc.next();
        a[j] += 1;
        max_num = max(max_num, j);
    }
    let mut gcd = max_num;
    while gcd > 1 {
        let mut f = 1;
        let mut multiples = 0;
        while f*gcd <= max_num && multiples < 2 {
            multiples += a[f*gcd];
            f += 1;
        }
        if multiples > 1 {
            break;
        }
        gcd -= 1;
    }
    writeln!(out, "{}", gcd);
}


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
