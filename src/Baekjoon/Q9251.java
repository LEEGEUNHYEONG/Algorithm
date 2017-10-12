package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by LGH on 2017-10-12.
 */
public class Q9251
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

        String s1 = br.readLine ();
        String s2 = br.readLine ();

        int l1 = s1.length ();
        int l2 = s2.length ();

        if(l1 > 1000 || l2 > 1000)
        {
            System.out.println(0);
            return;
        }

        int[][] lcs = new int[l1 + 1][l2 + 1];

        for(int i = 1; i <= l1; i++)
        {
            for(int j = 1; j <= l2; j++)
            {
                if(s1.charAt (i-1) == s2.charAt (j - 1))
                {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }
                else
                {
                    lcs[i][j] = Math.max (lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }



        System.out.println(lcs[l1][l2]);

        /*
        for(int i = 1; i <= l1; i++)
        {
            for(int j = 1; j <= l2; j++)
            {
                System.out.printf(lcs[i][j] + " ");
            }
            System.out.println();
        }
        */


    }
}
