package pregunta1;

public class Pregunta1 {
    static void main() {
        Zoologico zoo = new Zoologico();

        zoo.registrarAnimal(new Aguila("Aguila 1", "Cielo"));
        zoo.registrarAnimal(new Delfin("Delfin 1", "Mar"));
        zoo.registrarAnimal(new Pato("Pato 1", "Lago"));

        zoo.mostrarTodos();
        System.out.println("=============================");
        zoo.listarVoladores();
        System.out.println("=============================");
        zoo.listarNadadores();
    }
}
