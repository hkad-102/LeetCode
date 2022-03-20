class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1){
            return x;
        }
        int l = 1;
        int h = x ;
        
        while(l <= h){
            int mid = l + (h - l)/2;
            // use division instead of multiplication to 
            //avoid overflow mid * mid < x avoid this 
            if(mid  < x/mid){
                l = mid + 1; 
                
            }
            else if(mid  > x/mid){
                h = mid - 1;
                
            }
            else{
                return mid;
               
            }
        }
        return h;
    }
}
