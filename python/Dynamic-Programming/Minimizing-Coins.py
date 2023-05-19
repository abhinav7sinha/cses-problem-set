import math

n, x = map(int, input().split())
coins = list(map(int, input().split()))

'''
state(x) = min number of coins that can be used to produce the given sum

ex. 1 5 7; 11

state(x) = min(
    1 + state(x-c1),
    1 + state(x-c2),
    ... for all values of coins
    )


'''
# Recursive DP
'''
dp = [-1]*(x+1)
def state(target):
    global n, dp
    if target==0:
        return 0
    if target<0:
        return math.inf
    if dp[target]!=-1:
        return dp[target]
    mincoins = math.inf
    for c in coins:
        mincoins = min(state(target-c), mincoins)
    dp[target] = 1 + mincoins
    return dp[target]

ans = state(x)

if ans == math.inf:
    print(-1)
else:
    print(state(x))
'''
MAX = 10**6 + 1
# Iterative DP
dp = [MAX]*(x+1)

for i in coins:
    if i<=x:
        dp[i] = 1

dp[0] = 0

for i in range(0,x+1):
    if dp[i]!=MAX:
        for c in coins:
            if i+c<=x:
                dp[i+c] = min(dp[i+c], 1+dp[i])

if dp[x]==MAX:
    print(-1)
else:
    print(dp[x])
    
