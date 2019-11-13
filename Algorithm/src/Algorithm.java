import java.util.Scanner;


public class Algorithm {
    public static Scanner in = new Scanner(System.in);
    private static String[][][] color;
    private static String[] cache = null;
    private static int hit = 0, miss = 0;
    private static int N, M, k;

    public static void main(String[] args) {
        N = in.nextInt();
        M = in.nextInt();
        k = in.nextInt();
        cache = new String[k];
        color = new String[N][M][4];
        createMatrix(color);
//        first();
        System.out.println();
//        second();
        System.out.println();
        third();
    }

    public static void first() {
        int cacheIndex = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int g = 0; g < 4; g++) {
                    if (cache[cacheIndex] != color[i][j][g]) {
                        miss++;
                        takeCache(cacheIndex, i, j, g);
                    }
                    else{
                        hit++;
                    }
                    cacheIndex++;
                    if(cacheIndex == k) cacheIndex = 0;
                }
            }
        }
        System.out.println("Total: " + (hit + miss) );
        System.out.println("Hits: " + hit);
        System.out.println("Miss: " + miss);

    }

    public static void second() {
        int cacheIndex = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int g = 0; g < 4; g++) {
                    if (cache[cacheIndex] != color[j][i][g]) {
                        miss++;
                        takeCache(cacheIndex, j, i, g);
                    }
                    else{
                        hit++;
                    }
                    cacheIndex++;
                    if(cacheIndex == k) cacheIndex = 0;
                }
            }
        }
        System.out.println("Total: " + (hit + miss) );
        System.out.println("Hits: " + hit);
        System.out.println("Miss: " + miss);
    }

    public static void third() {
        int cacheIndex = 3;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cache[cacheIndex] != (color[i][j][3])) {
                    miss++;
                    takeCache(cacheIndex, i, j, 3);
                }
                else{
                    hit++;
                }
                cacheIndex+=4;
                if(cacheIndex >= k) cacheIndex = cacheIndex - k;
            }
        }
        System.out.println("Total: " + (hit + miss) );
        System.out.println("Hits: " + hit);
        System.out.println("Miss: " + miss);
    }

    private static void takeCache(int index, int i, int j, int g) {
        while(index<k){
            cache[index++] = color[i][j][g++];
            if(g==4){
                g = 0;
                j++;
            }
            if(j==M){
                j = 0;
                i++;
            }
            if(i==N){
                i = 0;
            }
        }
        for(int i1 = 0; i1<k;i1++){
            System.out.print(cache[i1] + " ");
        }
        System.out.println();
    }

    public static void createMatrix(String[][][] color) {
        for (int i = 0; i < color.length; i++) {
            for (int j = 0; j < color[i].length; j++) {
                for (int g = 0; g < 4; g++) {
                    color[i][j][g] = i + "" + j + "" + g;
                }
            }
        }
    }

    public static void print(String[][][] color) {
        for (int i = 0; i < color.length; i++) {
            for (int j = 0; j < color[i].length; j++) {
                for (int g = 0; g < 4; g++) {
                System.out.print(color[i][j][g] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}