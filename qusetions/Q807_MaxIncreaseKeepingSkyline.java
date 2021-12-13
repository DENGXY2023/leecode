package qusetions;

public class Q807_MaxIncreaseKeepingSkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int res=0;
        int[] rowMax =new int[grid.length];
        int[] colMax =new int[grid.length];
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                rowMax[i] = Math.max(rowMax[i],grid[i][j]);
                colMax[i] = Math.max(colMax[i],grid[j][i]);
            }
        }
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                res+=Math.min(rowMax[i],colMax[j])-grid[i][j];
            }
        }
        return res;
    }
}
