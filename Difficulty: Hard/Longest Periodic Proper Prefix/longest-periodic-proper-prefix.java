class Solution {
    int getLongestPrefix(String s) {
      int n = s.length();
        for (int len = n - 1; len >= 1; len--) {
           boolean value = true;
           
            for(int i=len; i < n;i++)
            {
                if(s.charAt(i)!=s.charAt(i%len)){
                    value = false;
                    break;
                }
            }

             if(value)return len;
            }
       
        return -1; 
    }

   
}