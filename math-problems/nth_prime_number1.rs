/**
 * What is the 100001 st prime number?
 */

use std::collections::HashSet;

fn main() {
    let n: u32 = 10001;
    let mut primes: HashSet<u32> = HashSet::new();
    primes.insert(2);
    let mut c = 1;
    let mut last_p = 2;
    let mut k = 3;
    while c < n {
        println!("k = {}, c = {}, last_p = {}", k, c, last_p);
        let mut is_prime = true;
        for p in &primes {
            if k%p == 0 {
                is_prime = false;
                break;
            }
        }
        if is_prime {
            primes.insert(k);
            c += 1;
            last_p = k;
        }
        k += 2;
    }
    println!("{}", last_p);
}

