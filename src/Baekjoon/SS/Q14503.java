package Baekjoon.SS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by LGH on 2017-10-20.
 */
public class Q14503
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

        StringTokenizer st = new StringTokenizer (br.readLine ());

        int n = Integer.parseInt (st.nextToken ());
        int m = Integer.parseInt (st.nextToken ());

        st = new StringTokenizer (br.readLine ());

        int rx = Integer.parseInt (st.nextToken ());
        int ry = Integer.parseInt (st.nextToken ());
        int direction = Integer.parseInt (st.nextToken ());


        int[][] map = new int[n+1][m+1];

        for(int i = 1; i <= n; i++)
        {
            st = new StringTokenizer (br.readLine ());
            for(int j = 1; j <=m; j++)
            {
                map[i][j] = Integer.parseInt (st.nextToken ());
            }
        }


        for(int i = 1; i <= n; i++)
        {

            for(int j = 1; j <= m; j++)
            {
                System.out.printf(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
