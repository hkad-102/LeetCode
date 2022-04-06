/*Given two integer arrays nums1 and nums2, return an array of their intersection. 
Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
*/
class Solution {
  public int[] intersect(int nums1[], int nums2[]){
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    
    List<Integer> result = new ArrayList<>();
    while(true){
      if(i >= nums1.length || j >= nums2.length){
        break;
      }
      if(nums1[i] == nums2[j]){
        result.add(nums1[i]);
        i++;
        j++;
      }
      else if(nums1[i] > nums2[j]){
        j++;
      }else{
        i++;
      }
    }
    int res [] = new int[result.size()];
    for(int k = 0; k < result.size(); k++){
      res[k] = result.get(k);
    }
    return res;
  }
}
          
