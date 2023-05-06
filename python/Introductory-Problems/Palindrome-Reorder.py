from collections import Counter

s = input()

def print_palindrome(s):
    n = len(s)
    char_count = Counter(s)
    ans = ''
    mid = ''
    # find char with odd count
    n_odd_count = 0
    for k, v in char_count.items():
        if v%2==1:
            mid += k*v
            n_odd_count += 1
            if n_odd_count>1:
                return ''
        else:
            ans += k*(v//2)
    if n%2==0 and mid:
        return ''
    elif n%2==1 and not mid:
        return ''
    else:
        return ans + mid + ans[::-1]

ans = print_palindrome(s)

if ans:
    print(ans)
else:
    print("NO SOLUTION")
