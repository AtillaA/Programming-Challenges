# Python 2 generates the exact static integer value each time (hash seeding is not randomized).
# Using another compiler language will yield a hash value different than the sample input/output.

if __name__ == '__main__':
  # raw_input() is used for Python 2 string reading  
  n = int(raw_input())

  # split the input by space, apply function conversion (int) to every item of the list
  integer_list = map(int, raw_input().split())
  
  # start from index 0 and take exactly n elts (discards if there are more than n elts)
  # convert integer list to tuple (required since lists are mutable and cannot be hashed)
  t = tuple(integer_list[:n])

  # pass the tuple to built-in hashing method
  # generates a unique fixed-size integer
  print hash(t) # print is a keyword statement in Python 2 (does not require parantheses)
