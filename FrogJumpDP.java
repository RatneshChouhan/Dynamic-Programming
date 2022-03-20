public class FrogJumpDP {
    /* DP Solution Time Complexity - O(N) , Space Complexity - O(N) -> due to recursion stack
    static int f(int n, int [] h, int [] dp) {
        if(dp[n] != -1) return dp[n];
        if(n==0) return 0;
        int l = f(n-1, h, dp) + Math.abs(h[n] - h[n-1]);
        int r = Integer.MAX_VALUE;
        if(n > 1)
            r = f(n-2, h, dp) + Math.abs(h[n] - h[n-2]);
        return dp[n] = Math.min(l,r);
    }
    */

    /*  Tabulation Solution Time Complexity - O(N) , Space Complexity - O(N) -> No Recursion But Extra dp array
    static int frogJump(int n, int[] heights) {
        // Write your code here..
         int [] dp = new int[n];
         Arrays.fill(dp,-1) ;  // for(int i = 0; i < n; i++) dp[i] = -1;
        dp[0] = 0;
        int r = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            int l = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
            if(i > 1)
                r = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
            dp[i] = Math.min(l, r);
        }
        return dp[n-1] ;
    }
    */

    /* Space Optimized Method Time Complexity - O(N) , Space Complexity - O(1) -> No Recursion, No Extra Array */
    static int frogJump(int n, int[] heights) {
        int prev = 0;
        int prev2 = 0;
        int r = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            int l = prev + Math.abs(heights[i] - heights[i-1]);
            if(i > 1)
                r = prev2 + Math.abs(heights[i] - heights[i-2]);
            int curr = Math.min(l, r);
            prev2 = prev;
            prev = curr;

        }
        return prev ;
    }


    public static void main(String[] args) {
        int [] heights = new int [] {10,20,30,10};
        System.out.println("Answer - " + frogJump(4, heights));

        heights = new int [] {10, 50, 10};
        System.out.println("Answer - " + frogJump(3, heights));
    }
}
