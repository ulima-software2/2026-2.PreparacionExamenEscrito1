package culinaryos;

/**
 * Clase concreta que representa un plan de sesión para la Sede Intermedia.
 */
public class PlanSesionIntermedia {

    private String titulo;
    private String actividades;
    private String formato;
    private String rubrica;

    public PlanSesionIntermedia(String titulo) {
        this.titulo = titulo;
        this.actividades = "[PDF] Secciones predefinidas completadas por el docente";
        this.formato = "[PDF] Exportable e imprimible en formato estructurado";
        this.rubrica = "[MANUAL] Rúbrica adjunta al documento PDF";
    }

    public void mostrar() {
        System.out.println("=== PLAN DE SESIÓN INTERMEDIA (PDF Estructurado) ===");
        System.out.println("Título    : " + titulo);
        System.out.println("Actividad : " + actividades);
        System.out.println("Formato   : " + formato);
        System.out.println("Rúbrica   : " + rubrica);
        System.out.println("====================================================");
    }
}
