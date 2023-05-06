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
