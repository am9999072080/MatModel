package am.example.MatModel.service.Impl;

import am.example.MatModel.service.IncomeMaxService;
import org.springframework.stereotype.Service;


@Service
public class IncomeMaxServiceImpl implements IncomeMaxService {
    @Override
    public String findMaxIncomeWithMinimumExpenses(int m, int n, double[][] a, double[] b, double[] c) throws RuntimeException {
        double[][] v = arrayConversion(m, n, a);
        if (v[0].length != m) {
            throw new IndexOutOfBoundsException("Array sizes must be equal");
        }
        double max = Double.MIN_VALUE;
        int indexMax = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] > max) {
                indexMax = i;
                max = c[i];
            }
        }
        double[] d = new double[b.length];
        for (int i = 0; i < b.length; i++) {
            d[i] = b[i] / v[indexMax][i];
        }
        double min = Double.MAX_VALUE;
        for (int i = 0; i < d.length; i++) {
            if (d[i] < min) {
                min = d[i];
            }
        }
        double maximumIncome;

        maximumIncome = min * max;
        String s = "With the product: " + (indexMax + 1) + ", the maximum income will be: " + maximumIncome;
        return s;
    }

    public static double[][] arrayConversion(int m, int n, double[][] a) {
        double[][] v = new double[m][n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                v[i][j] = a[k][0];
                k++;
            }
        }
        return v;
    }
}
