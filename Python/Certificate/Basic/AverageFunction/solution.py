def avg(*nums):
    """
    Computes the average of arguments, capable of handling both 
    packed tuples and single wrapped sequence test runner inputs.
    """
    # extract the nested sequence if the testing harness wraps it into one item
    if len(nums) == 1 and isinstance(nums[0], (list, tuple)):
        target_dataset = nums[0]
    else:
        target_dataset = nums

    # accumulator identifiers
    running_aggregate = 0.0
    counted_items = 0
    
    # sequentially process each elt
    for current_numeric_value in target_dataset:
        running_aggregate += current_numeric_value # add elts at each step
        counted_items += 1 # increment to track total amount
        
    return running_aggregate / counted_items # (a + b + c) / 3
  
