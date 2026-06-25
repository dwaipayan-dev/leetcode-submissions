// Last updated: 6/25/2026, 8:37:38 AM
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int[] n = nums1.length>nums2.length? nums1:nums2;
        for(int i = 0; i < n.length; i++){
            freqMap.put(n[i], freqMap.getOrDefault(n[i], 0) + 1);
        }
        
        n = nums1.length<=nums2.length? nums1:nums2;
        List<Integer> numsIntersect = new ArrayList<>();
        for(int i = 0; i < n.length; i++){
            if(freqMap.getOrDefault(n[i], 0) != 0){
                numsIntersect.add(n[i]);
                freqMap.put(n[i], freqMap.get(n[i]) - 1);
            }
        }
        int[] resArr = new int[numsIntersect.size()];
        int count = 0;
        for(Integer i: numsIntersect){
            resArr[count++] = i.intValue();
        }
        return resArr;
    }
}