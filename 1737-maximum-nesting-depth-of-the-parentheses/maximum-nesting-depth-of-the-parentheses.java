class Solution {
    public int maxDepth(String s) {
     
     int counter =0;
     int max=0;
     for(int i=0;i<s.length();i++)
     {
        char ch = s.charAt(i);
        if(ch =='(')
        {
            counter++;
            if(counter>max)
            {
                max=counter;
            }
        }
        if(ch==')')
        {
            counter--;
        }
     }
     return max;
    }
}