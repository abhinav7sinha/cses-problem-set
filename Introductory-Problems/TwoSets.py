n = int(input())

'''
1,2,3,4,5,6,7
sum=28

Q: given a set of no.s -> can you choose a subset with a target sum?

target = 14
[1,2,3,4,5,6,7]

Maybe backtracking?
loop from i=0 to i=N-1

at each i -> select i -> and check for remaining

Approach 2:
    Iterative!
    TC: O(N)
    SC: O(N)
'''

dp = {}

def helperOLD(curr, curr_sum, i):
    global n, target, dp
    if curr_sum == target:
        return curr
    if curr_sum>target:
        return False
    if i==n+1:
        return False
    if curr_sum in dp:
        if i in dp[curr_sum]:
            return dp[curr_sum][i]
    else:
        dp[curr_sum]={}
    # DO
    curr.append(i)
    curr_sum += i
    # OP
    t = helper(curr, curr_sum, i+1)
    if t:
        dp[curr_sum-i][i] = t
        return t
    # UNDO
    curr.pop()
    curr_sum -= i
    # OP
    t = helper(curr, curr_sum, i+1)
    dp[curr_sum][i] = t
    return dp[curr_sum][i]

def helper():
    global n, target
    curr = []
    curr_sum = 0
    for i in range(n, 0, -1):
        if curr_sum + i == target:
            return curr+[i]
        elif curr_sum + i > target:
            continue
        else:
            curr_sum += i
            curr.append(i)
    return None

sum_ = n*(n+1)//2
if sum_%2==1:
    print("NO")
else:
    target = sum_//2
    ans = helper()
    if ans:
        print("YES")
        print(len(ans))
        print(' '.join(str(x) for x in ans))
        print(n-len(ans))
        t = set(ans)
        print(' '.join(str(x) for x in range(1, n+1) if x not in t))
    else:
        print("NO")
