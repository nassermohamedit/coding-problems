use std::arch::x86_64::_mm_sha1nexte_epu32;
#[allow(unused_imports)]
use std::cmp::{min, max};
use std::io::{BufWriter, stdin, stdout, Write};


fn main() {
    let mut sc = Scanner::default();
    let mut out = BufWriter::new(stdout());
    let n: usize = sc.next();
    for _i in 0..n {
        let mut x: u32 = sc.next();
        let mut p = 2;
        let mut no_divisores :u64 = 1;
        let mut i = 2;
        while i * i <= x {
            let mut multiplicity: u32 = 0;
            while x % i == 0 {
                x /= i;
                multiplicity += 1;
            }
            no_divisores *= multiplicity as u64 + 1;
            i += 1;
        }
        if x > 1 {
            no_divisores *= 2;
        }
        writeln!(out, "{}", no_divisores);
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
