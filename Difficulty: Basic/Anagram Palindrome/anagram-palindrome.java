class Solution {
    boolean canFormPalindrome(String s) {
        HashSet<Character>set= new HashSet<>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(set.contains(c))
            {
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        if(set.size()<=1)
        return true;
        
        return false;
    }
}