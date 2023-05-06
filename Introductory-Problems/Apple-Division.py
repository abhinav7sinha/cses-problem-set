n = int(input())
p = list(map(int, input().split()))

p.sort(reverse=True)

min_diff = 10**9 + 1

def partition(g1, g2, i):
    global min_diff
    global p
    if i==n:
        min_diff = min(min_diff, abs(g1-g2))
        return
    partition(g1+p[i], g2, i+1)
    partition(g1, g2+p[i], i+1)
    return
partition(0, 0, 0)
print(min_diff)
