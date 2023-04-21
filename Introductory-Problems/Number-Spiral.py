t = int(input())
tests = []

# 1 3 7 13 21
# at any n
# an = n^2 - n + 1
# a1 = 1
# a2 = 3

for _ in range(t):
  tests.append(tuple(map(int, input().split())))

for y, x in tests:
    if y==x:
        print(y**2 - y + 1)
    else:
        m = max(y, x)
        val = m**2 - m + 1
        ans = val + ((-1)**(m%2))*(y-x)
        print(ans)
