/**
 * Find the difference between the square of sum of the first one hundred integers and the sum of their squares.
 */

fn main() {
    let mut ans = 0;
    let n = 100;
    let s = n*(n + 1)/2;
    for k in 1..=n {
        ans += k*(s - k);
    }
    println!("{}", ans);
}

