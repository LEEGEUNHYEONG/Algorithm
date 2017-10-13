package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Baekjoon.Baekjoon;

/**
 * Created by LGH on 2017-10-13.
 */
public class Q9461
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

        int testCase = Integer.parseInt (br.readLine ());

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for(int i = 6; i <= 100; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        for(int t = 0; t < testCase; t++)
        {
            int n = Integer.parseInt (br.readLine ());
            System.out.println(dp[n]);
        }
    }
}
