package leetcdoe.ex20230130;

public class SearchMatrix {

    public static void main(String[] args) {
        SearchMatrix demo = new SearchMatrix();
        int[][] matrix = {{1,3,5,7},{8,9,10,11}};
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        boolean flag = demo.searchMatrix(matrix, 8);
        System.out.println(flag);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 0) {
            return false;
        }
        int lines = matrix.length;
        int columns = matrix[0].length;
        int len = lines * columns;
        int startIdx = 0;
        int endIdx = len -1;
        while (startIdx <= endIdx) {
            int midIdx = ((endIdx - startIdx) >> 1) + startIdx;
            int curVal = matrix[midIdx / columns][midIdx % columns];
            if (curVal == target) {
                return true;
            } else if (curVal > target) {
                endIdx = midIdx - 1;
            } else {
                startIdx = midIdx + 1;
            }
        }
        return false;
    }
}
