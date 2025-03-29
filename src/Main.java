public class Main {
    public static void main(String[] args) {
        // Lista simple
        ListaSimple<Integer> lista = new ListaSimple<>();
        System.out.println("~~~~~ Lista simple ~~~~~");
        System.out.println("Insertando al inicio:");
        lista.insertarInicio(10);
        lista.insertarInicio(20);
        lista.insertarInicio(30);
        System.out.println("Lista actual: " + lista.recorrerLista());

        System.out.println("\nInsertando al final:");
        lista.insertarFin(40);
        lista.insertarFin(50);
        System.out.println("Lista actual: " + lista.recorrerLista());

        System.out.println("\nEliminando el primer elemento:");
        lista.eliminarInicio();
        System.out.println("Lista actual: " + lista.recorrerLista());

        System.out.println("\nEliminando el último elemento:");
        lista.eliminarFin();
        System.out.println("Lista actual: " + lista.recorrerLista());

        System.out.println("\nEliminando todos los elementos:");
        lista.eliminarInicio();
        lista.eliminarInicio();
        lista.eliminarInicio();
        lista.eliminarInicio();
        System.out.println("Lista actual: " + lista.recorrerLista());

        // Lista doble
        ListaDoble<Integer> lista2 = new ListaDoble<>();
        System.out.println("\n~~~~~ Lista doble ~~~~~");
        System.out.println("Insertando al inicio:");
        lista2.insertarInicio(10);
        lista2.insertarInicio(20);
        lista2.insertarInicio(30);
        lista2.recorrer();

        System.out.println("\nInsertando al final:");
        lista2.insertarFinal(40);
        lista2.insertarFinal(50);
        lista2.recorrer();

        System.out.println("\nEliminando el primer elemento: " + lista2.eliminarInicio());
        lista2.recorrer();

        System.out.println("\nEliminando el último elemento: " + lista2.eliminarFinal());
        lista2.recorrer();

        System.out.println("\nEliminando todos los elementos:");
        lista2.eliminarInicio();
        lista2.eliminarInicio();
        lista2.eliminarInicio();
        lista2.recorrer();

        // Lista circular
        ListaCircular<Integer> lista3 = new ListaCircular<>();
        System.out.println("\n~~~~~ Lista Circular ~~~~~");
        System.out.println("Insertando al inicio:");
        lista3.insertarInicio(10);
        lista3.insertarInicio(20);
        lista3.insertarInicio(30);
        System.out.println(lista3.recorrerLista());

        System.out.println("\nInsertando al final:");
        lista3.insertarFin(40);
        lista3.insertarFin(50);
        System.out.println(lista3.recorrerLista());

        System.out.println("\nEliminando el primer elemento: " + lista3.eliminarInicio());
        System.out.println(lista3.recorrerLista());

        System.out.println("\nEliminando el último elemento: " + lista3.eliminarFin());
        System.out.println(lista3.recorrerLista());

        System.out.println("\nEliminando todos los elementos:");
        lista3.eliminarInicio();
        lista3.eliminarInicio();
        lista3.eliminarInicio();
        System.out.println(lista3.recorrerLista());

        ListaCircularDoble<Integer> lista4 = new ListaCircularDoble<>();

        System.out.println("~~~~~ Lista Circular Doble ~~~~~");
        System.out.println("Insertando al inicio:");
        lista4.insertarInicio(10);
        lista4.insertarInicio(20);
        lista4.insertarInicio(30);
        lista4.imprimirLista();

        System.out.println("\nInsertando al final:");
        lista4.insertarFin(40);
        lista4.insertarFin(50);
        lista4.imprimirLista();

        System.out.println("\nEliminando del inicio: " + lista4.eliminarInicio());
        lista4.imprimirLista();

        System.out.println("\nEliminando del final: " + lista4.elimnarFin());
        lista4.imprimirLista();

        System.out.println("\nEliminando todos los elementos...");
        lista4.eliminarInicio();
        lista4.eliminarInicio();
        lista4.eliminarInicio();
        lista4.eliminarInicio();
        lista4.imprimirLista();
    }
}