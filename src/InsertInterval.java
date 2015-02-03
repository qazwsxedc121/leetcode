import java.util.ArrayList;
import java.util.List;

/**
 * User: guoxc
 * Date: 15-2-3
 * Time: 16:38
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval){
        List<Interval> res = new ArrayList<Interval>();
        int[] res0 = findInsertPlace(intervals, newInterval.start);
        int[] res1 = findInsertPlace(intervals, newInterval.end);
        for(int i = 0; i < res0[1]; i += 1){
            res.add(intervals.get(i));
        }
        if(res0[0] == 0 && res1[0] == 0){
            res.add(newInterval);
        }else if(res0[0] == 1 && res1[0] == 0){
            res.add(new Interval(intervals.get(res0[1]).start, newInterval.end));
        }else if(res0[0] == 0 && res1[0] == 1){
            res.add(new Interval(newInterval.start, intervals.get(res1[1]).end));
        }else{
            res.add(new Interval(intervals.get(res0[1]).start, intervals.get(res1[1]).end));
        }
        if(res1[0] == 0){
            for(int i = res1[1]; i < intervals.size(); i += 1){
                res.add(intervals.get(i));
            }
        }else{
            for(int i = res1[1] + 1; i < intervals.size(); i += 1){
                res.add(intervals.get(i));
            }
        }
        return res;
    }
    public int[] findInsertPlace(List<Interval> intervals, int num){
        int[] res = new int[2];
        for(int i = 0; i < intervals.size(); i += 1){
            if(intervals.get(i).start <= num && intervals.get(i).end >= num){
                res[0] = 1;//overlaps
                res[1] = i;//insert place
                return res;
            }else if(num < intervals.get(i).start){
                res[0] = 0; // not overlap
                res[1] = i; // insert before
                return res;
            }
        }
        res[0] = 0;
        res[1] = intervals.size();
        return res;
    }
    public static void test(){
        InsertInterval instance = new InsertInterval();
        List<Interval> array = MergeIntervals.buildIntervals(new int[]{1,2,3,5,6,7,8,10,12,16});
        System.out.println(instance.insert(array, new Interval(4,9)));
    }
}
