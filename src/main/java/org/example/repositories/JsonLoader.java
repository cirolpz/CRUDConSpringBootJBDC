package org.example.repositories;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonLoader {

    private static final String FILE_NAME = "last_load_date.txt"; // Archivo para almacenar la fecha de la última carga
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    // Método para verificar si el JSON ya se cargó hoy
    private boolean hasJsonLoadedToday() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String lastLoadDate = reader.readLine();
                String today = DATE_FORMAT.format(new Date());
                return today.equals(lastLoadDate);
            } catch (IOException e) {
                e.printStackTrace(); // Manejo de errores
            }
        }
        return false;
    }

    // Método para cargar el JSON
    public void loadJson() {
        if (hasJsonLoadedToday()) {
            System.out.println("El JSON ya se cargó hoy. No se realizará la carga.");
            return;
        }

        try {
            // Lógica para cargar el JSON
            System.out.println("Cargando JSON...");

            // Si se carga exitosamente, guardar la fecha de la carga
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                writer.write(DATE_FORMAT.format(new Date()));
            }

        } catch (Exception e) {
            e.printStackTrace(); // Manejo de errores
        }
    }
}