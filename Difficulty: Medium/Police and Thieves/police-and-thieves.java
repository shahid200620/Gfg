class Solution {
    public int catchThieves(char[] arr, int k) {
        int l=arr.length;
        int i=0,j=0,nt=0;
        List<Integer> pl=new ArrayList<>();
        List<Integer> tl=new ArrayList<>();
        
        for(int indx=0;indx<l;indx++){
            if(arr[indx]=='P') pl.add(indx);
            if(arr[indx]=='T') tl.add(indx);
        }
        while(i<pl.size() && j<tl.size()){
            if(Math.abs(pl.get(i)-tl.get(j))<=k){
                nt++;
                i++;j++;
            }else if(pl.get(i)<tl.get(j)){
                i++;
            }else{
                j++;
            }
        }
        return nt;
    }
}