
    import java.util.Random;

    public class MatrixOperations {
        private static int[][] matrix;

        public static void main(String[] args) {
            int N = 5; // Örnek olarak 5x5lik bir matris oluşturuluyor

            // Matris oluşturma
            matrix = generateMatrix(N);

            // a) Her row için iş parçacıkları oluşturarak işlemleri gerçekleştirme
            for (int i = 0; i < N; i++) {
                Thread thread = new Thread(new RowProcessor(i));
                thread.start();
            }

            // b) Lock kullanmadan işlemleri gerçekleştirme
            processMatrixWithoutLock();

            // c) Tek bir iş parçacığı ile işlemleri gerçekleştirme
            processMatrixSingleThreaded();
        }

        // Matris oluşturma metod
        private static int[][] generateMatrix(int N) {
            Random random = new Random();
            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = random.nextInt(11) - 5; // -5 ile 5 arasında rastgele sayılar
                }
            }
            return matrix;
        }

        // a) Matrisin her bir row'u için işlem gerçekleştiren iş parçacığı
        static class RowProcessor implements Runnable {
            private int row;

            public RowProcessor(int row) {
                this.row = row;
            }

            @Override
            public void run() {
                // Burada her bir iş parçacığının yapması gereken işlemler gerçekleştirilecek
                // Örneğin: Negatif sayı kontrolü, negatif ve pozitif sayı sayımı, en büyük ve en küçük sayı tespiti
                // Senkronizasyon işlemleri burada yapılabilir
            }
        }

        // b) Lock kullanmadan işlemleri gerçekleştiren metod
        private static void processMatrixWithoutLock() {
            // Burada matris işlemleri yapılacak
            // Örneğin: Negatif sayı kontrolü, negatif ve pozitif sayı sayımı, en büyük ve en küçük sayı tespiti
            // Ancak burada senkronizasyon işlemleri kullanılmayacak
        }

        // c) Tek bir iş parçacığı ile işlemleri gerçekleştiren metod
        private static void processMatrixSingleThreaded() {
            // Burada matris işlemleri yapılacak, ancak tek bir iş parçacığı ile yapılacak
            // Örneğin: Negatif sayı kontrolü, negatif ve pozitif sayı sayımı, en büyük ve en küçük sayı tespiti
        }
    }


