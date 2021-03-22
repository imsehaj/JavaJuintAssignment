package helix;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MatrixHelixMorphTest {

    /** Check if two integer matrices have the same contents
     *
     * @param matrix1
     * @param matrix2
     * @return true if the contents of matrix1 and matrix2 are identical and false otherwise
     */
    public static boolean testEqual(int[][] matrix1, int[][] matrix2) {

        /*
            Basic sanity checking:
                Verify that lengths are equal
         */
        if (matrix1 == null || matrix2 == null) {
            return true;
        }
        if (matrix1.length != matrix2.length) {
            return false;
        }
        if (matrix1[0].length != matrix2[0].length) {
            return false;
        }

        /*
            Test the contents of the matrices
         */
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void test2x2() {
        int[][] inMatrix  = { {1, 2}, {3, 4} };
        int[][] expOutput = { {1, 2}, {4, 3} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test1x1() {
        int[][] inMatrix  = { {1} };
        int[][] expOutput = { {1} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }
    
    @Test
    public void test3x3() {
        int[][] inMatrix  = { {1,2,3},{4,5,6},{7,8,9}};
        int[][] expOutput = { {1,2,3},{8,9,4},{7,6,5}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }
    
    @Test
    public void test4x4() {
        int[][] inMatrix  = { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } };
        int[][] expOutput = {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }
    
    @Test
    public void testmxn() {
    	int[][] inMatrix  = { { 1, 2, 3 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } };
        assertTrue((MatrixHelixMorph.helix(inMatrix) == null ));
    }
    
    @Test
    public void testEmptyMatrix() {
    	int n = 0;
    	int[][] inMatrix = new int[n][n];
        assertTrue((MatrixHelixMorph.helix(inMatrix) != null || MatrixHelixMorph.helix(inMatrix).length != 0));
    }
    
    /*
     * Tests the program against nXn matrix and sees if it returns null or empty array
     * */
    @Test
    public void testnxn() {
    	int n= 5;
    	int k =0;
    	int[][] inMatrix = new int[n][n];
    	//Genrating an nXn matrix
    	for (int  i = 0; i <= n/2; i++) {
            for (int j=i;j<n-i;j++){
                inMatrix[i][j] = k++;
            }
        }
        assertTrue((MatrixHelixMorph.helix(inMatrix) != null || MatrixHelixMorph.helix(inMatrix).length != 0));
    }
    
    

    // ADD TESTS TO CHECK PARTITIONS
}
