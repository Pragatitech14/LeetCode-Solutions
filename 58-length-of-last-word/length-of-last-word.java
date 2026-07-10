class Solution {
    public int lengthOfLastWord(String s)
    {
      String s1 = s.trim();
      int l=0;
      int l1 =s1.length();
     
      for(int i=l1-1;i>=0;i--)
      {
       
        if(s1.charAt(i)==' ')
        {
            break;
        }
         l++;
      }
      return l; 
    }
}