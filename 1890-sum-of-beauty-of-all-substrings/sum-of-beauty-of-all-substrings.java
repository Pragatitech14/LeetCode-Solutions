class Solution {
    public int beautySum(String s) {
         int sum=0;
         int beauty =0;

        for(int i=0;i<s.length();i++)
        {
             HashMap<Character,Integer> map = new HashMap<>();
            for(int j=i;j<s.length();j++)
            {
               
               
                    char ch=s.charAt(j);
                    map.put(ch,map.getOrDefault(ch,0) +1);
                

                int maxfreq = 0;
                int minfreq =Integer.MAX_VALUE;


                for(int freq:map.values())
                {
                    maxfreq=Math.max(freq,maxfreq);
                     minfreq=Math.min(freq,minfreq);

                  
                }
                 beauty =maxfreq-minfreq;
                  sum=sum+beauty;
            }
        }
        return sum;
    }
}