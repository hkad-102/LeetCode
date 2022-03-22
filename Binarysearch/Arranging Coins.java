class Solution{
	//one of the good question to understand binary search 
	public int arrangeCoins(int n){
		int low = 1;//start low with one because it first stair always have coins last stair is not filled not matter but first must be filled
		int high = n;
		 while(low <= high){
            long mid = low + (high-low)/2;
            //we are using mid for summation because the summation till mid is it valid or not
            long sum  = mid*(mid+1)/2;
            
            if(sum == n){
                // if the summation matches with the coins than we can form the complete stairs at that point so just return mid
                return (int)mid;
            }
            //if summation till mid become smaller than the no. of coins given than reduce your search 
            //space and the sumation we get in right side
            else if(sum < n){
                low = mid+1;
            }
            //if summation till mid become greater than the no. of coins given than reduce your search
            //space and the sumation we get is in left side
            else {
                //sum > n
                high = mid-1;
            }
        }
     //returning high is also a reason behind it sometime our low,high and mid are at that 
		//point which is one greater than the actual no. and when high become one less and the loop break at 
		//that time high is on point which is the accurate answer thats why we return high only 
        return (int)high;
    }
}
