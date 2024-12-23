Looking at the data, quick sort is the clear winner. It consistently beat the others with run times of 1.74 to 4.22 seconds across all sizes, while merge sort was a close second and heap sort was third. The results really show how insertion and selection sort are not good with bigger inputs. They start somewhat decent at 60,000 numbers but by 960,000 they take hundreds of seconds. Merge, quick, and heap sort grow pretty gradually with input size, while insertion and selection sort shoot up exponentially, which seems to match what we learned about the algorithms being O(n log n) versus O(n^2). When I graphed it out, I had to scale the y-axis just to make the quicker sorts visible, since quick, merge, and heap sort looked like a flat line compared to the others.