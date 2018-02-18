from implementation import *

# 1,4 is the starting point
# 7,8 is the destination point
came_from, cost_so_far = a_star_search(theMap, (1, 4), (7, 8))

# Get the optimal path after performing an A* search
path = reconstruct_path(came_from, start=(1, 4), goal=(7, 8)))
