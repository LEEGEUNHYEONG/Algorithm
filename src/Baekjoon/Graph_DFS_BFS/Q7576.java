package Baekjoon.Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by LGH on 2017-10-13.
 */
public class Q7576
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer (br.readLine ());

        int width = Integer.parseInt (st.nextToken ());
        int height = Integer.parseInt (st.nextToken ());

        if(width < 2 || width > 1000 || height < 2 || height > 1000)
        {
            System.out.println(0);
            return;
        }

        int[][] box = new int[height+1][width+1];

        Queue queue = new LinkedList<Tomato>();

        for(int i = 1; i <= height; i++)
        {
            st = new StringTokenizer (br.readLine ());
            for(int j = 1; j <= width; j++)
            {
                box[i][j] = Integer.parseInt (st.nextToken ());

                if(box[i][j] == 1)
                {
                    queue.add (new Tomato(i, j, 0));
                }
            }
        }

        if(queue.isEmpty ())
        {
            System.out.println("0");
            return;
        }

        bfs(queue, box, width, height);

        /*
        for(int i = 1; i <= height; i++)
        {
            for(int j = 1; j <= width; j++)
            {
                System.out.printf(box[i][j]+" ");
            }
            System.out.println();
        }
        */

        int result = 0;

        for(int i = 1; i <= height; i++)
        {
            for(int j = 1; j <= width; j++)
            {
                if(box[i][j] > result)
                {
                    result = box[i][j];
                }
                if(box[i][j] == 0)
                {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(result);
    }

    private static void bfs(Queue queue, int[][] box,  int width, int height)
    {
        int dx[]={0,0,1,-1};
        int dy[]={1,-1,0,0};

        Tomato tomato;

        while(!queue.isEmpty ())
        {
            tomato = (Tomato) queue.poll ();

            for(int i = 0; i < 4; i++)
            {
                int x = tomato.x + dx[i];
                int y = tomato.y + dy[i];

                if( y > 0 && y <= width && x > 0 && x <= height && box[x][y] == 0)
                {
                    queue.add (new Tomato(x, y, tomato.count+1));
                    box[x][y] = tomato.count+1;
                }
            }
        }
    }



    private static class Tomato
    {
        int x;
        int y;
        int count;

        public Tomato (int x, int y, int count)
        {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
