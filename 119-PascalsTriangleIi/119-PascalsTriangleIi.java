// Last updated: 6/25/2026, 8:39:07 AM
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pascalRow = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++){
            pascalRow.add(1);
            for(int j = i-1; j > 0; j--){
                int k = pascalRow.get(j);
                k += pascalRow.get(j-1);
                pascalRow.set(j, k); 
            }
        }
        return pascalRow;
    }
}