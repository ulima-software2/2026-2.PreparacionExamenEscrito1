package culinaryos;

/**
 * PROBLEMA CENTRAL DEL DISEÑO.
 *
 * Esta clase concentra toda la lógica de creación de planes de sesión.
 * Contiene múltiples bloques if/else para decidir qué objeto concreto
 * instanciar según el tipo de sede recibido como parámetro.
 *
 * Consecuencias negativas de este diseño:
 *
 * 1. VIOLACIÓN DEL PRINCIPIO ABIERTO/CERRADO:
 *    Cada vez que se agrega una nueva sede (ej. "VIRTUAL"), se debe
 *    modificar directamente este método, abriendo una clase que ya
 *    debería estar cerrada para modificación.
 *
 * 2. ACOPLAMIENTO FUERTE CON CLASES CONCRETAS:
 *    GestorDeSesiones conoce y depende directamente de:
 *    PlanSesionGourmet, PlanSesionIntermedia, PlanSesionComunitaria.
 *    Si cualquiera de esas clases cambia, este gestor puede verse afectado.
 *
 * 3. LÓGICA DE CREACIÓN MEZCLADA CON LÓGICA DE NEGOCIO:
 *    El gestor debería ocuparse de coordinar el flujo de una sesión,
 *    no de decidir cómo se construye cada tipo de plan.
 *
 * 4. DIFICULTAD PARA TESTEAR:
 *    No es posible inyectar un plan de prueba sin modificar este método.
 */
public class GestorDeSesiones {

    /**
     * Crea y ejecuta un plan de sesión según el tipo de sede.
     *
     * @param tipoSede  "GOURMET", "INTERMEDIA" o "COMUNITARIA"
     * @param titulo    Título de la sesión práctica
     */
    public void iniciarSesion(String tipoSede, String titulo) {

        System.out.println("\n[GestorDeSesiones] Iniciando sesión: " + titulo);
        System.out.println("[GestorDeSesiones] Tipo de sede recibido: " + tipoSede);
        System.out.println("[GestorDeSesiones] Decidiendo qué clase concreta instanciar...\n");

        // ---------------------------------------------------------------
        // PROBLEMA: bloque if/else acoplado a clases concretas.
        // Para agregar "SEDE VIRTUAL" hay que venir aquí y modificar esto.
        // ---------------------------------------------------------------
        if (tipoSede.equalsIgnoreCase("GOURMET")) {

            // Instancia directa de clase concreta — acoplamiento fuerte
            PlanSesionGourmet plan = new PlanSesionGourmet(titulo);
            plan.mostrar();
            System.out.println("[GestorDeSesiones] Sincronizando con sistema digital...");
            System.out.println("[GestorDeSesiones] Sesión Gourmet lista.\n");

        } else if (tipoSede.equalsIgnoreCase("INTERMEDIA")) {

            // Instancia directa de otra clase concreta
            PlanSesionIntermedia plan = new PlanSesionIntermedia(titulo);
            plan.mostrar();
            System.out.println("[GestorDeSesiones] Generando archivo PDF...");
            System.out.println("[GestorDeSesiones] Sesión Intermedia lista.\n");

        } else if (tipoSede.equalsIgnoreCase("COMUNITARIA")) {

            // Instancia directa de otra clase concreta
            PlanSesionComunitaria plan = new PlanSesionComunitaria(titulo);
            plan.mostrar();
            System.out.println("[GestorDeSesiones] Imprimiendo ficha manual...");
            System.out.println("[GestorDeSesiones] Sesión Comunitaria lista.\n");

        } else {
            // Si llega una sede nueva sin modificar este método, falla
            System.out.println("[GestorDeSesiones] ERROR: tipo de sede desconocido -> " + tipoSede);
            System.out.println("[GestorDeSesiones] Para agregar una sede nueva, modifique este método.\n");
        }
    }
}
