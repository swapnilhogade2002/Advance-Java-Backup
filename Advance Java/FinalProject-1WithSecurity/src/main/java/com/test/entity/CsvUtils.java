package com.test.entity;

import java.lang.reflect.Field;
import java.util.List;

public class CsvUtils {

    public static <T> byte[] generateCsvData(List<T> entities) {
        StringBuilder csvData = new StringBuilder();

        if (!entities.isEmpty()) {
            // Generate headers
            csvData.append(getCsvHeaders(entities.get(0))).append("\n");

            // Generate data
            for (T entity : entities) {
                csvData.append(getCsvRow(entity)).append("\n");
            }
        }

        return csvData.toString().getBytes();
    }

    private static <T> String getCsvHeaders(T entity) {
        Field[] fields = entity.getClass().getDeclaredFields();
        StringBuilder headers = new StringBuilder();

        for (Field field : fields) {
            headers.append(field.getName()).append(",");
        }

        // Remove the trailing comma
        return headers.substring(0, headers.length() - 1);
    }

    private static <T> String getCsvRow(T entity) {
        Field[] fields = entity.getClass().getDeclaredFields();
        StringBuilder row = new StringBuilder();

        for (Field field : fields) {
            field.setAccessible(true);

            try {
                Object value = field.get(entity);
                row.append(value).append(",");
            } catch (IllegalAccessException e) {
                // Handle exception
            }
        }

        // Remove the trailing comma
        return row.substring(0, row.length() - 1);
    }
}
