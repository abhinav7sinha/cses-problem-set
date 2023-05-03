from collections import Counter

s = input()
n = len(s)
ans = []
rem = Counter(s)
def permutations(curr, rem):
    global ans, n
    if len(curr)==n:
        ans.append(''.join(curr))
        return
    set_ = set(rem)
    for c, v in rem.items():
        if v!=0:
            curr += c
            rem[c]-=1
            permutations(curr, rem)
            rem[c]+=1
            curr.pop()
    return
permutations([], rem)
ans.sort()
print(len(ans))
for stri in ans:
    print(stri)
