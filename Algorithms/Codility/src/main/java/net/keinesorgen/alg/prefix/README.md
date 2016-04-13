You are given a non-empty, zero-indexed array A of n (1<=n<=100 000)
integers a_0, a_1, .... a_(n-1) (0<=a_i<=1 000). This array represents
number of mushrooms growing on the consecutive spots along a road.

You are also given integers k and m (0<=k, m<n).

A mushroom picker is at spot number K on the road and should perform M moves.
In one move she moves to an adjacent spot. She collects all the mushrooms
growing on spots she visits. 

The goal is to calculate the maximum number of mushrooms that the mushroom
picker can collect in M moves.

For example, consider array A such that:

    2, 3, 7, 5, 1, 3, 9
    0  1  2  3  4  5  6
                K

The mushroom picker at spot K=4 and should perform M=6 moves. She might move
to spots 3, 2, 3, 4, 5, 6 and therby collect 1+5+7+3+9 = 25 mushrooms. 

This is the maximal number of mushrooms she can collect.


    2, 3, 7, 5, 1, 3, 9
    0  1  2  3  4  5  6
                K

Steps:
    LEFT, LEFT, RIGHT, RIGT, RIGHT, RIGHT


