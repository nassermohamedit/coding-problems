# https://codeforces.com/gym/400515/problem/A

def max_pow(n) :
  x = 1
  while x*2 <= n :
    x = x*2
  return x
 
n = int(input())
a = list(map(int, input().split()))
a.insert(0, 0)
s = 0
count = [0 for i in range(n)]
for i in range(1, n) :
  count[i] = a[i]
  a[i + max_pow(n - i)] += count[i]
  s += count[i]
  print(s)