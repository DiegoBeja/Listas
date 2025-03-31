public class ListaCircular <T>{
    private NodoCircular<T> inicio;
    private NodoCircular<T> fin;

    public ListaCircular(){
        this.inicio = null;
        this.fin = null;
    }

    public void insertarInicio(T dato){
        NodoCircular<T> n = new NodoCircular<>();
        n.setInfo(dato);

        if(inicio == null){
            inicio = fin = n;
            n.setSig(inicio);
        } else{
            n.setSig(inicio);
            inicio = n;
            fin.setSig(inicio);
        }
    }

    public void insertarFin(T dato){
        NodoCircular<T> n = new NodoCircular<>();
        n.setInfo(dato);

        if(inicio == null){
            inicio = fin = n;
            n.setSig(inicio);
        } else{
            n.setSig(inicio);
            fin.setSig(n);
            fin = n;
        }
    }

    public T eliminarInicio(){
        if(inicio == null){
            System.out.println("Lista vacia");
            return null;
        }

        T dato = inicio.getInfo();

        if(inicio == fin){
            inicio = fin = null;
        } else{
            fin.setSig(inicio.getSig());
            inicio = inicio.getSig();
        }
        return dato;
    }

    public T eliminarFin(){
        if(inicio == null){
            System.out.println("Lista vacia");
            return null;
        }

        T dato = fin.getInfo();

        if(inicio == fin){
            inicio = fin = null;
        } else{
            NodoCircular<T> r = inicio;
            while(r.getSig() != fin){
                r = r.getSig();
            }
            fin = r;
            fin.setSig(inicio);
        }
        return dato;
    }

    public String recorrerLista(){
        if(inicio == null){
            return "Lista vacía";
        } else{
            StringBuilder resultado = new StringBuilder();
            NodoCircular<T> r = inicio;

            do{
                resultado.append(r.getInfo()).append(" ");
                r = r.getSig();
            } while(r != inicio);

            return resultado.toString();
        }
    }

    //Ejercicios Examen
    private String mostrarRecursivo(NodoCircular<T> x, NodoCircular<T> referencia){
        if(x.getSig() == referencia){
            return x.getInfo() + "";
        }
        return x.getInfo() + " " + mostrarRecursivo(x.getSig(), referencia);
    }

    public String mostrarListaRecursivo(){
        return mostrarRecursivo(inicio, inicio);
    }

    public T eliminarX(T x){
        if(inicio == null){
            System.out.println("Lista vacia");
            return null;
        }

        NodoCircular<T> actual = inicio;
        NodoCircular<T> anterior = null;
        if(inicio.getInfo().equals(x)){
            T dato = inicio.getInfo();

            if(inicio.getSig() == inicio){
                inicio = null;
            } else{
                NodoCircular<T> ultimo = inicio;
                while(ultimo.getSig() != inicio){
                    ultimo = ultimo.getSig();
                }

                inicio = inicio.getSig();
                ultimo.setSig(inicio);
            }
            return dato;
        }

        anterior = actual;
        actual = actual.getSig();
        while(actual != inicio){
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
        int posicion = 0;

        if(inicio == null){
            return -1;
        }

        NodoCircular<T> actual = inicio;
        while(actual != null){
            if(actual.getInfo().equals(x)){
                return posicion;
            }
            actual = actual.getSig();
            posicion++;
        }
        return -1;
    }

    public T eliminaPosicion(int posicion){
        if(inicio == null || posicion < 0){
            return null;
        }

        NodoCircular<T> actual = inicio;
        int index = 0;
        if(posicion == 0){
            T dato = actual.getInfo();
            if(actual.getSig() == inicio){
                inicio = null;
            } else{
                NodoCircular<T> ultimo = inicio;
                while(ultimo.getSig() != inicio){
                    ultimo = ultimo.getSig();
                }
                inicio = actual.getSig();
                ultimo.setSig(inicio);
            }
            return dato;
        }

        NodoCircular<T> anterior = null;
        while(actual != null && index < posicion){
            anterior = actual;
            actual = actual.getSig();
            index++;
        }

        if(actual == null){
            return null;
        }

        T dato = actual.getInfo();
        anterior.setSig(actual.getSig());
        return dato;
    }

    public void ordenarLista(){
        if(inicio == null || inicio.getSig() == inicio){
            return;
        }

        boolean intercambio;
        do{
            intercambio = false;
            NodoCircular<T> actual = inicio;
            while(actual.getSig() != inicio){
                NodoCircular<T> siguiente = actual.getSig();
                if (((Comparable<T>) actual.getInfo()).compareTo(siguiente.getInfo()) > 0) {
                    T temp = actual.getInfo();
                    actual.setInfo(siguiente.getInfo());
                    siguiente.setInfo(temp);
                    intercambio = true;
                }
                actual = actual.getSig();
            }
        }while(intercambio);
    }

    public void insertaEnPosicion(T dato, int posicion){
        NodoCircular<T> n = new NodoCircular<>(dato, null);
        if(inicio == null && posicion == 0){
            inicio = n;
            n.setSig(n);
            return;
        }

        NodoCircular<T> actual = inicio;
        int index = 0;
        if(posicion == 0){
            n.setSig(inicio);
            NodoCircular<T> ultimo = inicio;
            while(ultimo.getSig() != inicio){
                ultimo = ultimo.getSig();
            }
            ultimo.setSig(n);
            inicio = n;
            return;
        }

        while(actual != null && index < posicion - 1){
            actual = actual.getSig();
            index++;
            if(actual == inicio){
                System.out.println("Fuera de rango");
                return;
            }
        }
        n.setSig(actual.getSig());
        actual.setSig(n);
    }
}
