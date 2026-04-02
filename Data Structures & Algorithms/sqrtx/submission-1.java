class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int i = 1, j = x / 2;
        int ans = 0;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if ((long) mid * mid == x) {
                return mid;
            } 
            else if ((long) mid * mid > x) {
                j = mid - 1;
            } 
            else {
                ans = mid;
                i = mid + 1;
            }
        }

        return ans;
    }
}
