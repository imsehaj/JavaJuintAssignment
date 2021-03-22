package helix;

//import sun.tools.jar.resources.jar;

public class MatrixHelixMorph {

    /**
     * @param inMatrix
     * @return a matrix that is morphed into a helix version of inMatrix
     */
    public static int[][] helix( int[][] inMatrix) {
    	
    	int n = inMatrix.length;
    	
    	if (n == 0)
            return inMatrix;
    	else if (inMatrix.length != inMatrix[0].length) {
    		return null;	
		}
    
        int k = 1;
        int i = 0;
        for ( i = 0; i <= n/2; i++) {
        	//From left to right
            for (int j=i;j<n-i;j++){
                inMatrix[i][j] = k++;
            }
            //From top to bottom
            for (int j=i+1;j<n-i;j++){
                inMatrix[j][n-i-1] = k++;
            }
            //From right to left
            for (int j=n-i-2;j>=i;j--){
                inMatrix[n-i-1][j] = k++;
            }
            //From bottom to top
            for (int j=n-i-2;j>i;j--){
                inMatrix[j][i] = k++;
            }
        }
        return inMatrix;

    }
}