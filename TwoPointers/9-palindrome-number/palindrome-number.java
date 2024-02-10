class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        char[] convertedNumber = String.valueOf(x).toCharArray();

        return checkPalindrome(convertedNumber);
    }

    private boolean checkPalindrome(char[] convertedNumber) {
        for(int i=0; i< convertedNumber.length ; i++) {
            if(convertedNumber[i] != convertedNumber[convertedNumber.length-1-i])
                return false;
        }
        return true;
    }
}