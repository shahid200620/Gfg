class Solution {

    public int median(int[][] mat) {
        ArrayList<Integer> al = new ArrayList<>();

        for(int i=0; i<mat.length; i++){

            for(int j=0; j<mat[i].length; j++){

                al.add(mat[i][j]);

            }

        }

        Collections.sort(al);

        return al.get(al.size()/2);

    }

}

