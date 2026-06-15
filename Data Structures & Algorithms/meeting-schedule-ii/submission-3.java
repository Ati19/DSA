/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) return 0;
        Collections.sort(intervals,Comparator.comparingInt(a->a.start));
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int maxRooms = 0;
        for(Interval interval:intervals){
            while(!pq.isEmpty() && pq.peek()<=interval.start){
                pq.poll();
            }
            pq.add(interval.end);
            maxRooms = Math.max(maxRooms, pq.size());
        }
        return maxRooms;
    }
}