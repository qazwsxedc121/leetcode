import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-2-3
 * Time: 15:52
 */
class Interval{
    int start;
    int end;
    Interval() {
        start = 0;
        end = 0;
    }
    Interval(int s, int e){
        start = s;
        end = e;
    }
    public String toString(){
        String res = "[" + start + "," + end + "]";
        return res;
    }
}
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals){
        Collections.sort(intervals,
                new Comparator<Interval>() {
                    @Override
                    public int compare(Interval interval, Interval interval2) {
                        if(interval.start > interval2.start)
                            return 1;
                        else if(interval.start == interval2.start)
                            return 0;
                        else
                            return -1;
                    }
                });
        int i = 0;
        List<Interval> res = new ArrayList<Interval>();
        while(i < intervals.size()){
            Interval interval0 = intervals.get(i);
            i += 1;
            int end = interval0.end;
            while(i < intervals.size() && intervals.get(i).start <= end){
                if(intervals.get(i).end > end){
                    end = intervals.get(i).end;
                }
                i += 1;
            }
            res.add(new Interval(interval0.start,end));
        }
        return res;
    }
    public static List<Interval> buildIntervals(int[] pairs){
        int i = 0;
        List<Interval> res = new ArrayList<Interval>();
        while(i < pairs.length - 1){
            res.add(new Interval(pairs[i],pairs[i+1]));
            i += 2;
        }
        return res;
    }
    public static void test(){
        MergeIntervals instance = new MergeIntervals();
        List<Interval> intervals = buildIntervals(new int[]{1,3,2,6,8,10,15,18});
        System.out.println(instance.merge(intervals));
    }
}
