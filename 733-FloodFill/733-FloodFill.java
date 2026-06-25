// Last updated: 6/25/2026, 8:36:57 AM
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[] startPixel = {sr, sc};
        int startColor = image[sr][sc];
        if(startColor == color){
            return image;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(startPixel);
        while(queue.size() > 0){
            int[] currentPixel = queue.peek();
            queue.remove();
            int x = currentPixel[0];
            int y = currentPixel[1];
            int[] diff = {-1, 1, 0, 0};
            for(int i = 0; i < diff.length; i++){
                int x0 = x + diff[i];
                int y0 = y + diff[(diff.length-1) - i];
                if((x0 >= 0 && x0 < image.length && y0 >= 0 && y0 < image[0].length) && image[x0][y0] == startColor){
                    int[] newPixel = {x0, y0};
                    queue.add(newPixel);
                }
            }
            image[x][y] = color;
        }
        return image;
    }
}