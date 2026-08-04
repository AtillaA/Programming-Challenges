An integer "gap" defines the maximum allowed time difference (in seconds) to consider a retry. 

Two arrays are provided: 
  - "requestIds" where each element represents the request ID of a log.
  - "timestamps" where each element represents the time of the corresponding log (sorted in non-decreasing order).

A retry occurs when two consecutive logs for the same request ID have a time difference of at most "gap". Compute the total number of retries across all request IDs and return the result. 

Constraints
-----------
• 1 ≤ gap ≤ 10^9
• 1 ≤ n ≤ 2*10^5
• 0 ≤ timestamps[i] ≤ 10^9
• 1 ≤ length of requestIds[i] ≤ 10
• guaranteed that requestIds[i] is an alphanumeric string
• guaranteed that the timestamps array is sorted in non-decreasing order
