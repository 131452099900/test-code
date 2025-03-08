package com.code.mapper;
import java.util.*;

给定T，接下来输入T组数据
        对于每组数据，第一行为n，m，k接下来n行每行为长度为m的字符串，输入是能是小写字母组成，用java语言实现，案例如下
        输入
        2
        3 2 1
        ab
        ba
        bc
        3 2 1
        ab
        ba
        bb

        输出
        NO
        1
        YES
//import java.util.Scanner;

public class SubmatrixChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 读取测试用例数量

        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt(); // 行数
            int m = scanner.nextInt(); // 列数
            int k = scanner.nextInt(); // 子矩阵大小
            scanner.nextLine(); // 消耗换行符

            // 读取矩阵
            char[][] matrix = new char[n][m];
            for (int i = 0; i < n; i++) {
                String row = scanner.nextLine();
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = row.charAt(j);
                }
            }

            // 检查是否存在满足条件的子矩阵
            boolean found = false;
            for (int i = 0; i <= n - k; i++) {
                for (int j = 0; j <= m - k; j++) {
                    if (isUniformSubmatrix(matrix, i, j, k)) {
                        found = true;
                        System.out.println("YES");
                        System.out.println((i + 1) + " " + (j + 1)); // 输出左上角位置（从1开始计数）
                        break;
                    }
                }
                if (found) break;
            }

            if (!found) {
                System.out.println("NO");
            }
        }
        scanner.close();
        char[][] arr = new char[][]{{'a', 'b'}, {'b', 'a'}, {'b', 'c'}};
        isUniformSubmatrix(arr);
    }

    // 检查从 (row, col) 开始的 k x k 子矩阵是否所有字符相同
    private static boolean isUniformSubmatrix(char[][] matrix, int row, int col, int k) {
        char target = matrix[row][col];
        for (int i = row; i < row + k; i++) {
            for (int j = col; j < col + k; j++) {
                if (matrix[i][j] != target) {
                    return false;
                }
            }
        }
        return true;
    }
}


