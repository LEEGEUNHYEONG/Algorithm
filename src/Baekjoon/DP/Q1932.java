package Baekjoon.DP;

import java.util.Scanner;

import Baekjoon.Baekjoon;

public class Q1932
{
    private static int[][] dp;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        dp = new int[count][count];

        for(int i = 0; i < count; i++)
        {
            for(int j = 0; j < i+1; j++)
            {
                int num = scanner.nextInt();

                if(i == 0)
                {
                    dp[i][j] = num;
                }
                else
                {
                    if(j == 0)
                    {
                        dp[i][j] = dp[i-1][j]+ num;
                    }
                    else if(j == i)
                    {
                        dp[i][j] = dp[i-1][j-1]+ num;
                    }
                    else
                    {
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1])+ num;
                    }
                }
            }
        }

        int max = 0;

        for(int i = 0; i < count; i++)
        {
            if(dp[count-1][i] > max)
            {
                max = dp[count-1][i];
            }
        }

        System.out.println(max);

    }
}
