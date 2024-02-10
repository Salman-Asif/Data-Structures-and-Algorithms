class Solution {
    public int strStr(String haystack, String needle) {
        char[] hayStackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();

        for(int i=0;i< hayStackArray.length ; i++) {
            if(needleArray[0] == hayStackArray[i] && checkLength(i, hayStackArray.length, needleArray.length)) {
                if(checkNeedleExists(needleArray, hayStackArray, i)) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    private boolean checkLength(int i, int hayStackLength, int needleLength) {
        return (needleLength > hayStackLength - i) ? false : true;
    }

    private boolean checkNeedleExists(char[] needleArray, char[] hayStackArray, int i) {
        int j=0;
        while(j < needleArray.length && i < hayStackArray.length) {
            if(needleArray[j] != hayStackArray[i]) {
                return false;
            }
            j++;
            i++;
        }

        return true;
    }
}