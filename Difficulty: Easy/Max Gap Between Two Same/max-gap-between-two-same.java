class Solution {
    public int maxCharGap(String s) {
        HashMap<Character,int[]> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
           if(hm.containsKey(s.charAt(i))) {
               int[] j=hm.get(s.charAt(i));
               j[0]=Math.min(j[0],i);
               j[1]=Math.max(j[1],i);
               hm.put(s.charAt(i),j);
           }
           else{
               int[] j={i,i};
               hm.put(s.charAt(i),j);
           }
        }
        if(hm.size()==s.length()) return -1;
        else{
            int m=0;
            for(char c : hm.keySet()){
                int[] j = hm.get(c);
                m=Math.max(j[1]-1-j[0],m);
            }
            return m;
        }
    }
}