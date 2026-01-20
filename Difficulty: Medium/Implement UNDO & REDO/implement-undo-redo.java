class Solution {
    StringBuilder buffer = new StringBuilder();
    int currentLength = 0;   // visible length of document
    int maxLength = 0;       // furthest point reached (for redo history)
    // Append a character
    public void append(char x) {
        if (currentLength < buffer.length()) {
            // overwrite if we had undone before
            buffer.setCharAt(currentLength, x);
        } else {
            buffer.append(x);
        }
        currentLength++;
        maxLength = currentLength; // new timeline, redo beyond this is invalid
    }
    // Undo last append
    public void undo() {
        if (currentLength > 0) {
            currentLength--; // just move pointer back
        }
    }
    // Redo last undone append
    public void redo() {
        if (currentLength < maxLength) {
            currentLength++; // move pointer forward again
        }
    }
    // Read current document
    public String read() {
        return buffer.substring(0, currentLength);
    }
}