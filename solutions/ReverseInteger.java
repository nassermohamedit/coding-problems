/**
 * tags: math
 * statement: https://leetcode.com/problems/reverse-integer/description/
 */


class ReverseInteger {
    public int reverse(int x) {
        int signe = (x >= 0)? 1: -1;
        x = x*signe;
        String max_value = String.valueOf(Integer.MAX_VALUE);
        String rev = new StringBuilder(String.valueOf(x)).reverse().toString();
        if (max_value.length() > rev.length()) return signe*Integer.parseInt(rev);
        if (rev.compareTo(max_value) > 0) return 0;
        return signe*Integer.parseInt(rev);
    }
}
