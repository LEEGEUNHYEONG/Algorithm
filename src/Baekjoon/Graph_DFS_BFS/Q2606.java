package Baekjoon.Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by LGH on 2017-10-17.
 */
public class Q2606
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

        int numOfCom = Integer.parseInt (br.readLine ());

        if(numOfCom < 1 || numOfCom > 100)
        {
            System.out.println(0);
            return;
        }

        boolean[][] map = new boolean[numOfCom + 1][numOfCom + 1];

        int numOfPair = Integer.parseInt (br.readLine ());

        StringTokenizer st;

        for(int i = 0; i < numOfPair; i++)
        {
            st = new StringTokenizer (br.readLine ());

            int x = Integer.parseInt (st.nextToken ());
            int y = Integer.parseInt (st.nextToken ());
            map[x][y] = true;
            map[y][x] = true;
        }

        Queue<Integer> queue = new LinkedList<> ();

        for(int i = 1; i <= numOfCom; i++)
        {
            if(map[1][i] == true)
            {
                queue.add (i);
            }
        }

        ArrayList<Integer> visited = new ArrayList<> ();

        int result = 0;
        while(!queue.isEmpty ())
        {
            int num = queue.poll ();

            visited.add (num);
            result++;

            for(int i = 1; i <= numOfCom; i++)
            {
                if(map[num][i] == true && !queue.contains (i) && !visited.contains (i))
                {
                    map[num][i] = false;
                    queue.add (i);
                }
            }
        }
        System.out.println(result-1);
    }
}
