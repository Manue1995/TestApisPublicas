package org.example;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        // Obtener la ruta de la carpeta "Documentos" del usuario
        String documentosPath = System.getProperty("user.home") + "/Documents/MiCarpeta";

        // Crear el objeto File
        File carpeta = new File(documentosPath);

        // Verificar si la carpeta existe y crearla si no existe
        if (!carpeta.exists()) {
            if (carpeta.mkdirs()) {
                System.out.println("✅ Carpeta creada en: " + documentosPath);
            } else {
                System.out.println("❌ No se pudo crear la carpeta.");
            }
        } else {
            System.out.println("⚠️ La carpeta ya existe en: " + documentosPath);
        }


        }
    }
