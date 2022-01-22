/**
 * @author dingxudong
 * @create 2021-09-09 20:42
 * @Description
 * 给出一组区间，请合并所有重叠的区间。
 * 请保证合并后的区间按区间起点升序排列。
 */
public class NC37 {
//    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
//        Collections.sort(intervals, (x, y) -> x.start-y.start);
//        ArrayList<Interval> list = new ArrayList<Interval>();
//        int i = 0;
//        while(i < intervals.size()){
//            int left = intervals.get(i).start;
//            int right = intervals.get(i).end;
//            if(i + 1 < intervals.size() && right >= intervals.get(i+1).start){
//                while(i + 1 < intervals.size() && right >= intervals.get(i+1).start){
//                    right = Math.max(right, intervals.get(i+1).end);
//                    i++;
//                }
//            }
//            list.add(new Interval(left, right));
//            i++;
//        }
//        return list;
//    }
}
