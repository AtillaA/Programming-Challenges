Order List Processing
---------------------
Implement a function processOrderList that:
  
1. Takes 3 arguments: an order list ordertist, a number orderid, and a string state that is either "Processing" or "Delivered". orderList is an array of order objects. An order object has the following schema:

  {
    id: Number,
    state: String
  }

2. Updates the order list depending on the state and returns the updated ist. 
  - If the state is ‘Processing’, it updates the object in the list having id as orderid, to have the state ‘Processing’.
  - If the state is ‘Delivered’, it deletes the object from the list having the id of orderid.

3. If there is no order with the given orderId, then the function returns the list orderList unchanged.

NOTE: You can assume that initially, all orders in the list have a state of ‘Received’.

Input Format For Custom Testing:
--------------------------------
The first line contains an integer, n, the number of orders in the list.
The second line contains an integer, m, the numberOfOperations.
Each line i of the m subsequent lines (where 0 ≤ i < m) contains 2 space-separated values. The first value is the orderId and the second is the updated order state.
