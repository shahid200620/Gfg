class Solution {
    List<Integer> makeBeautiful(int[] arr) {
       Stack<Integer> st=new Stack<>();
       for(int i:arr){
           if(!st.isEmpty() && (st.peek()>=0 && i<0 || st.peek()<0 && i>=0) ){
               st.pop();
           }else{
               st.push(i);
           }
       }
       List<Integer> ans = new ArrayList<>(st);

        return ans;
    }
}
 