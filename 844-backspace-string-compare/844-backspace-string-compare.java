class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder a= new StringBuilder();
        StringBuilder b = new StringBuilder();
        
        for(char ch:s.toCharArray()) {
            if(ch=='#' ) {
                if(a.length()!=0) {
                    a.deleteCharAt(a.length()-1);
                }
            }
            else
                a.append(ch);
        }
        
        for(char ch:t.toCharArray()) {
            if(ch=='#' ) {
                if(b.length()!=0) {
                    b.deleteCharAt(b.length()-1);
                }
            }
            else
                b.append(ch);
        }
        
        if(a.length() != b.length()) return false;
        
        for(int i=0;i<a.length();i++) {
            if(a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    } 
}