import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Administrator on 2015/9/9.
 */
public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        Comparator<Interval> cmp = new Comparator<Interval>(){
            public int compare(Interval t1, Interval t2){
                if(t1.start > t2.start) return 1;
                else if(t1.start == t2.start) return 0;
                else return -1;
            }
        };
        int n = intervals.length;
        if(n <= 1) return true;
        Arrays.sort(intervals, cmp);
        int last = intervals[0].end;
        for(int i = 1; i < n; i += 1){
            if(intervals[i].start < last) return false;
            else{
                last = intervals[i].end;
            }
        }
        return true;

    }
}
