/**
 * Aplicación para usar las clases Contenedor y Contenido de forma genérica
 * @author Víctor Rivas <vrivas@ujaen.es>
 * @date 19-mar-2025
 */
package es.vrivas.dagil;

public final class App {
    /// Título de la aplicación
    private static final String TITULO = "Clases Contenedor y Contenido";

    /// Autor/a de la aplicación
    private static final String AUTOR = "Víctor Rivas <vrivas@ujaen.es>";

    /// Un objeto contenedor
    private static Contenedor contenedor = new Contenedor();

    /// Constructor privado para evitar instanciación
    private App() {
    }

    /**
     * Método para responder a la opción 1 del menú: mostrar contenido del objeto contenedor
     */
    public static void mostrar_contenido_del_objeto_contenedor() {
        System.out.println("Opción 1: Mostrar contenido del objeto contenedor");
        System.out.println(contenedor.toString());
    }

    /**
     * Método para mostrar el menú principal y leer la opción elegida
     * 
     * @return Opción elegida por el usuario
     */
    public static int menu_principal() {
        for (int i = 0; i < 5; ++i) {
            System.out.println();
        }
        System.out.println("**** MENU ****");
        System.out.println("     ----");
        System.out.println("1. Mostrar contenido del objeto contenedor");
        System.out.println("     ----");
        System.out.println("0. Terminar");
        System.out.println("--------------------");
        System.out.print("Introduzca una opción: ");
        String entrada = System.console().readLine();
        System.out.println();

        return Integer.parseInt(entrada);
    }

    /**
     * Método para pausar la ejecución hasta que el usuario pulse una tecla
     */
    private static void pausa() {
        System.out.println("(Pulse una tecla para continuar...)");
        System.console().readLine();
    }

    /**
     * Función principal
     * @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        System.out.println("\n" + TITULO + "    (por " + AUTOR + ")");

        boolean salir = false;
        do {
            switch (menu_principal()) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    mostrar_contenido_del_objeto_contenedor();
                    pausa();
                    break;
                default:
                    System.out.println("Opción no válida");
            }

        } while (!salir);
        System.out.println("Fin de la aplicación.");
    }
}