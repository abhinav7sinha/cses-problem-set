n, m, k = map(int, input().split())

a = list(map(int, input().split()))
b = list(map(int, input().split()))

a.sort()
b.sort()

i = 0
j = 0
count = 0
while i<n and j<m:
    if b[j]<=a[i]+k and b[j]>=a[i]-k:
        count += 1
        i += 1
        j += 1
    elif b[j]>a[i]+k:
        i += 1
    else:
        j += 1
print(count)
