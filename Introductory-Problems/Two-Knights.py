k = int(input())
# in a k*k board
# n1=no of ways to choose 2 knights = (k**2)Choose2
# n2=no of ways the 2 knughts would attack each other
# = no. of ways to select 2*3 borads or 3*2 boards * 2
# reqd =a-b 
for i in range(1, k+1):
    if i==1:
        print(0)
        continue
    n1 = (i**2)*(i**2-1)//2
    n2 = 2*2*(i-2)*(i-1)
    print(max(0,n1-n2))
