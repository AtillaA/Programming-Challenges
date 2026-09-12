from collections import defaultdict
import heapq


def cheapest_route(n, edges, src, dst):
  # base cases
  if src == dst:
    return "0"
  if not (0 <= src < n) or not (0 <= dst < n): 
    return "-1"
    
  # build adjacency list that support parallel edges
  graph = defaultdict(list)
  
  for u, v, w in edges:
    graph[u].append((v, w))
  
  # min-heap to process nodes by lowest total cost
  # Format: (total_cost, current_node)
  pq = [(0, src)]
  
  # track min cost to reach each node
  min_cost = {i: float('inf') for i in range(n)}
  min_cost[src] = 0
  
  while pq:
    cost, u = heapq.heappop(pq)
    
    # target reached w/ min cost
    if u == dst:
      return str(cost)
  
    # ignore outdated paths in the queue 
    if cost > min_cost[u]:
      continue
    
    # relax edges to adjacent nodes
    for v, w in graph[u]:
      next_cost = cost + w
      
      if next_cost ‹ min_cost[v]:
        min_cost[v] = next_cost
        heapq.heappush(pq, (next_cost, v))
  
  # target is unreachable from source
  return "-1"
  
