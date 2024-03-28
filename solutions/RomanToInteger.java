/*
 * tags: math, impl
 * statement: https://leetcode.com/problems/roman-to-integer/description/
 */


class RomanToInteger {
    public int romanToInt(String s) {
        int ans = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            char next = (i < s.length()-1)? s.charAt(i+1): '0';
            switch(c) {
                case 'I':
                    if (next == 'V' || next == 'X')
                        ans += -1;
                    else
                        ans += 1;
                    break;
                case 'V':
                    ans += 5;
                    break;
                case 'X':
                    if (next == 'L' || next == 'C')
                        ans += -10;
                    else
                        ans += 10;
                    break;
                case 'L':
                    ans += 50;
                    break;
                case 'C':
                    if (next == 'D' || next == 'M')
                        ans += -100;
                    else
                        ans += 100;
                    break;
                case 'D':
                    ans += 500;
                    break;
                case 'M':
                    ans += 1000;
                    break;
            }
        }
        return ans;
    }
}
