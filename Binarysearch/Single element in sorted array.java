/*You are given a sorted array consisting of only integers where every element appears exactly twice, 
except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

*/
class Solution{
  public int singleNonDuplicated(int[] arr){
    int low = 0;
    int high = arr.length - 1;
    while(low < high){
      int mid = low + (high - low)/2;
      if((mid % 2 == 0 && arr[mid] == arr[mid + 1]) || (mid % 1 == 0 && arr[mid] == arr[mid - 1])){
        //if the mid index is even than element at mid is must equal to mid + 1 element 
        //or if the mid index is odd than element at mid and mid - 1 is must be equal than 
        //the condition till mid is fine so we have to find the single element in left side
        low = mid + 1;
      }else{
        //else the condition till mid is not fine than so we find it in right side
        high = mid;
      }
    }
    return arr[low];
  }
}
