class Fibonacci {
	public static void main(String [] args){
		for(int i = 0 ; i < 50 ; i++) {
			System.out.println("Fib :" + i + " = " + fib(i) ) ;
		}
	}


	//fib(n) = fib(n-1) + fib(n-2)

	static long fib(int n) {
		if(n < 2) {
			return n ;
		}

		long first = 0 ;
		long second = 1 ;
		long result = 0 ;

		for(int i = 2 ; i <= n ; i++) { // i = 3
			result = first + second ; // 2
			first = second ; //1
			second = result ; //2
		}

		return result ;
	}
}

