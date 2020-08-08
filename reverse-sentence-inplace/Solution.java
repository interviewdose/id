/*

class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        
        StringBuilder ans = new StringBuilder();
        
        for (int i=s.length()-1, j; i>=0; i--) {
            if (s.charAt(i) != ' ') {
                j = i; // j is pointing to the end char of the current word
                i = s.lastIndexOf(' ', i); // this returns the white space preceding the current word
                ans.append(s, i+1, j+1).append(" ");
            }
        }
        
        return ans.toString().trim();
    }
    
} */


class Solution {
    
    void reverse(char[] str, int i , int j) {
        
        for(; i < j ; i ++, j--) {
            char c = str[i] ;
            str[i] = str[j] ;
            str[j] = c ;
        }
    }
    
    boolean isValid(char[] str, int i, int j, int end) {
        
        return i < str.length && j <= end ? true : false ;
    }
    
    public String reverseWords(String s) {
        
        char[] str = s.toCharArray() ;
        
        int start = 0 ;
        int end = str.length - 1;
        
        while(start <= end && str[start] == ' ') {
            start++ ;
        }
        
        while(start <= end && str[end] == ' ') {
            end-- ;
        }
        
        reverse(str, start, end) ;
        
        int i = start ;
        int j = start ;
        int mark = start ;
        while(isValid(str, i , j, end)) {

            if(str[j] != ' ') {
                str[mark++] = str[j] ;
            }

            if(j == end || str[j] == ' ') {

                reverse(str, i, mark - 1) ;

                if(j == end) {
                    break ;
                }

                str[mark++] = ' ' ;
                i = mark ;

                while(str[++j] == ' ') { //skip all space in between
                }
                j-- ;
            }

            j++ ;
        }        
        return new String(str, start, mark - start) ;
    }
}
