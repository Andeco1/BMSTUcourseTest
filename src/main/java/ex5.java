import java.util.Arrays;

public class ex5 {
    public static void main(String[] args) {
        int[][] triangle1 = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };

        findShortestPath(triangle1);

        int[][] triangle2 = {
                {-1},
                {2, 3},
                {1, -1, -3},
                {4, 2, 1, 3}
        };

        findShortestPath(triangle2);
    }

    public static void findShortestPath(int[][] triangle) {
        int n = triangle.length;
        int[][] sumTriangle = new int[n][];

        sumTriangle[0] = new int[triangle[0].length];
        sumTriangle[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            sumTriangle[i] = new int[triangle[i].length];
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    sumTriangle[i][j] = sumTriangle[i - 1][0] + triangle[i][0];
                } else if (j == triangle[i].length - 1) {
                    sumTriangle[i][j] = sumTriangle[i - 1][j - 1] + triangle[i][j];
                } else {
                    sumTriangle[i][j] = Math.min(sumTriangle[i - 1][j - 1], sumTriangle[i - 1][j]) + triangle[i][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i : sumTriangle[n-1]){
            min = Math.min(i, min);
        }
        System.out.println(min);

    }
}
