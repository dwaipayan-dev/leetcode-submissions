// Last updated: 6/30/2026, 6:51:27 AM
/*
 * Time complexity is O(log(m.n))
 * Recursive solution.
 * Acheived by reducing search space by eliminating elements not appearing in kth index. Reimagining median as finding kth min (len(A+B)/2) and removing elements not in those positions
*/

1class Solution {
2    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
3        int na = nums1.length;
4        int nb = nums2.length;
5        int n = na + nb;
6        // Odd Case
7        if((na + nb)%2 == 1) {
8            return findKthMin(nums1, nums2, n/2, 0, na -1, 0, nb - 1);
9        } else {
10            // Even case
11            return (double)(findKthMin(nums1, nums2, n/2, 0, na - 1, 0, nb - 1) + 
12                            findKthMin(nums1, nums2, n/2 - 1, 0, na - 1, 0, nb - 1))/2;
13        }
14    }
15
16    public int findKthMin(int[] A, int[] B, int k, int aStart, int aEnd, int bStart, int bEnd) {
17        // All Elements of A consumed, kth min is actually k - aStart (k was index of na + nb) element of sorted B
18        if(aStart > aEnd) {
19            return B[k - aStart];
20        }
21        if(bStart > bEnd) {
22            return A[k - bStart];
23        } 
24        int aIndex = (aStart + (aEnd - aStart)/2);
25        int bIndex = (bStart + (bEnd - bStart)/2);
26        int aValue = A[aIndex];
27        int bValue = B[bIndex];
28        if(k > (aIndex + bIndex)) {
29            // k must be in righter side so we can eliminate smaller of left arrays
30            if(aValue > bValue) {
31                // Eliminate smaller B left
32                return findKthMin(A, B, k, aStart, aEnd, bIndex + 1, bEnd);
33            } else {
34                // Eliminate smaller A left
35                return findKthMin(A, B, k, aIndex + 1, aEnd, bStart, bEnd);
36            }
37        } else {
38            // k must be in left side so we can eliminate bigger right side of arrays
39            if(aValue > bValue) {
40                // Eliminate bigger of A right
41                return findKthMin(A, B, k, aStart, aIndex - 1, bStart, bEnd);
42            } else {
43                // Eliminate bigger of B right
44                return findKthMin(A, B, k, aStart, aEnd, bStart, bIndex - 1);
45            }
46        }
47    }
48}