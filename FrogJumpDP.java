import java.util.Arrays;

public class FrogJumpDP {
    static int f(int n, int [] h, int [] dp) {
        if(dp[n] != -1) return dp[n];
        if(n==0) return 0;
        int l = f(n-1, h, dp) + Math.abs(h[n] - h[n-1]);
        int r = Integer.MAX_VALUE;
        if(n > 1)
            r = f(n-2, h, dp) + Math.abs(h[n] - h[n-2]);
        return dp[n] = Math.min(l,r);
    }

    static int frogJump(int n, int[] heights) {
        // Write your code here..
        int [] dp = new int[n];
        Arrays.fill(dp,-1);
        return f(n-1,heights,dp);
    }

    public static void main(String[] args) {
        int [] heights = new int [] {10,20,30,10};
        System.out.println("Answer - " + frogJump(4, heights));

        heights = new int [] {10, 50, 10};
        System.out.println("Answer - " + frogJump(3, heights));
    }
}
