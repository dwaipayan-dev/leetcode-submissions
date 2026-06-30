// Last updated: 6/30/2026, 7:54:46 AM
/*
 * Two mistakes to take care of:
 *  Always use smaller length array for A, 
 * partitionB = (m + n + 1) /2 - partitionA
 * 
 * Time complexity = O(log(min(a, b)) as we are only using binary search on smaller Array
 * 
 * Space complexity = O(1)
 * 
 * this idea works on making a partition line on A and B such that elements on both sides are equal and then checks boundary value in those partitions
*/

1class Solution {
2    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
3        if (nums1.length > nums2.length) {
4            return findMedianSortedArrays(nums2, nums1);
5        }
6        int m = nums1.length;
7        int n = nums2.length;
8        // Start and end pointers of nums1
9        int left = 0;
10        int right = m;
11        // When our partition is correct boundary conditions must hold maxleftA <= minRightB && maxLeftB <= minRightA
12        while (left <= right) {
13            // Basically an imaginary partition line on A (also determines how many elements in left of A this partition contributes)
14            int partitionA = (left + (right - left)/2);
15            // partition of B determined by assuming that ALeft + BLeft should have equal elements (since idea is to partition merged array A + B)
16            int partitionB = (m + n + 1)/2 - partitionA;
17            // In sorted array maxLeft to the partition line is partitionA - 1 incase of 0 it is -Inf
18            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE: nums1[partitionA - 1];
19            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE: nums2[partitionB - 1];
20            // Similarly
21            int minRightA = (partitionA == m) ? Integer.MAX_VALUE: nums1[partitionA];
22            int minRightB = (partitionB == n) ? Integer.MAX_VALUE: nums2[partitionB];
23
24            if(maxLeftA <= minRightB && maxLeftB <= minRightA) {
25                if((m+n)%2 == 1) {
26                    // Odd Case, 
27                    return Math.max(maxLeftA, maxLeftB);
28                } else {
29                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB))/2.0;
30                }
31            } else if(maxLeftA > minRightB) {
32                // partitionA is far too right;
33                right = partitionA - 1;
34            } else {
35                left = partitionA + 1;
36            }
37        }
38        return 0.0;
39    }
40}