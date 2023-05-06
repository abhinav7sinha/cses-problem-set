n = int(input())
nums = list(map(int, input().split(' ')))

prev = nums[0]
moves = 0
for num in nums:
    if num<prev:
        moves += prev - num
    else:
        prev = num
print(moves)
