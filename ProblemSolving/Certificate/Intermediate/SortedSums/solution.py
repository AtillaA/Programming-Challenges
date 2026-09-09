import math
import os
import random
import re
import sys


#
# The function returns an INTEGER.
# The function accepts INTEGER_ARRAY a as parameter.
#
def sortedSum(a):
    MOD = 10**9 + 7
    MAX_VAL = 10**6
    
    bit_count = [0] * (MAX_VAL + 2)
    bit_sum = [0] * (MAX_VAL + 2)
    
    
    def update(tree, idx, val):
        while idx <= MAX_VAL:
            tree[idx] += val
            idx += idx & (-idx)
    
    def query(tree, idx):
        s = 0
        while idx > 0:
            s += tree[idx]
            idx -= idx & (-idx)
        return s
    
    
    total_ans = 0
    current = 0
    total_val = 0
    
    for val in a:
        less_count = query(bit_count, val)
        rank = less_count + 1
        
        less_sum = query(bit_sum, val)
        gr_sum = total_val - less_sum
        
        current = (current + (rank * val) + gr_sum) % MOD
        total_ans = (total_ans + current) % MOD
        
        update(bit_count, val, 1)
        update(bit_sum, val, val)
        total_val += val        

    
    return total_ans


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    a_count = int(input().strip())

    a = []

    for _ in range(a_count):
        a_item = int(input().strip())
        a.append(a_item)

    result = sortedSum(a)

    fptr.write(str(result) + '\n')

    fptr.close()
