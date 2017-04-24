package Leetcode_MergeIntervals;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

/**
 * Created by hasee on 2017/4/18.
 * Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[0,5],[1,2],[15,18],
 return [0,5],[15,18].
 */
public class Solution {
    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals,new NewComparator());
        List<Interval> result = new ArrayList<Interval>();
        Interval prev = intervals.get(0);
        for(int i=1; i<intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(prev.end >= curr.start){
                prev.end = Math.max(prev.end, curr.end);
            }else {
                result.add(prev);
                prev = curr;
            }
        }
        result.add(prev);
        return result;
    }



    public static void main(String [] args){
        Interval A = new Interval(1,3);
        Interval B = new Interval(0,5);
        Interval C = new Interval(1,2);
        Interval D = new Interval(15,18);
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(A);
        intervals.add(B);
        intervals.add(C);
        intervals.add(D);
        List<Interval> Result =merge(intervals);
        for(Interval i : Result){
            System.out.println(i.start+"--"+i.end);
        }
    }
}
