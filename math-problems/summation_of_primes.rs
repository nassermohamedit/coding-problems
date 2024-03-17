/**
 * Find the sum of all the primes below two million.
 */

fn main() {
    const N: usize = 2000000;
    let mut primes = [true; N + 1];
    let mut ans = 0;
    for i in 2..N {
        if primes[i] {
            for k in i..=N/i {
                primes[k*i] = false;
            }
            ans += i;
        }
    }
    println!("{}", ans);
}
