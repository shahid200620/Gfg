class Solution {
    boolean findvertical(char[][] mat, int i, int j, String word, int idx) {
        if(idx==word.length()) return true;
        if(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length)
            return false;
        if(word.charAt(idx)==mat[i][j]) {
            return findvertical(mat,i+1,j,word,idx+1);
        }
        return false;
    }
    boolean findHorizontal(char[][] mat, int i, int j, String word, int idx) {
        if(idx==word.length()) return true;
        if(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length)
            return false;
        if(word.charAt(idx)==mat[i][j]) {
            return findHorizontal(mat,i,j+1,word,idx+1);
        }
        return false;
    }
    boolean findLeft(char[][] mat, int i, int j, String word, int idx) {
        if(idx==word.length()) return true;
        if(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length)
            return false;
        if(word.charAt(idx)==mat[i][j]) {
            return findLeft(mat,i+1,j+1,word,idx+1);
        }
        return false;
    }
    boolean findRight(char[][] mat, int i, int j, String word, int idx) {
        if(idx==word.length()) return true;
        if(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length)
            return false;
        if(word.charAt(idx)==mat[i][j]) {
            return findRight(mat,i+1,j-1,word,idx+1);
        }
        return false;
    }
    boolean findLv(char[][] mat, int i, int j, String word, int idx) {
        if(idx==word.length()) return true;
        if(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length)
            return false;
        if(word.charAt(idx)==mat[i][j]) {
            return findLv(mat,i-1,j,word,idx+1);
        }
        return false;
    }
    boolean findLh(char[][] mat, int i, int j, String word, int idx) {
        if(idx==word.length()) return true;
        if(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length)
            return false;
        if(word.charAt(idx)==mat[i][j]) {
            return findLh(mat,i,j-1,word,idx+1);
        }
        return false;
    }
    boolean findLd(char[][] mat, int i, int j, String word, int idx) {
        if(idx==word.length()) return true;
        if(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length)
            return false;
        if(word.charAt(idx)==mat[i][j]) {
            return findLd(mat,i-1,j-1,word,idx+1);
        }
        return false;
    }
    boolean findRd(char[][] mat, int i, int j, String word, int idx) {
        if(idx==word.length()) return true;
        if(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length)
            return false;
        if(word.charAt(idx)==mat[i][j]) {
            return findRd(mat,i-1,j+1,word,idx+1);
        }
        return false;
    }
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        int n = mat.length, m = mat[0].length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(mat[i][j]==word.charAt(0)) {
                    boolean a = findvertical(mat,i,j,word,0);
                    boolean e = findLv(mat,i,j,word,0);
                    boolean b = findHorizontal(mat,i,j,word,0);
                    boolean f = findLh(mat,i,j,word,0);
                    boolean c = findLeft(mat,i,j,word,0);
                    boolean g = findLd(mat,i,j,word,0);
                    boolean d = findRight(mat,i,j,word,0);
                    boolean h = findRd(mat,i,j,word,0);
                    if((((((((a||b)||c)||d)||e)||f)||g)||h)) {
                        ArrayList<Integer> ans = new ArrayList<>();
                        ans.add(i);
                        ans.add(j);
                        res.add(ans);
                    }
                }
            }
        }
        return res;
    }
};

