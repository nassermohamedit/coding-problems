use std::arch::x86_64::_mm_sha1nexte_epu32;
#[allow(unused_imports)]
use std::cmp::{min, max};
use std::io::{BufWriter, stdin, stdout, Write};

const MOD: u32 = 1000000007;


fn main() {
    let mut sc = Scanner::default();
    let mut out = BufWriter::new(stdout());
    let n: usize = sc.next();
    for _i in 0..n {
        let mut a: u64 = sc.next();
        let mut b: u64 = sc.next();
        let mut res: u64 = 1;
        while b > 0 {
            if b & 1 != 0 {
                res = res * a % (MOD as u64);
            }
            a = a * a % (MOD as u64);
            b >>= 1;
        }
        writeln!(out, "{}", res);
    }
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
