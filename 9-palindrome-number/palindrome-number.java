class Solution {
    public boolean isPalindrome(int x) {
        boolean found = false;
        int og = x;
        int sum =0;
        int rev = 0;
        if(x<0)
        {
            return false;
        }
        while(x>0) 
        {
            rev = x%10;
            x = x/10;
            sum = sum*10+rev;
        }  

        if(og==sum)
        {
            return true;
        } 
        return false;    
    }
}