/*.    Given two integer arrays nums1 and nums2, return an array of their intersection.
        Each element in the result must be unique and you may return the result in any order.

        Example 1:

        Input: nums1 = [1,2,2,1], nums2 = [2,2]
        Output: [2]
*/
class Solution{
  public int[] intersection(int nums1[], int nums2[]){
    //hashset solution
    //hashset num is used to store the distinct value of nums1
    Set<Integer> num = new HashSet<>();
    //hashset intersection is used to store the distinct value of intersection
    Set<Integer> intersection = new HashSet<>();
    //for each element of nums1 put it into num hashset
    for(int element : nums1){
      num.add(element);
    }
    //for each element of nums2 check that it present in the num hashset or not if it is present than add it to intesection hashSet
    for(int element: nums2){
      if(num.contains(element)){
        intesection.add(element)
        }
    }
    //now we have to return the arr and our answer is in the hashset
    int n = intesection.size();
    //make a result arr
    int result[] = new result[n];
    int i = 0;
    for(int element: intersection){
      result[i] = element;
      i++;
    }
    return result;
  }
}


//another solution using binary search and one hashset for storing intersection ans because we want intersection unique
class solution{
  public int[] intersection(int nums1[], int nums2[]){
    //sort the array first because we dont know that the array is sorted or not
    Arrays.sort(nums1);
    //now we have to check each element of nums2 that it present in nums1 or not using binary search
    for(int element: nums2){
      if(binarySearch(nums1, element)){
        intersection.add(element);
      }
    }
    int result[] = new int[intersection.size()];
    int i = 0;
    for(int element: intersection){
      result[i] = element;
      i++;
    }
    return result;
  }
  public boolean binarySearch(int nums[], int target){
    int low = 0;
    int high = nums.length - 1;
    while(low <= high){
      int mid = low + (high - low)/2;
      if(nums[mid] < target){
        low = mid + 1;
      }else if(nums[mid] > target){
        high = mid - 1;
      }else{
        return true;
      }
    }
    return false;
  }  
}
        

