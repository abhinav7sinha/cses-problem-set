n = int(input())

def transfer(src, dst, aux, k):
    if k==1:
        print(f"{src} {dst}")
        return
    transfer(src, aux, dst, k-1)
    transfer(src, dst, aux, 1)
    transfer(aux, dst, src, k-1)

def toh(x):
    prev = 1
    for _ in range(x-1):
        curr = 2*prev + 1
        prev = curr
    return prev

print(toh(n))
transfer(1, 3, 2, n)
