public class ListaSimple <T>{
    private Nodo<T> inicio;

    public ListaSimple(){
        this.inicio = null;
    }

    public void insertarInicio(T dato){
        Nodo<T> n = new Nodo<>(dato);
        n.setSig(inicio);
        inicio = n;
    }

    public void insertarFin(T dato){
        Nodo<T> n = new Nodo<>(dato);
        if(inicio == null){
            n.setSig(inicio);
            inicio = n;
        } else{
            Nodo<T> r = inicio;
            while(r.getSig() != null){
                r = r.getSig();
            }
            r.setSig(n);
            n.setSig(null);
        }
    }

    public T eliminarInicio(){
        if(inicio == null){
            System.out.println("Lista vacia");
            return null;
        }

        T dato = inicio.getInfo();
        inicio = inicio.getSig();
        return dato;
    }

    public T eliminarFin(){
        if(inicio == null){
            System.out.println("Lista vacia");
            return null;
        }

        if(inicio.getSig() == null){
            T dato = inicio.getInfo();
            inicio = null;
            return dato;
        }

        Nodo<T> r = inicio;
        Nodo<T> a = r;
        while(r.getSig() != null){
           a = r;
           r = r.getSig();
        }
        T dato = r.getInfo();
        a.setSig(null);
        return dato;
    }

    public String recorrerLista(){
        StringBuilder cadena = new StringBuilder();
        if(inicio != null){
            Nodo r = inicio;
            while(r != null){
                cadena.append(r.getInfo().toString() + " ");
                r = r.getSig();
            }
        } else{
            System.out.println("Lista vacia");
        }
        return cadena.toString();
    }

    //Ejercicio examen
    private String mostrarRecursivo(Nodo<T> x){
        if(x == null){
            return "";
        }
        return x.getInfo() + " " + mostrarRecursivo(x.getSig());
    }

    public String mostrarListaRecursivo(){
        return mostrarRecursivo(inicio);
    }

    public T eliminarX(T x){
        if(inicio == null){
            return null;
        }

        if(inicio.getInfo().equals(x)){
            T dato = inicio.getInfo();
            inicio = inicio.getSig();
            return dato;
        }

        Nodo<T> actual = inicio.getSig();
        Nodo<T> anterior = inicio;

        while(actual != null){
            if(actual.getInfo().equals(x)){
                T dato = actual.getInfo();
                anterior.setSig(actual.getSig());
                return dato;
            }
            anterior = actual;
            actual = actual.getSig();
        }

        return null;
    }

    public int buscar(T x){
        int posicion = 1;
        if(inicio == null){
            return 0;
        }

        if(inicio.getInfo().equals(x)){
            return 1;
        }

        Nodo<T> actual = inicio.getSig();

        while(actual != null){
            if(actual.getInfo().equals(x)){
                return posicion;
            }
            actual = actual.getSig();
            posicion++;
        }

        return 0;
    }

    public T eliminaPosicion(int posicion){
        int index = 1;
        if(inicio == null){
            return null;
        }

        if(posicion == 0){
            T dato = inicio.getInfo();
            inicio = inicio.getSig();
            return dato;
        }

        Nodo<T> actual = inicio.getSig();
        Nodo<T> anterior = inicio;

        while(actual != null){
            if(index == posicion){
                T dato = actual.getInfo();
                anterior.setSig(actual.getSig());
                return dato;
            }
            anterior = actual;
            actual = actual.getSig();
            index++;
        }

        return null;
    }

    public void ordenarLista(){
        if(inicio == null || inicio.getSig() == null){
            return;
        }

        boolean intercambio;

        do{
            intercambio = false;
            Nodo<T> actual = inicio;
            Nodo<T> siguiente = inicio.getSig();
            Nodo<T> anterior = null;

            while(siguiente != null){
                if(((Comparable<T>) actual.getInfo()).compareTo(siguiente.getInfo()) > 0){
                    if(anterior == null){
                        inicio = siguiente;
                    } else{
                        anterior.setSig(siguiente);
                    }
                    actual.setSig(siguiente.getSig());
                    siguiente.setSig(actual);

                    anterior = siguiente;
                    siguiente = actual.getSig();
                    intercambio = true;
                } else{
                    anterior = actual;
                    actual = siguiente;
                    siguiente = siguiente.getSig();
                }
            }
        }while(intercambio);
    }

    public void insertaEnPosicion(T dato, int posicion){
        Nodo<T> n = new Nodo<>(dato);

        if(posicion == 0){
            n.setSig(inicio);
            inicio = n;
            return;
        }

        Nodo<T> actual = inicio;
        int index = 0;

        while(actual != null && index < posicion - 1){
            actual = actual.getSig();
            index++;
        }

        if(actual == null){
            System.out.println("Fuera de rango");
            return;
        }

        n.setSig(actual.getSig());
        actual.setSig(n);
    }
}
