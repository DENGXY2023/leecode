package qusetions;
// 找法官
public class Q997_FindJudge {
    public int findJudge(int n, int[][] trust) {
        int[][] a = new int[n][2];
        for(int i=0;i<n;i++){
            a[trust[i][0]][0]++;
            a[trust[i][1]][1]++;
        }
        for(int i=0;i<n;i++){
            if(a[i][0]==0&&a[i][1]==n-1){
                return i;
            }
        }
        return -1;
    }
}
