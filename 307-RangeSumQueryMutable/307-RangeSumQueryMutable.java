// Last updated: 6/25/2026, 8:37:49 AM
class NumArray {

    public class SegmentTreeNode {
        int start;
        int end;
        int sum;
        SegmentTreeNode left;
        SegmentTreeNode right;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
            this.left = null;
            this.right = null;
        }
    }

    SegmentTreeNode root = null;

    public SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if(start > end) return null;
        else {
            SegmentTreeNode ret = new SegmentTreeNode(start, end);
            if(start == end) {
                ret.sum = nums[start];
            } else {
                int mid = start + (end - start)/2;
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid+1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            return ret;
        }
    }

    public void update(SegmentTreeNode root, int pos, int val) {
        if(root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start)/2;
            if(pos <= mid) {
                update(root.left, pos, val);
            } else {
                update(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(SegmentTreeNode root, int start, int end) {
        if(root.start == start && root.end == end) return root.sum;
        int mid = root.start + (root.end - root.start)/2;
        if(end <= mid) {
            return sumRange(root.left, start, end);
        } else if(start > mid) {
            return sumRange(root.right, start, end);
        }
        return sumRange(root, start, mid) + sumRange(root, mid + 1, end);
    }

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    
    public void update(int index, int val) {
        update(root, index, val);
    }
    
    public int sumRange(int left, int right) {
        return sumRange(root, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */