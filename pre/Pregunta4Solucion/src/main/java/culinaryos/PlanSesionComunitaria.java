package culinaryos;

/**
 * Clase concreta que representa un plan de sesión para la Sede Comunitaria.
 */
public class PlanSesionComunitaria {

    private String titulo;
    private String actividades;
    private String materiales;

    public PlanSesionComunitaria(String titulo) {
        this.titulo = titulo;
        this.actividades = "[PAPEL] Actividades escritas a mano en ficha imprimible";
        this.materiales = "[LISTA] Materiales anotados manualmente por el docente";
    }

    public void mostrar() {
        System.out.println("=== PLAN DE SESIÓN COMUNITARIA (Ficha Simple) ===");
        System.out.println("Título     : " + titulo);
        System.out.println("Actividad  : " + actividades);
        System.out.println("Materiales : " + materiales);
        System.out.println("==================================================");
    }
}
