use std::arch::x86_64::_mm_sha1nexte_epu32;
#[allow(unused_imports)]
use std::cmp::{min, max};
use std::io::{BufWriter, stdin, stdout, Write};

const MOD: u128 = 1000000007;


fn main() {
    let mut sc = Scanner::default();
    let mut out = BufWriter::new(stdout());
    let n: u128 = sc.next();
    let mut divisors_sum = 0;
    let mut i = 1;
    while i * i <= n {
        let mut q  = n / i;
        divisors_sum = (divisors_sum + (q*(q + 1)/2 + i*(q - i + 1) - i*(i + 1)/2) % MOD) % MOD;
        i += 1;
    }
    writeln!(out, "{}", divisors_sum);
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
