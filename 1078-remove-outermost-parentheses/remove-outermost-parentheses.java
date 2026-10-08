class Solution {
    public String removeOuterParentheses(String s) {
        int counter =0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==')')
            {
                counter--;
            }
            if(counter!=0)
            {
                sb.append(s.charAt(i));
            }
            if(s.charAt(i)=='(')
            {
                counter++;
            }
        }
        return sb.toString();
    }
}