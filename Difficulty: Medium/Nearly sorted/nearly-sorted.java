class Solution {
    public void nearlySorted(int[] arr, int k) {
         PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap
        
        for(int i=0; i<=k; i++){
            pq.offer(arr[i]);
        }
        
        int index = 0; 
        for(int i=k+1; i<arr.length; i++){
            arr[index++] = pq.poll(); 
            pq.add(arr[i]); 
            
        }
        
        while(!pq.isEmpty()){
            arr[index++] = pq.poll();
        }
    
    }
}

