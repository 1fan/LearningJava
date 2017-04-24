package Leetcode_MergeIntervals;

import java.util.Comparator;

/**
 * Created by hasee on 2017/4/19.
 */
public class NewComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval o1, Interval o2) {
        return o1.start-o2.start;
    }


}
