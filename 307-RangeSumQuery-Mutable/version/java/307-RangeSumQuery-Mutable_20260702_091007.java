// Last updated: 7/2/2026, 9:10:07 AM
// Faced a few implementation bugs around conditions but overall was able to solve the solution mostly by myself
1class NumArray {
2    class SegmentTreeNode {
3        int sum, start, end;
4        SegmentTreeNode left, right;
5
6        public SegmentTreeNode(int start, int end) {
7            this.start = start;
8            this.end = end;
9            this.left = null;
10            this.right = null;
11            this.sum = 0;
12        }
13    }
14
15    SegmentTreeNode root;
16
17    public SegmentTreeNode buildTree(int[] nums, int start, int end) {
18        if(start > end) return null;
19        SegmentTreeNode ret = new SegmentTreeNode(start, end);
20        if(start == end) {
21            ret.sum = nums[start];
22        } else {
23            int mid = start + (end - start)/2;
24            ret.left = buildTree(nums, start, mid);
25            ret.right = buildTree(nums, mid + 1, end);
26            ret.sum = ret.left.sum + ret.right.sum;
27        }
28        return ret;
29    }
30
31    public void update(SegmentTreeNode root, int index, int val) {
32        if(root.start == root.end) {
33            root.sum = val;
34        } else {
35            int mid = root.start + (root.end - root.start)/2;
36            if(index <= mid) {
37                update(root.left, index, val);
38            } else {
39                update(root.right, index, val);
40            }
41            root.sum = root.left.sum + root.right.sum;
42        }
43    }
44
45    public int sumRange(SegmentTreeNode root, int start, int end) {
46        if(root.start == start && root.end == end) {
47            return root.sum;
48        } else {
49            int mid = root.start + (root.end - root.start)/2;
50            if (end <= mid) {
51                return sumRange(root.left, start, end);
52            } else if(start > mid) {
53                return sumRange(root.right, start, end);
54            } 
55            return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
56        }
57    }
58
59    public NumArray(int[] nums) {
60        root = buildTree(nums, 0, nums.length - 1);
61    }
62    
63    public void update(int index, int val) {
64        update(root, index, val);
65    }
66    
67    public int sumRange(int left, int right) {
68        return sumRange(root, left, right);
69    }
70}
71
72/**
73 * Your NumArray object will be instantiated and called as such:
74 * NumArray obj = new NumArray(nums);
75 * obj.update(index,val);
76 * int param_2 = obj.sumRange(left,right);
77 */