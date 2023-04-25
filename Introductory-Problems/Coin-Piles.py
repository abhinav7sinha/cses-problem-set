t = int(input())

# x + 2y = a
# 2x + y = b

# x - y = b - a
# x + y = (a + b)/3

# x = ((2*b)/3) - (a/3)
# y = ((2*a)/3) - (b/3)
for _ in range(t):
    a, b = map(int, input().split())
    x = ((2*b)//3) - a//3
    y = ((2*a)//3) - b//3
    if (2*b-a)%3==0 and (2*a-b)%3==0 and x>=0 and y>=0:
        print ("YES")
    else:
        print("NO")       
