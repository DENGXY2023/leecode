package qusetions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1610_VisiblePoints {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int sameCounts=0;
        int counts =0;
        List<Double> polarDegrees = new ArrayList<>();
        for(int i =0; i<points.size();i++){
            double degree = angle(points.get(i), location);
            if(degree==-360){
                sameCounts++;
                continue;
            }
            polarDegrees.add(degree);
        }
        Collections.sort(polarDegrees);
        int n = polarDegrees.size();
        for(int i=0;i<n;i++) {
            polarDegrees.add(polarDegrees.get(i) + 360);
        }
        for(int i=0;i<n;i++){
            int right=0;
            double maxDegree = polarDegrees.get(i)+angle;
            while(right<polarDegrees.size()&&polarDegrees.get(right)<=maxDegree){
                right++;
            }
            counts = Math.max(counts,right-i);
        }

        return counts+sameCounts;
    }
    private double angle(List<Integer> point, List<Integer> location){
        if(point.get(0)- location.get(0)==0){
            if(point.get(1)-location.get(1)==0){
                return -360;
            }
            return point.get(0)>location.get(0)?90:270;
        }
        double k = (location.get(1)-point.get(1))*1.0/(location.get(0)-point.get(0));
        double angle=0;
        if(point.get(1)-location.get(1)>=0&&point.get(0)-location.get(0)>0){
            angle = Math.atan(k)*180/Math.PI;
        }
        else if(point.get(0)-location.get(0)<0){
            angle = Math.atan(k)*180/Math.PI+180;
        }
        else{
            angle = Math.atan(k)*180/Math.PI+360;
        }
        return angle;
    }

    public static void main(String[] args) {
        Q1610_VisiblePoints q1610 = new Q1610_VisiblePoints();
        List<Integer> point1 =new ArrayList<>(){{
            add(2);
            add(1);
        }};
        List<Integer> point2 =new ArrayList<>(){{
            add(2);
            add(2);
        }};
        List<Integer> point3 =new ArrayList<>(){{
            add(3);
            add(4);
        }};
        List<Integer> point4 =new ArrayList<>(){{
            add(1);
            add(1);
        }};
        List<Integer> location =new ArrayList<>(){{
            add(1);
            add(1);
        }};
        List<List<Integer>> points = new ArrayList<>(){{
            add(point1);
            add(point2);
            add(point3);
            add(point4);
        }};
        double angle = q1610.angle(point1, location);
        int a = q1610.visiblePoints(points,90,location);
        System.out.println(a);
    }
}
