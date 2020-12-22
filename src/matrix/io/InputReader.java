package matrix.io;

import java.util.Arrays;
import java.util.Scanner;

public class InputReader {

    private final Scanner scanner;

    public InputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public long[] readHeader() {
        String input = scanner.nextLine();

        String[] values = input.split(",");

        if (!validateHeaderInput(values)) throw new RuntimeException("Invalid header");

        return Arrays.stream(values).mapToLong(Long::parseLong).toArray();
    }

    public int[] readCommands() {
        String input = scanner.nextLine();

        String[] values = input.split(",");

        if (!validateCommandInput(values)) throw new RuntimeException("Invalid commands");

        return Arrays.stream(values).mapToInt(Integer::parseInt).toArray();
    }

    private boolean validateHeaderInput(String[] values) {
        if (values.length != 4) return false;

        for (int i = 0; i < 4; i++) {
            String value = values[i];
            try {
                long convertedValue = Long.parseLong(value);
                if (convertedValue < 0) return false;
                if (i < 2 && convertedValue == 0) return false;
            } catch (Exception e) {
                return false;
            }
        }

        return true;
    }

    private boolean validateCommandInput(String[] values) {
        int inputLength = values.length;

        if (inputLength == 0) return false;

        for (int i = 0; i < inputLength; i++) {
            String value = values[i];
            try {
                int convertedValue = Integer.parseInt(value);

                if (convertedValue < 0 || convertedValue > 4) return false;
                if (i == (inputLength - 1) && convertedValue != 0) return false;

            } catch (Exception e) {
                return false;
            }
        }

        return true;
    }

}
