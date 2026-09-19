package culinaryos;

/**
 * Clase concreta que representa un plan de sesión para la Sede Gourmet.
 */
public class PlanSesionGourmet {

    private String titulo;
    private String actividades;
    private String insumos;
    private String rubrica;

    public PlanSesionGourmet(String titulo) {
        this.titulo = titulo;
        this.actividades = "[DIGITAL] Temporizador automático activado con pasos interactivos";
        this.insumos = "[NUBE] Insumos sincronizados con inventario en tiempo real";
        this.rubrica = "[AUTO] Rúbrica de evaluación precargada desde el sistema";
    }

    public void mostrar() {
        System.out.println("=== PLAN DE SESIÓN GOURMET (Digital Interactivo) ===");
        System.out.println("Título    : " + titulo);
        System.out.println("Actividad : " + actividades);
        System.out.println("Insumos   : " + insumos);
        System.out.println("Rúbrica   : " + rubrica);
        System.out.println("====================================================");
    }
}
