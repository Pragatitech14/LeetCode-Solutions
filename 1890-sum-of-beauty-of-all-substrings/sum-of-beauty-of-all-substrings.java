class Solution {
    public int beautySum(String s) {
         int sum=0;
         int beauty =0;

        for(int i=0;i<s.length();i++)
        {
            int [] freq = new int[26];
            for(int j=i;j<s.length();j++)
            {
               
               
                    char ch=s.charAt(j);
                    freq[ch-'a']++;
                

                int maxfreq = 0;
                int minfreq =Integer.MAX_VALUE;


                for(int k=0;k<freq.length;k++)
                {
                    if(freq[k]>0)
                    {
                    maxfreq=Math.max(freq[k],maxfreq);
                     minfreq=Math.min(freq[k],minfreq);
                    }

                  
                }
                 beauty =maxfreq-minfreq;
                  sum=sum+beauty;
            }
        }
        return sum;
    }
}