from collections import defaultdict

def minOperations(arr, threshold, d):
    # sort the array in non-descending order to process smaller elements first
    # this guarantees fewer division steps are taken
    arr.sort()
    
    counts = defaultdict(int) # map a target val to # of elts that can be transformed
    ops = defaultdict(int) # map a target val to sum of operations needed
    
    for num in arr:
        steps = 0
        current = num
        visited = set()
        
        while True:
            if current not in visited:
                if counts[current] < threshold:
                    counts[current] += 1
                    ops[current] += steps
                visited.add(current)
                
            if current == 0:
                break
                
            current //= d
            steps += 1
            
    ans = float('inf')
    for val, count in counts.items():
        if count >= threshold:
            if ops[val] < ans:
                ans = ops[val]
                
    return ans
