class Solution {
    int minSubsets(int arr[]) {
        Set<Integer> set=new HashSet<>();
        for(int i:arr) set.add(i);
        int count=0;
        for(int i:arr){
            if(set.contains(i-1)) continue;
            count++;
        }
        return count;
    }
} 