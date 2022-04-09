/*You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.

The right interval for an interval i is an interval j such that startj >= endi and startj is minimized. Note that i may equal j.

Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.

 
Input: intervals = [[3,4],[2,3],[1,2]]
Output: [-1,0,1]
Explanation: There is no right interval for [3,4].
The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.


Input: intervals = [[1,4],[2,3],[3,4]]
Output: [-1,2,-1]
Explanation: There is no right interval for [1,4] and [3,4].
The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.
*/
class Solution {
    public int binarySearch(int s [], HashMap<Integer, Integer> sp, int ep){
        //if the end point is smaller then first starting point than return the first starting point index form hash map
        if( ep <= s[0]){
          return sp.get(s[0]); 
        }else if( ep > s[s.length - 1]){
          //if the ep is greater than last starting point than there is no right interval just return -1
            return -1;
        }
        int low = 0, high = s.length;
        while(low < high){
            int mid = low + (high - low)/2;
            if(s[mid] >= ep){
                //if we get some value greater and equal to end point than 
               // than we find in the left half for minimum value
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        // at the end we get result form the low
    return sp.get(s[low]);
    }
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        //for result
        int res[] = new int[n];
        //for storing starting point of each intervals
        int startPoints[] = new int[n];
        //for storing starting points with there index 
        HashMap<Integer, Integer> sp = new HashMap<>();
        //go through the interval and store the starting points of every intervals and store the starting point with there index to hash map
        for(int i = 0; i < n; i++){
            startPoints[i] = intervals[i][0];
            sp.put(startPoints[i],i);
        }
        //now we sort the starting points of intervals
        Arrays.sort(startPoints);
        //now for every intervals endpoint we do binary search in rest of the starting point 
        //by comparing end points of the current interval with starting points of rest intervals
        //condition are endpoints >= startpoints of rest
        for(int i = 0; i < n; i++) {
            res[i] = binarySearch(startPoints, sp, intervals[i][1]);
        }
        return res;
    }
}
        
      
