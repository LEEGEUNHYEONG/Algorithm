package Baekjoon;

import java.util.Scanner;

public class Q1149
{
    private static int[][] houses;
    private static int[][] result;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        houses = new int[count][3];
        result = new int[count][3];

        for(int i = 0; i < houses.length; i++)
        {
            for(int j = 0; j < houses[i].length; j++)
            {
                houses[i][j] = scanner.nextInt();
            }
            if(i == 0)
            {
                result[0][0] = houses[0][0];
                result[0][1] = houses[0][1];
                result[0][2] = houses[0][2];
            }
            else
            {
                result[i][0] = houses[i][0] + (Math.min(result[i-1][1], result[i-1][2]));
                result[i][1] = houses[i][1] + (Math.min(result[i-1][0], result[i-1][2]));
                result[i][2] = houses[i][2] + (Math.min(result[i-1][0], result[i-1][1]));
            }
        }
        System.out.println(Math.min( result[count-1][0] , Math.min(result[count-1][1], result[count-1][2])));
    }
}
