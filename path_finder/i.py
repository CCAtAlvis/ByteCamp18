from implementation import *

# 1,4 is the starting point
# 7,8 is the destination point
the_map = GridWithWeights(10, 10)

# Walls are from somewhere
the_map.walls = [(1, 7), (2, 7), (3, 7)]

# weights is a dictionary
#  key   : value
# (x, y) : weight
# available_grids is a list of grids on which the bot can
# pass through
the_map.weights = {loc: 5 for loc in available_grids}

start = (1, 4)
goal = (7, 8)

came_from, cost_so_far = a_star_search(the_map, start, goal)

# Get the optimal path after performing an A* search
path = reconstruct_path(came_from, start, goal)

print(path)
