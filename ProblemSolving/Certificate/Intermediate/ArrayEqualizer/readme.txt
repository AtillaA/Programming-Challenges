Array Equalizer
----------------
Given an array of integers, transform it so that at least a certain number of elements in the array are equal.
To achieve this, you can perform an operation where you select an element in the array and divide it by the given division parameter using integer division.
What is the minimum number of operations that must be performed to achieve this goal on a certain array?

For example, let's say arr =[1, 2, 3, 4, 5]. 
The desired number of equal elements is denoted as threshold = 3, and the division parameter is d = 2.
If you divide the value 4 once and the value 5 once using integer division, you get the array [1, 2, 3, 2, 2], which contains 3 equal elements.
There is no way to achieve this in less than 2 operations. Therefore, the answer is 2.


Function Description:
---------------------
Complete the function minOperations.

minOperations has the following parameter(s):
  - int arrfnJ: an array of integers
  - int threshold: the minimum number of desired equal elements in the array
  - int d: the division parameter used to divide an element in a single operation

Returns:
  - int: the minimum number of operations required to have at least threshold number of equal elements in the array


Constraints:
------------
  - 1 ≤ n ≤ 3 * 10^4
  - 1 ≤ arr[i] ≤ 2 * 10^5
  - 1 ≤ threshold ≤ n
  - 2 ≤ d ≤ 1000
