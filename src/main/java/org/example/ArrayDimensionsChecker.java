package org.example;

public class ArrayDimensionsChecker {
    public static void checkArrayDimensions(int[][] array) throws ArrayDimensionsMismatchException {
        if (array == null || array.length == 0 || array[0].length == 0) {
            throw new ArrayDimensionsMismatchException("Массив пустой.");
        }

        int numRows = array.length;
        int numCols = array[0].length;

        for (int i = 1; i < numRows; i++) {
            if (array[i].length != numCols) {
                throw new ArrayDimensionsMismatchException("Длина строки " + i + " не совпадает с остальными строками.");
            }
        }

        for (int j = 1; j < numCols; j++) {
            for (int i = 0; i < numRows; i++) {
                if (array[i].length <= j) {
                    throw new ArrayDimensionsMismatchException("Столбец " + j + " не существует для строки " + i + ".");
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] array1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] array2 = {
                {1, 2},
                {4, 5, 9},
                {6, 7, 8}
        };

        try {
            System.out.println("Проверка array1:");
            checkArrayDimensions(array1);
        } catch (ArrayDimensionsMismatchException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            System.out.println("\nПроверка array2:");
            checkArrayDimensions(array2);
        } catch (ArrayDimensionsMismatchException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

class ArrayDimensionsMismatchException extends Exception {
    public ArrayDimensionsMismatchException(String message) {
        super(message);
    }
}
