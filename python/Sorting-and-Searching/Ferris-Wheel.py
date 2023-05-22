n, x = map(int, input().split())
p = list(map(int, input().split()))

p.sort()

removed = set()

i = 0
j = n-1

count = 0
while i<=j:
    if i==j:
        count += 1
        break
    if p[i]+p[j]<=x:
        i += 1
        j -= 1
        count += 1
    else:
        j -= 1
        count += 1

print(count)
