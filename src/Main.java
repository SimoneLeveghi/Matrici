public class Main {
    public static void main(String[] args) {
        try {
            int[][] mat1 = MatrixManager.getRandomMatrix(3, 3, 5);
            int[][] mat2 = MatrixManager.getRandomMatrix(3, 3, 5);

            System.out.println("Mat1:\n" + MatrixManager.toString(mat1));
            System.out.println("Mat2:\n" + MatrixManager.toString(mat2));

            System.out.println("Somma:\n" +
                    MatrixManager.toString(
                        MatrixManager.sum(mat1, mat2)
                    )
            );

            System.out.println("Moltiplicazione:\n" +
                    MatrixManager.toString(
                            MatrixManager.multiply(mat1, mat2)
                    )
            );

            System.out.println("Tipo mat1: " + MatrixManager.getTipi(mat1));

            int[][] mat3 = {
                    {1, 0, 0, 0},
                    {0, 1, 0, 0},
                    {0, 0, 1, 0},
                    {0, 0, 0, 1}
            };
            System.out.println("Tipo mat3: " + MatrixManager.getTipi(mat3));

            mat3[1][1] = 2;
            System.out.println("Tipo mat3 (dopo cambio): " + MatrixManager.getTipi(mat3));

            System.out.println(
                    "Trasposta di mat1: \n" +
                    MatrixManager.toString(
                            MatrixManager.getTrasposta(mat1)
                    )
            );
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
}