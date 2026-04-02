class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        Arrays.sort(arr1);
        String S1 = new String(arr1);

        int i = 0, j = 0;

        while(j < s2.length()) {
            if(j - i + 1 == S1.length()) {
                String str = s2.substring(i, j + 1);
                char[] arr2 = str.toCharArray();
                Arrays.sort(arr2);
                String S2 = new String(arr2);
                if(S1.equals(S2)) {
                    return true;
                }
                i++;
            }
            j++;
        }

        return false;
    }
}
