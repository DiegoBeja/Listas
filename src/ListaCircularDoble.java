public class ListaCircularDoble <T>{
    private NodoDoble<T> inicio;
    private NodoDoble<T> fin;

    public ListaCircularDoble(){
        this.inicio = null;
        this.fin = null;
    }

    public void insertarInicio(T dato){
        NodoDoble<T> n = new NodoDoble<>();
        n.setInfo(dato);

        if(inicio == null){
            inicio = fin = n;
            n.setSig(inicio);
            n.setAnt(inicio);
        } else{
            n.setSig(inicio);
            inicio.setAnt(n);
            inicio = n;
            fin.setSig(inicio);
            n.setAnt(fin);
        }
    }

    public void insertarFin(T dato){
        NodoDoble<T> n = new NodoDoble<>();
        n.setInfo(dato);

        if(inicio == null){
            inicio = fin = n;
            n.setSig(inicio);
            n.setAnt(inicio);
        } else {
            n.setSig(inicio);
            inicio.setAnt(n);
            fin.setSig(n);
            n.setAnt(fin);
            fin = n;
        }
    }

    public T eliminarInicio(){
        if(inicio == null){
            System.out.println("Lista vacia");
            return null;
        }

        T dato = inicio.getInfo();

        if(inicio == null){
            inicio = fin = null;
        } else{
            fin.setSig(inicio.getSig());
            inicio = inicio.getSig();
            inicio.setAnt(fin);
        }

        return dato;
    }

    public T elimnarFin(){
        if(inicio == null){
            System.out.println("Lista vacia");
            return null;
        }

        T dato = fin.getInfo();

        if(inicio == fin){
            inicio = fin = null;
        } else{
            NodoDoble<T> r = fin.getAnt();
            r.setSig(inicio);
            inicio.setAnt(r);
            fin = r;
        }
        return dato;
    }

    public void imprimirLista() {
        if (inicio == null) {
            System.out.println("Lista vacía");
            return;
        }

        NodoDoble<T> actual = inicio;
        System.out.print("Lista: ");

        do {
            System.out.print(actual.getInfo() + " ");
            actual = actual.getSig();
        } while (actual != inicio);

        System.out.println();
    }

    //Ejercicios Examen
    public String mostrarRecursivo(NodoDoble<T> x, NodoDoble<T> referencia) {
        if (x.getSig() == referencia) {
            return x.getInfo() + "";
        }
        return x.getInfo() + " " + mostrarRecursivo(x.getSig(), referencia);
    }

    public String mostrarListaRecursivo() {
        if (inicio == null) {
            return "Lista vacía";
        }
        return mostrarRecursivo(inicio, inicio);
    }

    public T eliminarX(T x) {
        if (inicio == null) {
            System.out.println("Lista vacía");
            return null;
        }

        NodoDoble<T> actual = inicio;

        do {
            if (actual.getInfo().equals(x)) {
                T dato = actual.getInfo();

                if (inicio == fin && inicio.getInfo().equals(x)) {
                    inicio = fin = null;
                } else {
                    actual.getAnt().setSig(actual.getSig());
                    actual.getSig().setAnt(actual.getAnt());

                    if (actual == inicio) {
                        inicio = actual.getSig();
                    }
                    if (actual == fin) {
                        fin = actual.getAnt();
                    }
                }
                return dato;
            }
            actual = actual.getSig();
        } while (actual != inicio);

        return null; // No encontrado
    }

    public int buscar(T x) {
        if (inicio == null) {
            return -1;
        }

        NodoDoble<T> actual = inicio;
        int posicion = 0;

        do {
            if (actual.getInfo().equals(x)) {
                return posicion;
            }
            actual = actual.getSig();
            posicion++;
        } while (actual != inicio);

        return -1;
    }

    public T eliminaPosicion(int posicion) {
        if (inicio == null || posicion < 0) {
            return null;
        }

        NodoDoble<T> actual = inicio;
        int index = 0;

        do {
            if (index == posicion) {
                T dato = actual.getInfo();

                if (inicio == fin) {
                    inicio = fin = null;
                } else {
                    actual.getAnt().setSig(actual.getSig());
                    actual.getSig().setAnt(actual.getAnt());

                    if (actual == inicio) {
                        inicio = actual.getSig();
                    }
                    if (actual == fin) {
                        fin = actual.getAnt();
                    }
                }
                return dato;
            }
            actual = actual.getSig();
            index++;
        } while (actual != inicio);

        return null;
    }

    public void ordenarLista() {
        if (inicio == null || inicio.getSig() == inicio) {
            return;
        }

        boolean intercambio;
        do {
            intercambio = false;
            NodoDoble<T> actual = inicio;

            do {
                NodoDoble<T> siguiente = actual.getSig();
                if (((Comparable<T>) actual.getInfo()).compareTo(siguiente.getInfo()) > 0) {
                    T temp = actual.getInfo();
                    actual.setInfo(siguiente.getInfo());
                    siguiente.setInfo(temp);
                    intercambio = true;
                }
                actual = siguiente;
            } while (actual.getSig() != inicio);
        } while (intercambio);
    }

    public void insertaEnPosicion(T dato, int posicion) {
        NodoDoble<T> nuevo = new NodoDoble<>();
        nuevo.setInfo(dato);

        if (inicio == null && posicion == 0) {
            inicio = fin = nuevo;
            nuevo.setSig(nuevo);
            nuevo.setAnt(nuevo);
            return;
        }

        NodoDoble<T> actual = inicio;
        int index = 0;

        if (posicion == 0) {
            nuevo.setSig(inicio);
            nuevo.setAnt(fin);
            fin.setSig(nuevo);
            inicio.setAnt(nuevo);
            inicio = nuevo;
            return;
        }

        do {
            if (index == posicion - 1) {
                nuevo.setSig(actual.getSig());
                nuevo.setAnt(actual);
                actual.getSig().setAnt(nuevo);
                actual.setSig(nuevo);

                if (actual == fin) {
                    fin = nuevo;
                }
                return;
            }
            actual = actual.getSig();
            index++;
        } while (actual != inicio);

        System.out.println("Fuera de rango");
    }

}