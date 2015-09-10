import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2015/9/10.
 */
public class MeetingRoomsII {
    private int minM(List<Interval> l){
        int n = l.size();
        if(n <= 1) return n;
        int last = l.get(0).end;
        List<Interval> nl = new ArrayList<Interval>();
        for(int i = 1; i < n; i += 1){
            Interval itv = l.get(i);
            if(itv.start >= last){
                last = itv.end;
            }else{
                nl.add(itv);
            }
        }
        return minM(nl) + 1;
    }
    public int minMeetingRooms(Interval[] intervals) {
        Comparator<Interval> cmp = new Comparator<Interval>(){
            public int compare(Interval t1, Interval t2){
                if(t1.start > t2.start) return 1;
                else if(t1.start == t2.start) return 0;
                else return -1;
            }
        };
        Arrays.sort(intervals, cmp);
        List<Interval> l = new ArrayList<Interval>();
        int n = intervals.length;
        for(int i = 0; i < n; i += 1){
            l.add(intervals[i]);
        }
        return minM(l);
    }
}
