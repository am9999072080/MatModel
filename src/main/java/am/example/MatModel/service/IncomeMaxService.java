package am.example.MatModel.service;

/**
 * service for maximum income
 */
public interface IncomeMaxService {
    /**
     * @param m : Number of product types
     * @param n : Total number of resources
     * @param a : Material consumption in the product by sequence
     * @param b : volume of material by type by sequence
     * @param c : Product revenue by type by sequence
     * @return maximum income with minimum expenses
     */
    String findMaxIncomeWithMinimumExpenses(int m, int n, double[][] a, double[] b, double[] c);
}
