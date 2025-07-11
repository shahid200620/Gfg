class Solution {
    public int countConsec(int n) {
        long totalBinaryStrings = (1L << n);

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 0;
        }

        long ends0 = 1;
        long ends1 = 1;

        for (int i = 2; i <= n; i++) {
            long nextEnds0 = ends0 + ends1;
            long nextEnds1 = ends0;
            ends0 = nextEnds0;
            ends1 = nextEnds1;
        }

        long stringsWithoutConsecutiveOnes = ends0 + ends1;

        return (int) (totalBinaryStrings - stringsWithoutConsecutiveOnes);
    }
}
