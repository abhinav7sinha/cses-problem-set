n = int(input())

def count_zeros_in_fact(n):
    k = 5
    count = 0
    while n//k>0:
        count += n//k
        k*=5
    return count

print(count_zeros_in_fact(n))
