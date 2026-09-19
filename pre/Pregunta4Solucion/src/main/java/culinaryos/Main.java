package culinaryos;

/**
 * Clase principal — simula el uso del sistema SIN aplicar ningún patrón.
 *
 * Aquí se evidencia que el cliente (Main) pasa strings "mágicos" como
 * "GOURMET" o "INTERMEDIA" al gestor, y que toda la lógica de decisión
 * y creación recae en GestorDeSesiones mediante bloques if/else.
 *
 * Prueba del problema:
 *   - Intenta crear una sesión con sede "VIRTUAL" (no existe aún).
 *   - El sistema falla en tiempo de ejecución con un mensaje de error,
 *     porque nadie modificó GestorDeSesiones para contemplar ese caso.
 */
public class Main {

    public static void main(String[] args) {

        GestorDeSesiones gestor = new GestorDeSesiones();

        System.out.println("============================================");
        System.out.println("  CulinaryOS — SIN PATRÓN DE DISEÑO");
        System.out.println("============================================");

        // Caso 1: sede conocida — funciona, pero GestorDeSesiones
        // tiene que conocer la clase concreta PlanSesionGourmet
        gestor.iniciarSesion("GOURMET", "Técnicas de cocción sous-vide");

        // Caso 2: sede conocida — funciona, mismo problema de acoplamiento
        gestor.iniciarSesion("INTERMEDIA", "Preparación de masas laminadas");

        // Caso 3: sede conocida — funciona, mismo problema
        gestor.iniciarSesion("COMUNITARIA", "Cocina nutritiva con recursos básicos");

        // Caso 4: sede NUEVA no contemplada.
        // Para que funcione, habría que abrir GestorDeSesiones y agregar
        // otro bloque else-if. Esto viola el principio Abierto/Cerrado.
        System.out.println("--------------------------------------------");
        System.out.println("Intentando crear sesión para sede VIRTUAL...");
        System.out.println("(Sede nueva, no se modificó GestorDeSesiones)");
        System.out.println("--------------------------------------------");
        gestor.iniciarSesion("VIRTUAL", "Masterclass de repostería en línea");
    }
}
