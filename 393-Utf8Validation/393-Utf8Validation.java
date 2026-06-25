// Last updated: 6/25/2026, 8:37:30 AM
class Solution {
    public boolean validUtf8(int[] data) {
        int[] masks = {128, 192, 224, 240, 248};
        for(int i = 0; i < data.length; i++){
            if(data[i] > 248) return false;
            int count = 0;
            for(int mask: masks){
                if(data[i] >= mask){
                    if((data[i] & mask) > 0){
                        count++;
                    }
                } else {
                    break;
                }
            }
            System.out.println(count);
            if(count == 1 && data[i] < 192) return false;
            int countCopy = count-1;
            while(countCopy > 0){
                i++;
                if(i >= data.length || data[i] < 128 || data[i] >= 192) return false;
                countCopy--;
            }

        }
        return true;
    }
}