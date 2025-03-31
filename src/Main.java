public class Main {
    public static void main(String[] args) {
//        ListaSimple<Integer> x = new ListaSimple<>();
//
//        x.insertarFin(1);
//        x.insertarFin(2);
//        x.insertarFin(3);
//        x.insertarFin(4);
//        x.insertarFin(50);
//        x.insertarFin(60);
//
//        System.out.println(x.recorrerLista());
//
//        System.out.println(x.mostrarListaRecursivo());
//        x.eliminarX(1);
//        System.out.println("Esta en la posicion:" + x.buscar(50));
//        x.eliminaPosicion(4);
//        x.ordenarLista();
//        x.insertaEnPosicion(3, 3);
//
//        System.out.println(x.recorrerLista());



//        ListaDoble<Integer> x2 = new ListaDoble<>();
//        x2.insertarFinal(1);
//        x2.insertarFinal(2);
//        x2.insertarFinal(3);
//        x2.insertarFinal(4);
//        x2.insertarFinal(50);
//        x2.insertarFinal(6);

//        x2.recorrer();
//        System.out.println("");
//
//        x2.eliminaX(6);
//        System.out.println("Esta en la posicion:" + x2.buscar(1));
//        x2.eliminaPosicion(4);
//        x2.ordenarLista();
//        x2.insertaEnPosicion(0,0);
//        System.out.println(x2.mostrarListaRecursivo());
//
//        x2.recorrer();


        ListaCircular<Integer> x3 = new ListaCircular<>();
        x3.insertarFin(1);
        x3.insertarFin(2);
        x3.insertarFin(3);
        x3.insertarFin(4);
        x3.insertarFin(50);
        x3.insertarFin(6);

        System.out.println(x3.mostrarListaRecursivo());

        //x3.eliminarX(1);
        //System.out.println("Esta en la posicion:" + x3.buscar(6));
        //x3.eliminaPosicion(2);
        //x3.ordenarLista();
        //x3.insertaEnPosicion(0,0);

        System.out.println(x3.recorrerLista());
    }
}