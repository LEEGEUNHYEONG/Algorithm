package Baekjoon.DP;

import java.util.Scanner;

import Baekjoon.Baekjoon;

/**
 * Created by LGH on 2017-09-28.
 */
public class Q2579
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt ();

        if(count > 300)
        {
            return;
        }


        int[] dp = new int[count];
        int[] stair = new int[count];

        for(int i = 0; i < count; i++)
        {
            stair[i] = scanner.nextInt ();

            if(i == 0)
            {
                dp[0] = stair[0];
            }
            else if(i == 1)
            {
                dp[1] = Math.max (stair[0] + stair[1], stair[1]);
            }
            else if(i == 2)
            {
                dp[2] = Math.max (stair[0] + stair[2], stair[1] + stair[2]);
            }
            else
            {
                dp[i] = Math.max (dp[i-2] + stair[i], stair[i-1] + stair[i] + dp[i-3]);
            }
        }

        System.out.println(dp[count-1]);
    }
}
