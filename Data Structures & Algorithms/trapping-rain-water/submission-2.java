class Solution {
    public int trap(int[] height) {
        /*
            [0, 2, 0, 3, 1, 0, 1, 3, 2, 1]

            l = [0, 2, 2, 3, 3, 3, 3, 3, 3, 3]
            r = [3, 3 ,3 ,3, 3, 3, 3, 3, 2, 1]
            
            res = (0 - 0) + (2 - 2) + (2 - 0) + (3 - 3) + (3 - 1) + 
                  (3 - 0) + (3 - 1) + (3 - 3) + (2 - 2) + (1 - 1)

        */

        int n = height.length;

        int[] left = new int[n];
        left[0] = height[0];
        int maxLeft = left[0];
        for(int i = 1; i < n; i++) {
            maxLeft = Math.max(maxLeft, height[i]);
            left[i] = maxLeft;
        }

        int[] right = new int[n];
        right[n - 1] = height[n - 1];
        int maxRight = right[n - 1];
        for(int i = n - 1; i >= 0; i--) {
            maxRight = Math.max(maxRight, height[i]);
            right[i] = maxRight;
        }

        int res = 0;
        for(int i = 0; i < n; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }

        return res;
    }
}
