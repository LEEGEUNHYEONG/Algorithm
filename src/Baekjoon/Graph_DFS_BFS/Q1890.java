package Baekjoon.Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by LGH on 2017-10-17.
 */
public class Q1890
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        StringTokenizer st;

        int size = Integer.parseInt (br.readLine ());

        if(size < 4 || size > 100)
        {
            System.out.println(0);
            return;
        }


        int[][] map = new int[size+1][size+1];
        long[][] path = new long[size+1][size+1];

        for(int i = 1; i <= size; i++)
        {
            st = new StringTokenizer (br.readLine ());

            for(int j = 1; j <= size; j++)
            {
                map[i][j] = Integer.parseInt (st.nextToken ());
            }
        }

        search(map, path, size);

    }

    private static void search(int[][] map, long[][] dp, int size)
    {
        dp[1][1] = 1;

        for(int i = 1; i <= size; i++)
        {
            for(int j = 1; j <= size; j++)
            {
                int d = map[i][j];

                if(dp[i][j] == 0 || d == 0)
                {
                    continue;
                }

                int down = i + d;
                int right = j + d;

                if(down <= size)
                {
                    dp[down][j] += dp[i][j];
                }

                if(right <= size)
                {
                    dp[i][right] += dp[i][j];
                }


            }
        }
        System.out.println(dp[size][size]);
    }
}
