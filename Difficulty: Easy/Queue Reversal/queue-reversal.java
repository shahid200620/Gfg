class Solution {
    public void reverseQueue(Queue<Integer> q) {
        if (q.isEmpty()) return;
        
        Integer num = q.remove();
        reverseQueue(q);
        q.add(num);
    }
}