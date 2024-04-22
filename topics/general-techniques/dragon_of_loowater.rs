#[allow(unused_imports)]
use std::cmp::{min,max};
use std::io::{BufWriter, stdin, stdout, Write};

///
/// Idea: If the number of the dragon's heads is greater than the number of knights, the kingdom is doomed.
/// Otherwise, the optimal strategy is: for each head H assign the shortest available knight whose height is at least
/// the head's diameter, after the assignment the knight becomes unavailable. The assignments must be done in order from
/// the smallest head to the largest.
/// Complexity: We need to sort both arrays in order to do the assignment efficiently in O(n), Therefore, T(n) = O(n.log(n))
/// Statement: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2267
///

fn main() {
    let mut sc = Scanner::default();
    let out = &mut BufWriter::new(stdout());
    let mut h = [0u32; 20007];
    let mut k = [0u32; 20007];
    while true {
        let n: usize = sc.next();
        let m: usize = sc.next();
        if n == 0 && m == 0 {
            break
        }
        for i in 0..n {
            h[i] = sc.next();
        }
        for i in 0..m {
            k[i] = sc.next();
        }
        if n > m {
            writeln!(out, "Loowater is doomed!").ok();
            continue;
        }
        &h[0..n].sort();
        &k[0..m].sort();
        let mut min_coins: u64 = 0;
        let mut j = 0;
        for i in 0..n {
            while j < m && h[i] > k[j] {
                j += 1;
            }
            if j >= m {
                min_coins = 0;
                break;
            }
            min_coins += k[j] as u64;
            j += 1;
        }
        if min_coins == 0 {
            writeln!(out, "Loowater is doomed!").ok();
        } else {
            writeln!(out, "{}", min_coins);
        }
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
