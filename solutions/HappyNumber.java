/**
 * tags: math
 * statement: https://leetcode.com/problems/happy-number/description/
 */


class HappyNumber {
    public boolean isHappy(int n) {
        if (n == 1) return true;
        Set<Integer> nums = new HashSet<>();
        nums.add(n);
        int x = n;
        while (true) {
            char[] digits = String.valueOf(x).toCharArray();
            int sumOfDigitSquars = 0;
            for (char c: digits) {
                int d = c - '0';
                sumOfDigitSquars += d*d;
            }
            if (sumOfDigitSquars == 1) return true;
            if (nums.contains(sumOfDigitSquars)) break;
            nums.add(sumOfDigitSquars);
            x = sumOfDigitSquars;
        }
        return false;
    }
}
