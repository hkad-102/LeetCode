public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        //check if the element is 0 than return -1 or let say last element is also not a bad version
        // then there is no one is bad version in the supply
        if( n <= 0 || !isBadVersion(n)){
            return -1;
        }
        //let say the first element is bad version than the rest of the element is bad so no need to check
        //rest of all are bad version or not just return 1
        if(isBadVersion(1)){
            return 1;
        }
       int start = 1;
       int end = n;
        while(start <= end){
            int mid = start + (end - start)/2;
            // the no at mid is bad version than check at mid - 1 element is there any element in the right 
            // side is bad or not
            if(isBadVersion(mid)){
                end = mid - 1;
            }
            //if the mid element is not bad version than we check in the left side that is there any bad version is present
            else{
                start = mid + 1;
            } 
        }
        return start;
    }
}
