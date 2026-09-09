Type Counter
------------
Identify the different data types present in an input string and report their counts. Each of the substrings, separated by one or more spaces, is one of either the String, Integer, or Double type. Print the results on 3 lines in the order shown in the example. If a type does not occur, report that type with a count of 0.


Example
-------
sentence = "can you give me 10 bucks puffin 7.5 or 7"

The output is:
string 8
integer 2
double 1

There is a single space between the type and the count.


Function Description
--------------------
Complete the function typeCounter in the editor below.

typeCounter has the following parameter(s):
  - string sentence: a string to analyze

Returns 
  None: Print the results within the function and return nothing.


Constraints
-----------
• The length of sentence ≤ 30000 characters.
• sentence has fewer than 1000 words.
• One or more space characters separate the substrings to analyze.
• Each string type substring consists of lowercase English letters only.
• Each numeric type substring consists of digits from 0 to 9, and '.' (decimal point) only.
