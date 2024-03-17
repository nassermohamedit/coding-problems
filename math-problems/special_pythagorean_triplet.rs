/**
 * There exists exactly one Pythagorean triplet (a, b, c) such that a + b + c = K. Find it.
 */

fn main() {
    const K: i32 = 1000;
    let mut ans = -1;
    for c in 1..K/2 {
        for b in 1..c {
            let a = K - c - b;
            if a*a + b*b == c*c {
                ans = a*b*c;
                break;
            }
        }
        if ans >= 0 {
            break;
        }
    }
    println!("{}", ans);
}
