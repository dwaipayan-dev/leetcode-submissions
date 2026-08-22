// Last updated: 8/22/2026, 6:26:57 AM
1class NumArray {
2
3    public class SegmentTreeNode {
4        int start, end, sum;
5        SegmentTreeNode left, right;
6
7        public SegmentTreeNode(int start, int end) {
8            this.start = start;
9            this.end = end;
10            this.sum = 0;
11            this.left = null;
12            this.right = null;
13        }
14    }
15
16    SegmentTreeNode root = null;
17
18    public SegmentTreeNode buildTree(int[] nums, int start, int end) {
19        if(start > end) {
20            return null;
21        } else {
22            SegmentTreeNode ret = new SegmentTreeNode(start, end);
23            if(start == end) {
24                ret.sum = nums[start];
25            } else {
26                int mid = start + (end - start)/2;
27                ret.left = buildTree(nums, start, mid);
28                ret.right = buildTree(nums, mid + 1, end);
29                ret.sum = ret.left.sum + ret.right.sum;
30            }
31            return ret;
32        }
33    }
34
35    public void update(SegmentTreeNode root, int index, int val) {
36        if(root.start == root.end) {
37            root.sum = val;
38        } else {
39            int mid = root.start + (root.end - root.start)/2;
40            if(index <= mid) {
41                update(root.left, index, val);
42            } else {
43                update(root.right, index, val);
44            }
45            // Propagate up new sum
46            root.sum = root.left.sum + root.right.sum;
47        }
48    }
49
50    public int sumRange(SegmentTreeNode root, int start, int end) {
51        if(root.start == start && root.end == end) {
52            return root.sum;
53        } else {
54            int mid = root.start + (root.end - root.start)/2;
55            if(end <= mid) {
56                return sumRange(root.left, start, end);
57            } else if(start > mid) {
58                return sumRange(root.right, start, end);
59            } else {
60                return sumRange(root.left, start, mid) + sumRange(root.right, mid+1, end);
61            }
62        }
63    } 
64
65    public NumArray(int[] nums) {
66        root = buildTree(nums, 0, nums.length - 1);
67    }
68    
69    public void update(int index, int val) {
70        update(root, index, val);
71    }
72    
73    public int sumRange(int left, int right) {
74        return sumRange(root, left, right);
75    }
76}
77
78/**
79 * Your NumArray object will be instantiated and called as such:
80 * NumArray obj = new NumArray(nums);
81 * obj.update(index,val);
82 * int param_2 = obj.sumRange(left,right);
83 */