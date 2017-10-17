package Baekjoon.Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by LGH on 2017-10-17.
 */
public class Q2667
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

        int size = Integer.parseInt (br.readLine ());

        if(size < 5 || size > 25)
        {
            System.out.println(0);
            return;
        }

        int[][] map = new int[size + 1][size + 1];

        for(int i = 1; i <= size; i++)
        {
            String line = br.readLine ();
            for(int j = 1; j <= size; j++)
            {
                map[i][j] = Character.getNumericValue (line.charAt (j - 1));
            }
        }

        for(int i = 1; i <= size; i++)
        {
            for(int j = 1; j <= size; j++)
            {
                if(map[i][j] == 1)
                {
                    search (map, size, i, j);
                }
            }
        }


        Collections.sort (visited);

        System.out.println(visited.size ());

        for(int i = 0; i < visited.size (); i++)
        {
            System.out.println(visited.get (i));
        }
    }

    private static ArrayList<Integer> visited = new ArrayList<> ();

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};


    private static void search(int[][] map, int size, int x, int y )
    {
        Queue<Position> queue = new LinkedList<>();
        queue.add (new Position (x, y));

        int count = 0;

        Position p;

        while(!queue.isEmpty ())
        {
            p = queue.poll ();
            map[p.x][p.y] = 0;
            count++;

            for(int i = 0; i < 4; i++)
            {
                int nX = p.x + dx[i];
                int nY = p.y + dy[i];

                if(nX > 0 && nX <= size && nY > 0 && nY <= size && map[nX][nY] == 1)
                {
                    queue.add (new Position(nX, nY));
                    map[nX][nY] = 0;
                }
            }
        }

        visited.add (count);
    }

    private static class Position
    {
        int x;
        int y;

        public Position (int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
