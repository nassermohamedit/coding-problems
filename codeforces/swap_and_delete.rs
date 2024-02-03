


fn main() {
    let t: u32;
    let mut buf = String::new();
    let mut s: &str;
    std::io::stdin().read_line(&mut buf);
    t = buf.trim().parse().unwrap();
    for _i in 0..t {
        buf.clear();
        std::io::stdin().read_line(&mut buf);
        s = buf.trim();
        println!("{}", solve(&s));
    }
}

fn solve(s: &str) -> i32 {
    let (mut zeros, mut ones) = count_zeros_and_ones(s);
    if zeros == ones { return 0; }

    for c in s.chars() {
        if c == '0' {
            ones -= 1;
        }
        else {
            zeros -= 1;
        }
        if zeros < 0 || ones < 0 {
            break;
        }
    }
    return zeros + ones + 1;
}

fn count_zeros_and_ones(s: &str) -> (i32, i32) {
    let mut zeros = 0;
    let mut ones = 0;
    for c in s.chars() {
        if c == '0' {
            zeros += 1;
        } else {
            ones += 1;
        }
    }
    return (zeros, ones);
}
