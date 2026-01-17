class Solution {
    public static boolean checkRedundancy(String s) {
        // code here
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<n; i++)
        {
            char c = s.charAt(i);
            boolean operator = false;
            if(c==')')
            {
                while(st.peek()!='(')
                {
                    char ch = st.pop();
                    if(ch=='+' || ch=='-' || ch=='*' || ch=='/')
                    operator = true;
                }
                if(!operator) return true;
                st.pop();
            }
            st.push(c);
        }
        return false;
    }
}