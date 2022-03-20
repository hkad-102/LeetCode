public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1;//because the range is from 1 to n
        int end = n;
        while(start <= end){
            int mid = start + (end - start)/2;
            // here we always check the mid value you get 
            int res = guess(mid);
            //this is use to get the api that the ans is true or false 
            
            if(res == 0){
                //if the answer you get is correct than just return mid because we are checking the mid 
                //always for the answer
                return mid;   
            }
            else if(res == 1){
                //the no. you gess is smaller to the no. I pick so comes towards me than do mid + 1
                start = mid + 1;
            }
            else
                //the no. you guess is bigger than the no. I pick so comes towards me than do mid - 1
               end = mid - 1; 
        }
        return start;
        
    }
}
