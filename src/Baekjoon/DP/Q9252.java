package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Baekjoon.Baekjoon;

/**
 * Created by LGH on 2017-10-13.
 */
public class Q9252
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
            System.out.println (0);
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

        System.out.println (lcs[l1][l2]);

        StringBuilder sb = new StringBuilder ();

        while(lcs[l1][l2] != 0)
        {
            if(lcs[l1][l2] == lcs[l1][l2 - 1])
            {
                l2--;
            }
            else if(lcs[l1][l2] == lcs[l1 - 1][l2])
            {
                l1--;
            }
            else if(lcs[l1][l2] - 1 == lcs[l1 - 1][l2 - 1])
            {
                sb.append (s1.charAt (l1 - 1));

                l2--;
                l1--;
            }
        }

        System.out.println(sb.reverse ().toString ());
    }
}
