/**Problem  statement */
/*You are given an array nums of non-negative integers. nums is considered special if there exists a number x such 
that there are exactly x numbers in nums that are greater than or equal to x.

Notice that x does not have to be an element in nums.

Return x if the array is special, otherwise, return -1. It can be proven that if nums is special, the value for x is unique.

 

Example 1:

Input: nums = [3,5]
Output: 2
Explanation: There are 2 values (3 and 5) that are greater than or equal to 2.*/
class Solution {
    public int specialArray(int[] nums) {
       Arrays.sort(nums);
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] >= len - mid){
                if(mid == 0 || nums[mid - 1] < len - mid){
                    return len - mid;
                }else{
                    high = mid - 1;
                }
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
