package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import Baekjoon.Baekjoon;

/**
 * Created by LGH on 2017-10-13.
 */
public class Q1912
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

        int count = Integer.parseInt (br.readLine ());

        int[] nums = new int[count+1];
        int[] dp = new int[count+1];

        StringTokenizer st = new StringTokenizer (br.readLine ());

        for(int i = 1; i <= count; i++ )
        {
            nums[i] = Integer.parseInt (st.nextToken ());
        }

        dp[1] = nums[1];
        int max = dp[1];

        for(int i = 2; i <= count; i++)
        {
            dp[i] = Math.max (nums[i], dp[i-1] + nums[i]);

            if(dp[i] > max)
            {
                max = dp[i];
            }
        }

        System.out.println(max);

    }
}
