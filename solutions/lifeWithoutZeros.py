# problem statement: https://codeforces.com/problemset/problem/75/A

a = int(input())
b = int(input())
c = a + b
x = ''
y = ''
z = ''
for d in str(c) :
    if d != '0' :
        z += d
z = int(z)
for d in str(a) :
    if d != '0' :
        x += d
x = int(x)
for d in str(b) :
    if d != '0' :
        y += d
y = int(y)
if x + y == z :
    print('YES')
else :
    print('NO')