n = int(input())
print(str(n), end='')
while True:
    if n==1:
        break
    if n%2==0:
        n//=2
    else:
        n = 3*n + 1
    print(' ' + str(n), end='')
