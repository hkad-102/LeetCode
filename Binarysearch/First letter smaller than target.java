class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        //similar concept like in first bad version
        int low = 0;
        int high = letters.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            // if the letter at mid is greater than target don't return it search in the right side is 
            // there any element present that is also greater than the target
            if(letters[mid] > target){
                high = mid - 1;
            }//if the letter is smaller than target just go to the right side and find the element
            else{
                //letters[mid] < target
                low = mid + 1;
            }
        }
        // for returning low % letters.length there is a reason behind it lets say the target is z and the first element in the array is a than we have to return a because after z the letter came is a so in this way a is greater than z so the pointer will go to that point its a corner case we have to handle
        return letters[low % letters.length];
        
    }
}
