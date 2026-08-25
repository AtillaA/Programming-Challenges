Conference Schedule
-------------------
You are given n presentations, each with:
  - A start time in schedulestart
  - An end time in scheduleEnd

A person may attend a presentation only if:

  - They are present for the entire duration of the presentation.
  - They can move between presentations instantly (no travel time).

Your task is to determine the maximum number of presentations one person can attend without time overlaps. 

Return that maximum number.
___________________


Example:
--------
Suppose there are n = 3 events, scheduleStart = [1, 1, 2], and scheduleEnd = [3, 2, 4]
Output: 2

Possible combinations:
  1. Attend presentation 0 only (time 1-3)
  2. Attend presentation 1 only (time 1-2)
  3. Attend presentation 2 only (time 2-4)
  4. Attend presentations 1 and 2 (times 1-2, then 2-4)
________


Constraints:
------------
• 1 ≤ n ≤ 10^5
• 1 ≤ scheduleStart[i], scheduleEnd[i] ≤ 10^9
____________


Test Case Input Format:
-----------------------
The first line contains the integer n.
The next n lines contain an integer element of scheduleStart[].

The next line contains the integer n.
The next n lines contain an integer element of scheduleEnd[].
_______________________
