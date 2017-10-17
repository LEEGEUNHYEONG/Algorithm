package Baekjoon.Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by LGH on 2017-10-17.
 */
public class Q10216
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        StringTokenizer st;

        int tc = Integer.parseInt (br.readLine ());

        for(int t = 0; t < tc; t++)
        {
            int N = Integer.parseInt (br.readLine ());  //  적군 진영의 숫자

            int[][] camp = new int[N][3];
            int[] parent = new int[N];

            for(int n = 0; n < N; n++)
            {
                st = new StringTokenizer (br.readLine ());

                for(int i = 0; i < 3; i++)
                {
                    int num = Integer.parseInt (st.nextToken ());
                    camp[n][i] = num;
                    parent[n] = n;
                }
            }

            int cnt = N;

            for(int i = 0; i < N; i++)
            {
                for(int j = i+1; j < N; j++)
                {
                    int x = camp[i][0] - camp[j][0];
                    int y = camp[i][1] - camp[j][1];
                    int r = camp[i][2] + camp[j][2];
                    int d = (x * x) + (y * y);

                    if(d <= r * r)
                    {
                        if(find(parent, i) != find(parent, j))
                        {
                            parent = merge(parent, i, j);
                            cnt--;
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static int find(int[] parent, int x)
    {
        if(x == parent[x])
        {
            return x;
        }
        else
        {
            return parent[x] = find(parent, parent[x]);
        }
    }

    private static int[] merge(int[] parent, int x, int y)
    {
        x = find(parent, x);
        y = find (parent, y);

        if(x!= y)
        {
            parent[x] = y;
        }
        return parent;
    }
}
