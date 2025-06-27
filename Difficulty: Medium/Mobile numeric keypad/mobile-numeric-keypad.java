class Solution {
    public long getCount(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 10;
        }

        long[][] dp = new long[n + 1][10];

        for (int j = 0; j < 10; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) { 
                List<Integer> neighbors = getNeighbors(j);
                for (int neighbor : neighbors) {
                    dp[i][j] += dp[i-1][neighbor];
                }
            }
        }

        long totalCount = 0;
        for (int j = 0; j < 10; j++) {
            totalCount += dp[n][j];
        }

        return totalCount;
    }

    private List<Integer> getNeighbors(int digit) {
        List<Integer> neighbors = new ArrayList<>();
        neighbors.add(digit);

        switch (digit) {
            case 0:
                neighbors.add(8);
                break;
            case 1:
                neighbors.add(2);
                neighbors.add(4);
                break;
            case 2:
                neighbors.add(1);
                neighbors.add(3);
                neighbors.add(5);
                break;
            case 3:
                neighbors.add(2);
                neighbors.add(6);
                break;
            case 4:
                neighbors.add(1);
                neighbors.add(5);
                neighbors.add(7);
                break;
            case 5:
                neighbors.add(2);
                neighbors.add(4);
                neighbors.add(6);
                neighbors.add(8);
                break;
            case 6:
                neighbors.add(3);
                neighbors.add(5);
                neighbors.add(9);
                break;
            case 7:
                neighbors.add(4);
                neighbors.add(8);
                break;
            case 8:
                neighbors.add(0);
                neighbors.add(5);
                neighbors.add(7);
                neighbors.add(9);
                break;
            case 9:
                neighbors.add(6);
                neighbors.add(8);
                break;
        }
        return neighbors;
    }
}