package qusetions;

public class Q48_Rotate {
    public void rotate(int[][] matrix) {
        int out=0, n=matrix.length;
        // 第i层旋转
        for(int i=0; i< n/2;i++){
            // 第j组旋转
            for(int j=i; j<n-1-i;j++){
                // 使用一个temp保存
                int temp = matrix[i][j];
                //旋转公式，每组4个元素旋转
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Q48_Rotate q48 = new Q48_Rotate();

        int[][] a = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        q48.rotate(a);
        System.out.println(a);
    }

}
