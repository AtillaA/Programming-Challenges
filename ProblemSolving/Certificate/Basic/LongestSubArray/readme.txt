Longest Subarray
----------------
Given an array of integers, what is the length of the longest subarray containing no more than two distinct values such that the distinct values differ by no more than 1?

Example:
--------
arr = [0, 1, 2, 1, 2, 3]
The largest such subarray has length 4: [1.2.1.2]

arr = [1, 1, 1, 3, 3, 2, 2]
The largest such subarray has length 4: [3, 3, 2, 2]. The values 1 and 3 differ by more than 1 so [1, 1, 1, 3, 3] is not valid.

Function Description
--------------------
Complete the function longestsubarray, has the following parameter(s):
  - int arr[n]: an array of integers
Returns:
  - int: the length of the longest subarray

Constraints
-----------
  - The longest subarray will have fewer than 35 elements.
  - 1 ≤ n ≤ 10^5
  - 1 ≤ arr[i] ≤ 10^9

Input Format For Custom Testing:
--------------------------------
The first line contains an integer n, denoting the number of elements in arr.
Each line i of the n subsequent lines contains a single integer denoting arr[i].
