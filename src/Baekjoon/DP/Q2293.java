package Baekjoon.DP;

import java.util.Scanner;

import Baekjoon.Baekjoon;

/**
 * Created by LGH on 2017-09-28.
 */
public class Q2293
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner (System.in);

        int n = scanner.nextInt ();
        int k = scanner.nextInt ();

        int[] coin = new int[n+1];
        int[] dp = new int[k+1];

        for(int i = 1; i <= n; i++)
        {
            coin[i] = scanner.nextInt ();
        }

        dp[0] = 1;

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= k; j++)
            {
                if(j >= coin[i])
                {
                    dp[j] += dp[j-coin[i]];
                }
            }
        }

        System.out.println(dp[k]);

    }
}
