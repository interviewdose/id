class Solution {
    
    Map<String, Integer> cache = new HashMap<>(); 
    
    // int[][][] cache = new int[5000][6][16];
    
    public int dieSimulator(int n, int[] rollMax) {
        
        // Helper -> Recursive calls / Backtrack for all possibilities
        return tryPermutations(n, -1, 0, rollMax);
        
    }
    
    private int tryPermutations(int dieRollsLeft, int lastNumberRolled, int curlen, int[] rollMax){
        
        String key = dieRollsLeft + "_" + lastNumberRolled + "_" + curlen ; 
        
        Integer result = cache.get(key) ;
        if(result != null) {
            return result ;
        }
        
        //base case when zero
        if(dieRollsLeft == 0) {
            return 1;
        }
        
        result = 0 ;
        
        for(int i = 0; i < 6; i++) { //try for all 6 rolls
            
            //Constraint - It cannot roll the number i more than rollMax[i]
            if(i == lastNumberRolled && curlen == rollMax[i]) continue;
            
            int tempCurlen = (i == lastNumberRolled) ? curlen + 1 : 1 ; // else 1 for resetting to 1
            
            //Call the recursive method for next roll 
            //Accumulate result add One for each recursive call
            
            result += tryPermutations(dieRollsLeft - 1, i, tempCurlen, rollMax);
            result %= 1000000007 ;
        }
        
        cache.put(key, result) ;
        
        return result ;
    }
}
