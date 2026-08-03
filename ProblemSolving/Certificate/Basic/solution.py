# Python 3
def longestSubarray(arr):
    if not arr:
        return 0
        
    max_span = 0
    left = 0
    registry = {}
    
    for right in range(len(arr)):
        current = arr[right]
        registry[current] = registry.get(current, 0) + 1
        
        while True:
            keys = list(registry.keys())
            
            if len(keys) <= 1:
                break
                
            if len(keys) == 2 and abs(keys[0] - keys[1]) <= 1:
                break
    
            leftmost = arr[left]
            registry[leftmost] -= 1
            
            if registry[leftmost] == 0:
                del registry[leftmost]
            
            left += 1
        
        dist = (right - left) + 1
        
        if dist > max_span:
            max_span = dist
        
    return max_span
  
