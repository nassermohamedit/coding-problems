/**
 * Find the sum of all the multiples of 3 or 5 below 1000
 */

fn main() {
    let mut ans = 0;
    for i in 1..1000 {
        if i%3 == 0 || i%5 == 0 {
            ans += i;
        }
    }
    println!("{}", ans);
}

