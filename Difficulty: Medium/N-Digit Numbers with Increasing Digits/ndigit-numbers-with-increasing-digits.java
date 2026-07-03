class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        // code here
        if(n > 9) return new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(n == 9){
            list.add(123456789);
            return list;
        }
        if(n == 1) list.add(0);
        for(int i=1;i<512;i++){
            if(Integer.bitCount(i) == n){
                int number = 0;
                for(int j=8;j>=0;j--){
                    if((i & (1 << j)) > 0){
                        number = number * 10 + (9-j);
                    }
                }
                list.add(number);
            }
        }
        Collections.sort(list);
        return list;
    }
}