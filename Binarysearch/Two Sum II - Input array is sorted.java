class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int res[] = new int[]{-1, -1};//declare the result array where you store the result
        
        //corner case if the length of the numbers array is less than 2
        if(numbers.length < 2) return res;
        
        int left = 0;
        int right = numbers.length - 1;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            
            //case 1 
            if(numbers[left] + numbers[right] == target){
               //simple case
                return new int[]{left + 1, right + 1};
            }
            //case 2
            else if(numbers[left] + numbers[right] < target){
                
                if(numbers[mid] + numbers[right] == target){
                    return new int[]{mid + 1, right + 1};
                }else if(numbers[mid] + numbers[right] < target){
                    left = mid + 1;
                }
                else{
                    //number[mid] + number[right] > target
                    left++;
                }
            }
            //case 3
            else{
                //number[left] + numbers[right] > target
                if(numbers[left] + numbers[mid] == target){
                    return new int[]{left + 1, mid + 1};
                }
                else if(numbers[left] + numbers[mid] > target){
                    right = mid - 1;
                }
                else{
                    //numbers[left] + numbers[mid] < target
                    right-- ; 
                    //we dont do that mid + 1 because mid element is greater and we do this than then we cant get the ans
                }
            }
        }
        return res;
        
    }
}
