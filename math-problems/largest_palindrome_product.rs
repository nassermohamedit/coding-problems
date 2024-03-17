/**
 * Find the largest palindrome made from the product of two 4-digit numbers
 */

fn main() {
    let mut ans: u32 = 0;
    let mut p: u32 = 1000000001;
    while ans == 0 {
        p = next_palindrom(p);
        for i in (1000..=9999).rev() {
            if p%i == 0 {
                let q = p/i;
                if q > 999 && q < 10000 {
                    ans = p;
                    break;
                }
            }
        }
    }
    println!("{}", ans);
}

fn next_palindrom(n: u32) -> u32 {
    let mut digits: Vec<i32> = n.to_string()
                        .chars()
                        .map(|c| c.to_digit(10).unwrap() as i32)
                        .collect();
    let l = digits.len();
    let m =  l/2;
    let mut next: i32 = 0;
    for i in m..l {
        if digits[i] == 0 {
            digits[i] = 9;
            if l-i-1 != i { digits[l-i-1] = 9; }
        }
        else {
            if i == l-1 && digits[0] == 1 {
                digits[l-1] = 9;
                digits[0] = -1;
            }
            else {
                digits[i] -= 1;
                if l-i-1 != i { digits[l-i-1] -= 1; }
            }
            break;
        }
    }

    for i in 0..l {
        if digits[i] != -1 {
            next = next*10 + digits[i];
        }
    }
    next as u32
}

