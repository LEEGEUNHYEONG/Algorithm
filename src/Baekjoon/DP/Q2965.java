package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import Baekjoon.Baekjoon;

/**
 * Created by LGH on 2017-10-13.
 */
public class Q2965
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer (br.readLine ());

        int a = Integer.parseInt (st.nextToken ());
        int b = Integer.parseInt (st.nextToken ());
        int c = Integer.parseInt (st.nextToken ());

        System.out.println(b - a > c - b ? b - a - 1 : c - b - 1);

    }
}
