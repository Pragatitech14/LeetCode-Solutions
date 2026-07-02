class Solution {
    int start =0;
    int maxlen =1;

    public String longestPalindrome(String s) {
       
        if(s==null || s.length()==0) return "";


        for(int i =1;i<s.length();i++)
        {
            //even length
            expand(s,i-1,i);
            //odd length
            expand(s,i-1,i+1);
        } 

      return s.substring(start,start+maxlen);  
  }

  public void expand(String s,int left,int right)
  {
    
    while(left>=0 && right<s.length() 
    && s.charAt(left)==s.charAt(right))
    {
       
       if(right-left+1>maxlen)
       {
        maxlen = right-left+1;
        start=left;
       }
       left--;
       right++;
    }
    
  }
}