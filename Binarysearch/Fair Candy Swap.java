/** Problem Statement **/
/*Alice and Bob have a different total number of candies.
You are given two integer arrays aliceSizes and bobSizes where aliceSizes[i] is the number of candies of the ith box
of candy that Alice has and bobSizes[j] is the number of candies of the jth box of candy that Bob has.

Since they are friends, they would like to exchange one candy box each so that after the exchange, 
they both have the same total amount of candy. The total amount of candy a person has is the sum of the number of candies in each box they have.

Return an integer array answer where answer[0] is the number of candies in the box that Alice must exchange,
and answer[1] is the number of candies in the box that Bob must exchange. If there are multiple answers, you may return any one of them. 
It is guaranteed that at least one answer exists.

 

Example 1:

Input: aliceSizes = [1,1], bobSizes = [2,2]
Output: [1,2]
*/

class Solution {
    public int binarySearch(int nums[], int target){
        int low = 0;
        int high = nums.length;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return 1;
            else if(nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int suma = 0;
        int sumb = 0;
        for(int i = 0; i < aliceSizes.length; i++){
            suma += aliceSizes[i];
        }
        for(int i = 0; i < bobSizes.length; i++){
            sumb += bobSizes[i];
        }
        int diff = (suma - sumb)/2;
        
        Arrays.sort(aliceSizes);
        for(int num: bobSizes){
            if(binarySearch(aliceSizes, num + diff) != -1) return new int[]{num + diff, num};
        }
        return null; 
    }
}
