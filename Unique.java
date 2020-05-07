import java.util.* ;

class Unique {

	/* this is main() */

	public static void main(String [] args){

		String givenString = "aabbcpa" ;

	       	int len = getNumberOfUniqueChars(givenString) ;

		System.out.println("Total unique chars in [" + givenString + "] = " + len) ;
	}


	/* this is our problem statement */

	//Time O(n) and Space O(1) 

	static int getNumberOfUniqueChars(String s) {

		if(s == null || s.length() == 0) { //s = "aabbcpa"
			return 0 ;
		}

		Set<Character> set= new HashSet<>() ;
		char[] chars = s.toCharArray() ;
		for(char c : chars) {
			if(c >= 'a' && c <= 'z') { //a
				set.add(c) ; // a, b, c, p 
			}
		}

		return set.size() ; //4

		//TODO : return Map<Character, Inetger> map 

	}
}

