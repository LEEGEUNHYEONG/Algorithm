package Baekjoon.Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7569
{
    public static void main(String[] args)
    throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        if (row < 2 || row > 100 || col < 2 || col > 100 || height < 1 || height > 100)
        {
            System.out.println(0);
            return;
        }


        Queue<Tomato> queue = new LinkedList<>();

        int[][][] box = new int[row][col][height];

        for (int h = 0; h < height; h++)
        {
            for (int r = 0; r < row; r++)
            {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < col; c++)
                {
                    box[r][c][h] = Integer.parseInt(st.nextToken());
                    if (box[r][c][h] == 1)
                    {
                        queue.add(new Tomato(r, c, h, 0));
                    }
                }
            }
        }

        bfs(queue, box, row, col, height);

        int result = 0;

        for(int i = 0; i < height; i++)
        {
            for(int r = 0; r < row; r++)
            {
                for(int c = 0; c < col; c++)
                {
                    if(box[r][c][i] > result)
                    {
                        result = box[r][c][i];
                    }
                    if(box[r][c][i] == 0)
                    {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(result);
    }

    private static void bfs(Queue<Tomato> queue, int[][][] box, int row, int col, int height)
    {
        int dx[] = {0, 0, 0, 0, 1, -1};
        int dy[] = {0, 0, 1, -1, 0, 0};
        int dz[] = {1, -1, 0, 0, 0, 0};

        Tomato tomato;

        while(!queue.isEmpty())
        {
            tomato = queue.poll();

            for(int i = 0; i < 6; i++)
            {
                int x = tomato.x + dx[i];
                int y = tomato.y + dy[i];
                int z = tomato.z + dz[i];

                if( x >= 0 && x < row && y >= 0 && y < col && z >= 0 && z < height && box[x][y][z] == 0)
                {
                    queue.add (new Tomato(x, y, z, tomato.count+1));
                    box[x][y][z] = tomato.count+1;
                }
            }
        }
    }



    private static class Tomato
    {
        int x;
        int y;
        int z;
        int count;

        public Tomato(int x, int y, int z, int count)
        {
            this.x = x;
            this.y = y;
            this.z = z;
            this.count = count;
        }

    }

}
