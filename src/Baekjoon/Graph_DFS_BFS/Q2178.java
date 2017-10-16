package Baekjoon.Graph_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        if(height < 2 || height > 100 || width < 2 || width > 100)
        {
            System.out.println(0);
            return;
        }

        int[][] input = new int[height + 1][width + 1];
        boolean[][] visited = new boolean[height + 1][width + 1];

        for(int h = 1; h < height + 1; h++)
        {
            String line = br.readLine();

            for(int w = 1; w < width + 1; w++)
            {
                input[h][w] = Character.getNumericValue(line.charAt(w - 1));
            }
        }

        Queue<Position> queue = new LinkedList();

        queue.add(new Position(1, 1, 1));
        visited[1][1] = true;

        int result = search(queue, input, visited, height, width);

        System.out.println(result);
    }

    private static int search(Queue<Position> queue, int[][] input, boolean[][] visited, int height, int width)
    {
        Position position;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!queue.isEmpty())
        {
             position = queue.poll();

             if(position.x == height && position.y == width)
             {
                 return position.count;
             }
             else
             {
                 for(int i = 0; i < 4; i++)
                 {
                     int x = position.x + dx[i];
                     int y = position.y + dy[i];

                     if(x > 0 && x <= height && y > 0 && y <= width && !visited[x][y] && input[x][y] == 1 )
                     {
                         visited[x][y] = true;
                         queue.add(new Position(x, y, position.count + 1 ));
                     }
                 }
             }
        }
        return 0;
    }

    private static class Position
    {
        int x;
        int y;
        int count;

        public Position(int x, int y, int count)
        {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
