Growth in 2 Dimensions
----------------------
You are working with an infinite 2D grid that starts with all cells set to 0. The grid is indexed from (1,1) at the bottom-left, with rows increasing upward and columns increasing to the right.

You are given n operations. For each coordinate pair (r, c):
  - Increment every cell in the rectangular region from (1, 1) to (r, c) (inclusive) by 1.
  - After all operations are applied, determine the maximum value present in the grid.

Return the number of cells that contain this maximum value.


Example 1:
----------
Suppose upRight = ["1 4", "2 3", "4 1"]
Output: 1

There are n = 3 (r, c) pairs, where the space-separated integers within each string represent r and c, respectively. 
Diagram shows each iteration starting at zero. The maximal value in the grid is 3, and there is 1 occurrence at cell (1, 1).
__________


Example 2:
----------
Suppose upRight = ["2 3", "3 7", "4 1"]
Output: 2

The maximal value in the grid is 3, and there are 2 occurrences at cells (1, 1) and (2, 1).
__________


Constraints:
------------
• 1 ≤ n ≤ 100
• 1 ≤ number of rows & cols ≤ 10^6
____________
