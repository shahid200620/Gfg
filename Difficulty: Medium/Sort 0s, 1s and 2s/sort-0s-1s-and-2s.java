class Solution {
    public void sort012(int[] arr) {
        int firstOneIndex = -1; // Tracks the first position of 1
        int firstTwoIndex = -1; // Tracks the first position of 2

        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 0:
                    if (firstOneIndex >= 0) {
                        arr[firstOneIndex++] = 0; // Move 1 to current position
                        if (firstTwoIndex >= 0) {
                            arr[firstTwoIndex++] = 1; // Move 2 to the next position
                            arr[i] = 2; // Replace current position with 2
                        } else {
                            arr[i] = 1; // Replace current position with 1
                        }
                    } else if (firstTwoIndex >= 0) {
                        arr[firstTwoIndex++] = 0; // Move 2 to current position
                        arr[i] = 2; // Replace current position with 2
                    }
                    break;
                case 1:
                    if (firstTwoIndex >= 0) {
                        if (firstOneIndex == -1) {
                            firstOneIndex = firstTwoIndex; // Update firstOneIndex
                        }
                        arr[firstTwoIndex++] = 1; // Move 2 to current position
                        arr[i] = 2; // Replace current position with 2
                    } else {
                        if (firstOneIndex == -1) {
                            firstOneIndex = i; // Update firstOneIndex
                        }
                    }
                    break;
                case 2:
                    if (firstTwoIndex == -1) {
                        firstTwoIndex = i; // Update firstTwoIndex
                    }
            }
        }
    }
}