n = int(input())

if n==1:
    print(n)
elif n>3:
    numli = []
    for i in range(2, n+1, 2):
        numli.append(i)
    for i in range(1, n+1, 2):
        numli.append(i)
    print(' '.join(str(i) for i in numli))
else:
    print("NO SOLUTION")
