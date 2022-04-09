/*Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. 
The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
*/






class Solution {
    public boolean canEatBananaInTime(int []piles, int k, int h){
        int hour = 0;
        for(int pile : piles){
            // performing calculation, take an example 
            // k = 4
            // pile = 10
            // pile / k => 10 / 4 = 2
            // pile % k => 2, so we need to have one more hour 
            //to eat remaining bananas left over as remainder 
            // hours = 3;
            int div = pile/k;
            hour += div;
            if(pile % k != 0) hour++;//if there is a remainder 
            //than we need an extra hour to finish the remaining bananas
        }
        return hour <=h;//it will return true only when our eating hours is less than given hrs
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1; 
        int high = Integer.MAX_VALUE;
        while(low <= high){//performing bs
            int mid = low + (high - low)/2;
            //if koko can eat banana in less than or equal time
            if(canEatBananaInTime(piles,mid,h)){
                high = mid - 1;//if it eat within time we have to look for more optimal time
                
            }else{
                low = mid + 1;
            }
        }
        return low;//we consider low because it will give us the optimized ans
    }
}
  
         
