// https://codeforces.com/problemset/problem/1914/B

use std::io;

fn main() {

    let mut input_line = String::new();
    io::stdin().read_line(&mut input_line).unwrap();
    let t: u16 = input_line.trim().parse().unwrap();

    for _ in 0..t {
        let mut input_line = String::new();
        io::stdin().read_line(&mut input_line).unwrap();
        let mut iter = input_line.split_whitespace();

        let n: u8 = iter.next().unwrap().parse().unwrap();
        let k: u8 = iter.next().unwrap().parse().unwrap();
        solve(n, k);
        println!("");
    }
}

fn solve(n: u8, k: u8) {
    let i: u8;
    for i in n-k..=n {
        print!("{} ", i);
    }
    for i in 1..n-k {
        print!("{} ", n - k - i);
    }
}

