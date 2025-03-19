package es.vrivas.dagil;

/**
 * Aplicación para usar las clases Contenedor y Contenido de forma genérica
 * @author Víctor Rivas <vrivas@ujaen.es>
 * @date 19-mar-2025
 */
public final class App {
    /// Título de la aplicación
    private static final String TITULO = "Clases Contenedor y Contenido";

    /// Autor/a de la aplicación
    private static final String AUTOR = "Víctor Rivas <vrivas@ujaen.es>";

    /// Constructor privado para evitar instanciación
    private App() {
    }

    /**
     * Función principal
     * @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        System.out.println("\n" + TITULO + "    (por " + AUTOR + ")");
    }
}
