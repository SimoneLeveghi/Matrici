import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class MatrixManager {

    public static int[][] getRandomMatrix(int height, int length) throws Exception {
        if(height <= 0 || length <= 0) throw new Exception("Valori non validi");
        int[][] mat = new int[height][length];
        Random r = new Random();

        for(int i = 0; i < mat.length; ++i) {
            for(int j = 0; j < mat[i].length; ++j) {
                mat[i][j] = r.nextInt();
            }
        }

        return mat;
    }
    public static int[][] getRandomMatrix(int height, int length, int maxValue) throws Exception {
        if(height <= 0 || length <= 0) throw new Exception("Valori non validi");
        int[][] mat = new int[height][length];
        Random r = new Random();

        for(int i = 0; i < mat.length; ++i) {
            for(int j = 0; j < mat[i].length; ++j) {
                mat[i][j] = r.nextInt(maxValue);
            }
        }

        return mat;
    }

    public static int[][] getRandomMatrix(int height, int length, int minValue, int maxValue) throws Exception {
        if(height <= 0 || length <= 0) throw new Exception("Valori non validi");
        int[][] mat = new int[height][length];
        Random r = new Random();

        for(int i = 0; i < mat.length; ++i) {
            for(int j = 0; j < mat[i].length; ++j) {
                mat[i][j] = r.nextInt(minValue, maxValue);
            }
        }

        return mat;
    }

    public static int[][] sum(int[][] mat1, int[][] mat2) throws Exception {
        if(mat1.length != mat2.length || mat1[0].length != mat2[0].length) throw new Exception("Le matrici non hanno le stesse dimensioni");

        int[][] res = new int[mat1.length][mat1[0].length];
        for(int i = 0; i < mat1.length; ++i) {
            for(int j = 0; j < mat1[0].length; ++j) {
                res[i][j] = mat1[i][j] + mat2[i][j];
            }
        }

        return res;
    }

    public static int[][] multiply(int[][] mat1, int[][] mat2) throws Exception {
        int[][] res;
        int colonne = 0;
        int righe = 0;
        int elems = 0;

        if(mat1.length == mat2[0].length) {
            righe = mat2.length;
            colonne = mat1[0].length;
            elems = mat1.length;
        }
        else if(mat1[0].length == mat2.length) {
            righe = mat1.length;
            colonne = mat2[0].length;
            elems = mat1[0].length;
        }
        else {
            throw new Exception("Le matrici non possono essere moltiplicate");
        }

        res = new int[righe][colonne];
        for(int riga = 0; riga < righe; ++riga) {
            for(int colonna = 0; colonna < colonne; ++colonna) {
                if(elems == mat1.length) {
                    for(int i = 0; i < elems; ++i) {
                        res[riga][colonna] += (mat1[i][riga] * mat2[colonna][i]);
                    }
                }
                else {
                    for(int i = 0; i < elems; ++i) {
                        res[riga][colonna] += (mat1[riga][i] * mat2[i][riga]);
                    }
                }
            }
        }

        return res;
    }

    public static boolean isQuadrata(int[][] mat) {
        return mat.length == mat[0].length;
    }

    public static boolean isTriangolare(int[][] mat) {
        if(isQuadrata(mat)) {
            for(int i = 0; i < mat.length; ++i) {
                for(int j = 0; j < mat[0].length; ++j) {
                    if(i >= j && mat[i][j] != 0) return false;
                }
            }

            return true;
        }

        return false;
    }

    public static boolean isDiagonale(int[][] mat) {
        if(isQuadrata(mat)) {
            for(int i = 0; i < mat.length; ++i) {
                for (int j = 0; j < mat[0].length; ++j) {
                    if (i != j && mat[i][j] != 0) return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean isIdentita(int[][] mat) {
        if(isDiagonale(mat)) {
            for(int i = 0; i < mat.length; ++i) {
                if(mat[i][i] != 1) return false;
            }
            return true;
        }
        return false;
    }


    public static String[] getTipi(int[][] mat) {
        ArrayList<String> tipi = new ArrayList<String>();
        if(isIdentita(mat)) tipi.add("Identita");
        if(isDiagonale(mat)) tipi.add("Diagonale");
        if(isTriangolare(mat)) tipi.add("Triangolare");
        if(isQuadrata(mat)) tipi.add("Quadrata");

        return (String[]) tipi.toArray();
    }

    public static int[][] getTrasposta(int[][] mat) {
        int[][] trasp = new int[mat[0].length][mat.length];

        for(int i = 0; i < mat.length; ++i) {
            for(int j = 0; j < mat[i].length; ++j) {
                trasp[j][i] = mat[i][j];
            }
        }

        return trasp;
    }

    public static String toString(int[][] mat) {
        String ret = "";

        for(int[] i : mat) {
            for(int j : i) {
                ret += (j + "\t");
            }
            ret += "\n";
        }

        return ret;
    }
}
