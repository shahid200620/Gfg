class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        
        int sum = n;
        
        generateCombinations(0,sum,1,k,list,ansList);
        
        return ansList;
    }
    
    private void generateCombinations(int i, int sum, int j, int k,
    ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ansList){
         
        if(j == k+1 && sum == 0) {
            ansList.add(new ArrayList<>(list));
            return;
        }
        
        if(sum < 0 ||  j > k) return;
        
        for(int l = i + 1;l<=9;l++){
            list.add(l);
            generateCombinations(l,sum-l,j+1,k,list,ansList);
            list.remove(list.size() - 1);
        }
    }
}

