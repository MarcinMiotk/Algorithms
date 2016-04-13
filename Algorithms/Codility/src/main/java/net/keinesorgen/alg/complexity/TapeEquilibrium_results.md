Correctness tests
double 
two elements	1.408 s	WRONG ANSWER 
got 0 expected 2000

simple_positive 
simple test with positive numbers, length = 5	1.508 s	OK

simple_negative 
simple test with negative numbers, length = 5	1.556 s	OK

small_random 
random small, length = 100	1.532 s	OK

small_range 
range sequence, length = ~1,000	1.636 s	OK

small 
small elements	1.528 s	WRONG ANSWER 
got 0 expected 20





Performance tests

medium_random1 
random medium, numbers from 0 to 100, length = ~10,000	4.424 s	TIMEOUT ERROR 
running time: 4.42 sec., time limit: 4.31 sec.

medium_random2 
random medium, numbers from -1,000 to 50, length = ~10,000	4.476 s	TIMEOUT ERROR 
running time: 4.48 sec., time limit: 3.82 sec.

large_ones 
large sequence, numbers from -1 to 1, length = ~100,000	>10.000 s	TIMEOUT ERROR 
running time: >10.00 sec., time limit: 4.74 sec.

large_random 
random large, length = ~100,000	>11.000 s	TIMEOUT ERROR 
running time: >11.00 sec., time limit: 5.14 sec.

large_sequence 
large sequence, length = ~100,000	>10.000 s	TIMEOUT ERROR 
running time: >10.00 sec., time limit: 4.66 sec.

large_extreme 
large test with maximal and minimal values, length = ~100,000	>11.000 s	TIMEOUT ERROR 
running time: >11.00 sec., time limit: 5.22 sec.