package Baekjoon;

import java.util.Scanner;

/**
 * Created by LGH on 2017-09-28.
 */
public class Q10844
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner (System.in);

        int mod = 1000000000;
        int num = scanner.nextInt ();

        int[][] dp = new int[101][10];

        int sum = 0;

        for(int i = 0; i < 10; i++)
        {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= num; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                if (j == 0)
                {
                    dp[i][j] = dp[i -1][j+1] % mod;
                }
                else if(j == 9)
                {
                    dp[i][j] = dp[i -1][j-1] % mod;
                }
                else
                {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
                }
            }
        }

        for(int i = 1; i < 10; i++)
        {
            sum = (sum + dp[num][i]) % mod;
        }

        System.out.println(sum % mod);

    }
}
