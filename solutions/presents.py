# problem statement: https://codeforces.com/problemset/problem/136/A

n = int(input())
p = list(map(int, input().split()))
x = [0 for i in range(n + 1)]
for i in range(n + 1) :
    x[p[i - 1]] = i
for i in range(1, n + 1) :
    print(x[i])