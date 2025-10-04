class Solution {
    public void solve(String s, int target, int idx, long currVal, long prevOpr, String expression, ArrayList<String> result) {
        if (idx == s.length()) {
            if (currVal == target) {
                result.add(expression);
            }
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (i > idx && s.charAt(idx) == '0') {
                break;
            }

            long currNum = Long.parseLong(s.substring(idx, i + 1));

            if (idx == 0) {
                solve(s, target, i + 1, currNum, currNum, expression + currNum, result);
            } else {
                solve(s, target, i + 1, currVal + currNum, currNum, expression + "+" + currNum, result);

                solve(s, target, i + 1, currVal - currNum, -currNum, expression + "-" + currNum, result);

                long newVal = currVal - prevOpr + (prevOpr * currNum);
                solve(s, target, i + 1, newVal, prevOpr * currNum, expression + "*" + currNum, result);
            }
        }
    }

    public ArrayList<String> findExpr(String s, int target) {
        ArrayList<String> result = new ArrayList<>();
        solve(s, target, 0, 0, 0, "", result);
        return result;
    }
}