from collections import deque

n = int(input())

'''
state(k) = number of ways to construct sum k
state(k) = state(k-1) + state(k-2) + ... + state(k-6)
'''

'''
n = 3
state(3) = 1 + state(2) + state(1)
    state(2) = 1 + state(1)
    state(1) = 1
'''
prev = deque([0, 1, 2, 4, 8, 16, 32])
if n<=6:
    print(prev[n])
else:
    for i in range(n-6):
        prev.popleft()
        curr = sum(prev)%(10**9+7)
        prev.append(curr)
    print(prev.pop())
