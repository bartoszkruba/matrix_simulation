package matrix.io;

import java.util.Scanner;

public class InputReader {
    int[] values = {1, 4, 1, 3, 2, 3, 2, 4, 1, 0};

    int i = 0;

    private final Scanner scanner;

    public InputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public long[] readHeader() {
        long[] values = new long[4];

        for (int i = 0; i < 2; i++) {
            long value = scanner.nextLong();
            if (value < 1) throw new RuntimeException("Invalid input");
            values[i] = value;
        }

        for (int i = 0; i < 2; i++) {
            long value = scanner.nextLong();
            if (value < 0) throw new RuntimeException("Invalid input");
            values[i + 2] = value;
        }

        return values;
    }

    public int readCommand() {
        int value = scanner.nextInt();

        if (value < 0 || value > 4) throw new RuntimeException("Invalid input");

        return value;
    }

}
