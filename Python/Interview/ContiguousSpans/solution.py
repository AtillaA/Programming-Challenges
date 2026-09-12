def count_windows(n, k, amounts):
  # base case
  if not amounts or n <= 0:
    return "0"
    
  seen_sums = {0: 1}
  curr_sum = 0
  total_spans = 0
  
  # hash map to track prefix sums for val in amounts:
  for val in amounts:
    curr_sum += val
    
    # if the difference exists, valid spans found
    diff = curr_sum - k
    if diff in seen_sums:
      total_spans += seen_sums[diff]
    
    # record the current prefix sum frequency
    seen_sums[curr_sum] = seen_sums.get(curr_sum, 0) + 1
  
  return str(total_spans)
