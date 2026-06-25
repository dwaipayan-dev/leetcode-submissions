// Last updated: 6/25/2026, 8:39:08 AM
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            if(i == 0){
                List<Integer> temp = new ArrayList<>();
                temp.add(1);
                pascalTriangle.add(temp);
            } else {
                List<Integer> prevRow = pascalTriangle.get(i-1);
                List<Integer> currRow = new ArrayList<>();
                currRow.add(1);
                for(int j = 0; j < prevRow.size(); j++){
                    if(j == prevRow.size() - 1){
                        currRow.add(1);
                    } else{
                        currRow.add(prevRow.get(j) + prevRow.get(j+1));
                    }
                }
                pascalTriangle.add(currRow);
            }
        }
        return pascalTriangle;
    }
}