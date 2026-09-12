Contiguous Spans
----------------
During end-of-day reconciliation you scan a ledger of n transaction amounts, in the order they were posted. Deposits are positive and withdrawals are negative. Finance wants to know how often a run of consecutive transactions nets out to a specific reconciliation amount K — for example, how many consecutive stretches of the ledger sum to exactly zero (perfectly offsetting), or to some expected settlement figure.

Count how many contiguous spans (subarrays) of transactions sum exactly to K.

A span is defined by a start and end index i ≤ j; it is the block of transactions amounts[i], amounts[i+1], ..., amounts[j].

Two spans are different if their index ranges differ, even when they contain identical amounts.


Input & Output
--------------
Input format:

n K
a_1 a_2 ... a_n

	• Line 1 has two integers: n (the number of transactions) and K (the target amount).
	• Line 2 has the n space-separated integer amounts, in order.

Note: your countWindows(n, K, amounts) function receives the count n, the target k, and the n amounts already parsed into a list/array. You do not read from stdin — the compiler boilerplate does that for you. Return the answer as a single string (the harness prints it directly).

Output format:

A single line: one integer — the number of contiguous spans whose amounts sum exactly to K.


Constraints
-----------
• 1 ≤ n ≤ 10^9			      # |amount| ≤ 1e9
• -1 * 10^18 ≤ K ≤ 10^18	# |K| ≤ 1e18

Use 64-bit integers. A prefix sum can reach n * |amount| = 1e5 * 1e9 = 1e14, and K itself can be as large as 1e18, so both exceed 32-bit range. The count of spans also fits in 64-bit.

The intended solution is O(n) time. A brute-force O(n^2) scan over every start/end pair will time out at n = 1e5.
