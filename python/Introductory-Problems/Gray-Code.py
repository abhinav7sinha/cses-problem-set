n = int(input())

'''
starting with: 000
    00- 0
    01- 1
    11- 3
    10- 2

    000
    001
    011
    010
    110
    111
    101
    100

    ok so it seems like a DP problem
     - repeating subproblems
     - optimal substructure

    state(k) - list of gray code string of length k
    state(k) = '0'+all elements of state(k-1)
                '1'+all elements of state(k-1) in reverse order
    
    TC - 2+2.2+2.4+2.8+..+2.2**(n-1)
        = 2**(n)
    TC: O(2**N)
    SC: O(2**N)
'''

curr = ['']

for i in range(n):
    t1 = ['0'+x for x in curr]
    t2 = ['1'+x for x in reversed(curr)]
    curr = t1+t2

for x in curr:
    print(x)
