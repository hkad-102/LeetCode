
/*Let's call an array arr a mountain if the following properties hold:

* arr.length >= 3
* There exists some i with 0 < i < arr.length - 1 such that:
* arr[0] < arr[1] < ... arr[i-1] < arr[i]
* arr[i] > arr[i+1] > ... > arr[arr.length - 1]
* Given an integer array arr that is guaranteed to be a mountain, 
* return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
  [ 1 2 3 4 5 6 4 3 2 1 ] let say we are on 3 than 3 is greater than 2 than we have to go to right side to get 6
*/

class Solutions{
  public int peakIndMountainArray(int [] arr){
    int low = 0;
    int high = arr.length - 1;
    while(low < high){
      int mid = low + (high - low)/2;
      //if the middle element is greater than the mid + 1 than find the peak in the left side 
      if(arr[mid] > arr[mid + 1]){
        high = mid;
      }else{
        low = mid + 1;
      }
    }
    return low;
  }
}
        
    
