n = int(input())

ans = None
'''
recursive method to generate all permutations
when a permutation is generated -> check if it is beautiful
if yes -> store it in ans and return from the function
'''
nums = [num for num in range(1,n+1)]
ans = None
numSet = set(nums)

def gen(ans_r, numSet_r):
    global ans
    if len(numSet_r)==0:
        ans = ' '.join(str(i) for i in ans_r)
        return True
    t = numSet_r.copy()
    for num in t:
        if len(ans_r)>0:
            if abs(ans_r[-1]-num)==1:
                continue
        # DO
        numSet_r.remove(num)
        ans_r.append(num)
        # OP
        if gen(ans_r, numSet_r):
            return True
        # UNDO
        numSet_r.add(num)
        ans_r.pop()

if gen([], numSet):
    print(ans)
else:
    print("NO SOLUTION")
