class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        String convertedNumber = String.valueOf(x);

        return checkPalindrome(convertedNumber);
    }

    private boolean checkPalindrome(String convertedNumber) {
        for(int i=0; i< convertedNumber.length() ; i++) {
            if(convertedNumber.charAt(i) != convertedNumber.charAt(convertedNumber.length() -1-i))
                return false;
        }
        return true;
    }
}