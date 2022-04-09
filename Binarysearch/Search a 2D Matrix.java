/*Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        //first element in the matrix
        int low = 0;
        //last element in the matrix
        int high = m * n - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            //took the x coordinate of mid
            int x = mid / n;
            //took the y coordinate of mid
            int y = mid % n;
            if(target == matrix[x][y]) return true;
            else if(target > matrix[x][y]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return false;
    }
}
      
