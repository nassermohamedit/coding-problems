/**
 * What is the largest prime factor of the number 690852465143
 */

fn main() {
    let mut x: i64 = 690852465143;
    let mut ans = 0;
    let mut p = 2;
    while x > 1 {
        if x%p == 0 {
            x /= p;
            if ans < p {
                ans = p;
            }
        }
        else {
            p += 1;
        }
    }
    println!("{}", ans);
}
