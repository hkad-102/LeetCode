/***** Problem Statement *****

Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise,
return the number of negative numbers in grid.

 

Example 1:

Input: grid = [[4,3,2,-1],
               [3,2,1,-1],
               [1,1,-1,-2],
              [-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
*/

//tc -> O(n + m)
class Solution{
  public int countNegative(int [][]grid){
    int m = grid.length;
    int n = grid[0].length;
    int rows = 0;
    int columns = n - 1;
    int count = 0;
    while( row < m && columns > 0){
      
      if(grid[rows][column] < 0){
        //if the first element in the column is negative then rest of the element in that column is negative
        //so decreament the column and take a count of that colmun
        --column;
        //there are m - rows numbers of element
        count = count + m - rows;
      }else{
        //let say the first element of the column is not negative than go to the next row in the column to get negative element
        
        ++rows;
      }
    }
    //at the end return the count of negative element
    return count;
  }
}

//another solution using binary search
//tc -> O(nlogn)
class Solution{
  public int countNegative(int [][]grid){
    int res = 0;
    for(int i = 0; i < grid.length; i++){
      res += addNegativeOfEachRows(grid[i]);
    }
    return res;
  }
  public int addNegativeOfEachRows(int [] rows){
    int res = 0;
    int low = 0;
    int high = rows.length - 1;
    while(low < high){
      int mid = low + (high - low)/2;
      if(rows[mid] < 0){
        //if the mid is negative than count the element till the mid and search in the left side
        
        res = res + high - mid + 1;
        
        high = mid - 1;
      }else if(row[mid] >= 0){
        //if the element till the mid is positive than go to the right side to find the negative element 
        
        low = mid + 1;
        
      }
    }
    return res;
  }
}
        
        
        
        
        
        
        
        
        
        
        
        
        
      
      
