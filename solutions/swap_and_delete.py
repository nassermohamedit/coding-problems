# https://codeforces.com/problemset/problem/1913/B
def solve(s):
    zeros = 0
    ones = 0
    for c in s:
        if c == '0':
            zeros += 1
        else:
            ones += 1
    if zeros == ones:
        return 0
    for c in s:
        if c == '0':
            ones -= 1
        else:
            zeros -= 1
        if zeros < 0 or ones < 0:
            break
    return zeros + ones + 1


if __name__ == "__main__":
    t = int(input())
    for i in range(t):
        s = input()
        print(solve(s))

        