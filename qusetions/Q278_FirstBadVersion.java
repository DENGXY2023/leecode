package qusetions;

public class Q278_FirstBadVersion {
    public int firstBadVersion(int n) {
        int good=1,bad=n;
        while(good<bad){
            int mid = (bad-good)/2+good;
            if(!isBadVersion(mid)){
                good=mid;
            }
            else{
                bad=mid+1;
            }
        }
        return good;
    }
    public boolean isBadVersion(int version){
        return true;
    }
}
