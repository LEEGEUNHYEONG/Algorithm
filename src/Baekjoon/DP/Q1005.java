package Baekjoon.DP;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import Baekjoon.Baekjoon;

/**
 * Created by LGH on 2017-09-28.
 */

/**
 *  위상정렬
 */
public class Q1005
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner (System.in);

        int testCase = scanner.nextInt ();

        for(int i = 0; i < testCase; i++)
        {
            int n = scanner.nextInt ();
            int k = scanner.nextInt ();

            int[] time = new int[n+1];
            boolean[][] path = new boolean[n+1][n+1];
            int[] indegree = new int[n+1];

            for(int t = 1; t <= n; t++)
            {
                time[t] = scanner.nextInt ();
            }


            for(int t = 1; t<= k; t++)
            {
                int start = scanner.nextInt ();
                int end = scanner.nextInt ();

                path[start][end] = true;
                indegree[end]++;
            }

            int destination = scanner.nextInt ();

            int[] result = search(path, indegree, time);

            System.out.println(result[destination]);

        }
    }

    private static int[] search(boolean[][] path, int[] indegree, int[] time)
    {
        Queue<Integer> queue = new LinkedList<> ();
        int[] result = new int[indegree.length];

        for(int i = 1; i < result.length; i++)
        {
            if(indegree[i] == 0)
            {
                result[i] = time[i];
                queue.add (i);
                break;
            }
        }

        while(!queue.isEmpty ())
        {
            int temp = queue.poll ();

            for(int i = 1; i < result.length; i++)
            {
                if(path[temp][i])
                {
                    result[i] = Math.max (result[i], result[temp] + time[i]);

                    if(--indegree[i] == 0)
                    {
                        queue.add (i);
                    }
                }
            }
        }
        return result;
    }
}
