s = input()

max_rep = 0
prev = None
curr_rep = 0

for c in s:
    if c is prev:
        curr_rep += 1
    else:
        curr_rep = 1
        prev = c
    max_rep = max(max_rep, curr_rep)

print(max_rep)
