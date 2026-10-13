class Solution {
    public ArrayList<Integer> update(int n, int[] updates) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            result.add(0);
        }
        for(int update : updates){
            result.set(update-1 , result.get(update-1)+1);
        }
        int cumSum = 0;
        for(int i = 0 ; i < n ; i++){
            cumSum += result.get(i);
            result.set(i , cumSum);
        }
        return result;
    }
}