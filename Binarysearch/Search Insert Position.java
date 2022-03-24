class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
            // if the target is found than just return that index
                return mid;
            }else if(nums[mid] < target){
            //if the target is not there and the no. at mid is less than target go to the right side
                low = mid + 1;
            }else{
             // if the target is not there and the no. at mid is greater than target go to the left side
                high = mid - 1;
            }
        }
        //here after loop break low is at the index where the target should be the perfectly inserted position index
        return low;
    }
}
