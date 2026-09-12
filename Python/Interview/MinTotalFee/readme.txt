Minimum Total Fee
-----------------
A payment must be routed between banks. Banks are connected by directed transfer links, and each link charges a fixed integer fee to move money across it. Money can only flow in the direction of a link, and a payment may pass through any number of banks (hops) on its way to the destination.

Given the network, find the minimum total fee to route a payment from bank src to bank dst. If dst cannot be reached from src by following link directions, return -1.

Notes that make the problem well-defined:

	• Fees are non-negative integers (a link never pays you to use it).
	• A route may use any number of hops — a cheaper multi-hop route can beat a pricier direct link.
	• There may be multiple links between the same pair of banks (parallel links) and directed cycles; a valid route never needs to revisit a bank.


Input & Output
--------------
Input format:

n m src dst
u1 v1 w1
u2 v2 w2
...
um vm wm

The first line has four integers: 
  • n (number of banks)
  • m (total transfer links/edges in the network)
  • src (start node/bank)
  • dst (target node/bank)

The remaining are edges (u, v, w; where a directed link u → v with charging fee w)


Output format:

A single line: the minimum total fee as a string, or "-1" if dst is unreachable.
