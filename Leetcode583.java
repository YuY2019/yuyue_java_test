class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        if(l1==0 || l2==0) {
            return Math.max(l1,l2);
        }
        
        int[][] dp = new int[l1+1][l2+1];
        
        for(int i = 0;i<=l1;i++){
            dp[i][0]=0;
        }
        for (int j = 1; j<=l2; j++){
            dp[0][j] = 0;
        }
        
        for (int i = 1; i<=l1;i++){
            for (int j = 1; j<=l2; j++){
                //比较 word1[i] word2[j];
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int max = dp[l1][l2];
        return l1+l2-2*max; 
    }
}


public class Leetcode583 {
    
    public static void main(String[] args) {
        // Leetcode583 myTest = new Leetcode583();
        String word1 = "abcdaf";
        String word2 = "acaf";
        int ret = new Solution().minDistance(word1, word2);
        String out = String.valueOf(ret);
        System.out.print(out);
        
        
    }
    

}


