n = int(input())
nums = input().split(' ')
sum_=0

for c in nums:
    sum_+=int(c)

print(n*(n+1)//2 - sum_)
