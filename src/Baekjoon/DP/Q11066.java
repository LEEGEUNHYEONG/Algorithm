package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import Baekjoon.Baekjoon;

/**
 * Created by LGH on 2017-10-10.
 */
public class Q11066
{
    static final int MaxSize = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

        int numCount;
        int[] nums;
        int[] sums;
        int[][] dp;

        int testCase = Integer.parseInt (br.readLine ());

        for(int t = 0; t < testCase; t++)
        {
            numCount = Integer.parseInt (br.readLine ());
            nums = new int[numCount + 1];
            sums = new int[numCount + 1];
            dp = new int[numCount + 1][numCount + 1];

            sums[0] = 0;

            StringTokenizer st = new StringTokenizer (br.readLine ());
            for(int i = 1; i < numCount + 1; i++)
            {
                nums[i] = Integer.parseInt (st.nextToken ());
                sums[i] = sums[i-1] + nums[i];

                for(int j = 1; j < numCount +1 ; j++)
                {
                    dp[i][j] = MaxSize;
                }
            }

            System.out.println(search (dp, nums, sums, 1, numCount));
        }
    }

    private static int search(int[][]dp, int[] nums, int[] sums, int start, int end)
    {
        if(start >= end)
        {
            return 0;
        }

        if(start + 1 == end)
        {
            return nums[start] + nums[end];
        }

        if(dp[start][end] < MaxSize)
        {
            return dp[start][end];
        }

        for(int i = start; i < end; i++)
        {
            int temp = search(dp, nums, sums, start, i) + search(dp, nums, sums, i+1, end) + sums[end] - sums[start-1];
            dp[start][end] = Math.min (dp[start][end], temp );
        }
        return dp[start][end];
    }
}
