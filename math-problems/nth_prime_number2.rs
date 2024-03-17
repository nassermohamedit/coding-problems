/**
 * What is the 100001 st prime number?
 *
 * Sieve of Eratosthenes Algo.
 */


fn main() {
    const N: u32 = 10001;
    const M: usize = 10000;
    let mut is_prime = [true; M];
    let mut last_p = 0;
    let mut c = 0;
    for k in 2..M {
        if is_prime[k] {
            c += 1;
            last_p = k;
            let mut q = k;
            while k*q < M {
                is_prime[k*q] = false;
                q += 1;
            }
            if c >= N {
                break;
            }
        }
    }
    if c >= N {
        println!("{}", last_p);
    }
    else {
        println!("the {}th prime number is not in the range [2, {}], increase the limit M", N, M);
    }
}
