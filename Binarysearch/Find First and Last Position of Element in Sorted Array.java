/*Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]*/
class Solution{
  public int BinarySearch(int nums[], int target, boolean FirstIndex){
    //initially the ans is -1 if we dont find we pass -1
    int ans = -1;
    int low = 0;
    int high = nums.length - 1;
    while(low <= high){
      int mid = low + (high - low)/2;
      //if the mid value is greater than target find in the right side
      if(nums[mid] > target){
        high = mid - 1;
      }else if(nums[mid] < target){
        //if the mid value is less than target find in the left side
        low = mid + 1;
      }else{
        //if we find the target then store the index to ans
        ans = mid;
        //if it is the first index of target than find in the right side that is 
        //there also a any element present in right side (because the array is not distinct it may have duplicate element)here we are passing true
        if(FirstIndex){
          high = mid - 1;
        }else{
          // if is not the first index of target than go to the left side  
          //there also any element present in the left side (because the array is not distinct it may have duplicate element) we are passing false
          low = mid + 1;
        }
      }
    }//return the ans you stored
    return ans;
  }
  public int[] searchRange(int nums[], int target){
    int res = {-1, -1};
    //find the startIndex by using binary search here we are passing the nums arr , target, if it is first Index than we are passing true
    int startIndex = BinarySearch(nums, target, true);
    //find the endIndex by using binary search here we are passing the nums arr, target, if it is second Index than we are passing false
    int endIndex = BinarySearch(nums, target, false);
    res[0] = startIndex;
    res[1] = endIndex;
    return res;
  }
      
