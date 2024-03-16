/**
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 */

fn main() {
    let mut a: i64 = 2;
    let mut b: i64 = 1;
    let mut ans = 0;
    while a <= 4000000 {
        if a%2 == 0 {
            ans += a;
        }
        a = a + b;
        b = a - b;
    }
    println!("{}", ans);
}

