// Last updated: 6/25/2026, 8:36:39 AM
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid - 1 < 0){
                start = mid + 1;
                continue;
            } 
            if(mid + 1 >= n){
                end = mid - 1;
                continue;
            }
            if(arr[mid] < arr[mid+1] && arr[mid] > arr[mid - 1]){
                start = mid + 1;
            }
            else if(arr[mid] > arr[mid+1] && arr[mid] < arr[mid - 1]){
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}