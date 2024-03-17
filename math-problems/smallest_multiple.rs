/**
 * What is the smallest integer that is divisible by all of the integers from 1 to 20?
 */

fn main() {
    let mut p = [0; 21];
    for k in 2..=20 {
        let mut q = k;
        let mut d = 2;
        let mut c = 0;
        while q > 1 {
            if q%d == 0 {
                q /= d;
                c += 1;
            }
            else {
                if p[d] < c {
                    p[d] = c;
                }
                d += 1;
                c = 0;
            }
        }
        if c > 0 && p[d] < c {
            p[d] = c;
        }
    }

    let mut ans = 1;
    for i in 2..=20 {
        ans *= (i as u32).pow(p[i] as u32);
    }
    println!("{}", ans);
}

