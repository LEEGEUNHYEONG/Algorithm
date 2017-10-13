package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import Baekjoon.Baekjoon;

/**
 * Created by LGH on 2017-10-12.
 */
public class Q1520
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer (br.readLine ());

        int height = Integer.parseInt (st.nextToken ());
        int width = Integer.parseInt (st.nextToken ());

        if(height > 500 || width > 500)
        {
            System.out.println(0);
            return;
        }

        int[][] map = new int[height + 1][width + 1];
        int[][] dp = new int[height + 1][width + 1];

        for(int i = 1; i <= height; i++)
        {
            st = new StringTokenizer (br.readLine ());

            for(int j = 1; j <= width; j++)
            {
                map[i][j] = Integer.parseInt (st.nextToken ());
                dp[i][j] = -1;
            }
        }

        //System.out.println(dp[1][1]); //  시간 초과 ???
        System.out.println(check(map, dp, height, width, 1, 1));
    }

    private static int check(int[][] map, int[][] dp, int height, int width, int y, int x)
    {

        if(y == height && x == width)
        {
            return 1;
        }

        if(dp[y][x] != -1)
        {
            return dp[y][x];
        }
        else
        {
            dp[y][x] = 0;

            if((x +1 <= width) && (map[y][x] > map[y][x+1]))
            {
                dp[y][x] += check(map, dp, height, width, y, x + 1);
            }

            if((x - 1 > 0) && (map[y][x] > map[y][x-1]))
            {
                dp[y][x] += check (map, dp, height, width, y, x - 1);
            }

            if((y+1 <= height) && (map[y][x] > map[y+1][x]))
            {
                dp[y][x] += check(map, dp, height, width, y+1, x);
            }

            if((y -1 > 0) && (map[y][x] > map[y-1][x]) )
            {
                dp[y][x] += check(map, dp, height, width, y-1, x);
            }
        }
        return dp[y][x];
    }
}
