/*
 * tags: math
 * statement: https://leetcode.com/problems/plus-one/description/
 */

class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i=digits.length-1; i>=0; i--) {
            if (digits[i] + 1 < 10) {
                digits[i] += 1;
                break;
            }
            digits[i] = 0;
        }
        if (digits[0] == 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }
}
