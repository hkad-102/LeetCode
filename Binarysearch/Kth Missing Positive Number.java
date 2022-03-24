class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            //we check at mid that is the missing no. count is greater or lesser than the no. of element we want arr[mid] means 
          //the no. present there the mid shows the index and - 1 for one less than index this gives that the actual no that 
          //should be there and the no. present is larger so subtract it from there
            int missingNumberCount = arr[mid] - mid - 1;
            if(missingNumberCount < k){
                //missing no. count till now is less than the no. we want so go to the right side
                low = mid + 1;
            }else{
                //missing no. count till now is greater than the no. we want so go to the left side
                //missingNumberCount > k 
                high = mid - 1;
            }
        }
        //let say the target is 1 (k == 1) and the arr[2,3,4,5] so the answer is 1 and after traversing we get high 
      //is at -1 index so just return the k
        if(high < 0) return k;
        //here after the loops break the high index is that position from were we get the ans so we take 
      //the no. missing at that point let say in example 1 high will be at 7 so missing no. at 7 is 3 we have to 
      //find that arr[high] - high - 1 ==> 7 - 3 - 1 = 3
        int totalMissingNumberCountTill = arr[high] - high - 1;
        // let say if there is a situation came that there is no missing no. and still we have to get 
      //the no. k == 2 arr[1,2,3,4] here there is no missing number but the answer is 6 because after 4 there is 5,6... 
      //so we return arr[high] + k - totalMissingNumberCount till that ==> arr[high] = 4 , k = 2, tMNC = 0 ==> // 4 + 2 - 0 = 6 
      // totalMissingNumberCountTill is the count of no. missing at that point
      //if we add arr[high] + k let say 7 + 5 is 12 so we have to subtract the total missing count at that point than it will give me the 
      //correct ans 7+ 5 - 3 = 9 in this way
     return arr[high] + k - totalMissingNumberCountTill;
    }
}
