class Solution {
    
    private void solve(String s,int parts,int idx,ArrayList<String> ans, StringBuilder str){
        if(parts == 4 && idx == s.length()){
            ans.add(str.toString());
            return;
        }
        
        if(parts == 4 || idx == s.length()){
            return ;
        }
        
        int n = str.length();
        for(int i=idx;i<Math.min(s.length(),idx+3);i++){
            String part = s.substring(idx,i+1);
            
            if(part.length() > 1 && part.charAt(0) == '0'){
                break;
            } 
            
            int partParse = Integer.parseInt(part);
            
            if(partParse > 255){
                break;
            }
            
            if (str.length() != 0) str.append(".");
            
            str.append(part);
            
            solve(s,parts+1,i+1,ans,str);
            
            str.setLength(n);
        }
    }
    
    public ArrayList<String> generateIp(String s) {
        // code here
        if(s.length() == 0){
            return new ArrayList<>();
        }
        
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        
        solve(s,0,0,ans,str);
        
        return ans;
    }
}