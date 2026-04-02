class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        /*
            [1, 2, 4, 5]
            [1, 5] <= 5
            [2, 4] <= 6

            [1, 2, 2, 3, 3] 
            [1, 2] <= 3
            [2] <= 3
            [3] <= 3
            [3] <= 3 

            [1, 2, 4, 5]

        */

        int l = 0, r = people.length - 1;
        int count = 0;
        while(l <= r) {
            int sum = people[l] + people[r];
            if(sum <= limit) {
                count++;
                l++;
                r--;
            } else if(people[r] <= limit) {
                count++;
                r--;
            } else {
                l++;
            }
        }

        return count;
    }
}