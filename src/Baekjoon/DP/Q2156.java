package Baekjoon.DP;

import java.util.Scanner;

import Baekjoon.Baekjoon;

public class Q2156
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int[] wine = new int[10001];
        int[] dp = new int[10001];


        for(int i = 1; i <= count; i++)
        {
            wine[i] = scanner.nextInt();
        }

        if(count == 1)
        {
            System.out.println(wine[1]);
            return;
        }

        else if(count == 2)
        {
            System.out.println(wine[1] + wine[2]);
            return;
        }

        dp[0] = 0;
        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];

        for(int i = 3; i <= count; i++)
        {
            dp[i] = Math.max(dp[i-3] + wine[i-1] + wine[i], Math.max(dp[i-1], dp[i-2] + wine[i]));
        }

        System.out.println(dp[count]);
    }
}
