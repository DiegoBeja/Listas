public class ListaDoble <T>{
    private NodoDoble<T> inicio;

    public ListaDoble(){
        inicio = null;
    }

    public void insertarInicio(T dato){
        NodoDoble<T> n = new NodoDoble<>();
        n.setInfo(dato);
        n.setSig(inicio);
        n.setAnt(null);
        if(inicio != null){
            inicio.setAnt(n);
        }
        inicio = n;
    }

    public void insertarFinal(T dato){
        NodoDoble<T> n = new NodoDoble<>();
        n.setInfo(dato);
        n.setSig(null);
        if(inicio == null){
            n.setAnt(inicio);
            inicio = n;
        } else{
            NodoDoble<T> r = inicio;
            while(r.getSig() != null){
                r = r.getSig();
            }
            r.setSig(n);
            n.setAnt(r);
        }
    }

    public T eliminarInicio(){
        if(inicio == null){
            System.out.println("Lista vacia");
            return null;
        }

        T dato = inicio.getInfo();

        if(inicio.getSig() == null){
            inicio = null;
        } else {
            inicio = inicio.getSig();
            inicio.setAnt(null);
        }
        return dato;
    }

    public T eliminarFinal(){
        if(inicio == null){
            System.out.println("Lista vacia");
            return null;
        }

        if(inicio.getSig() == null){
            inicio = null;
            T dato = inicio.getInfo();
            return dato;
        } else{
            NodoDoble<T> r = inicio;
            while(r.getSig() != null){
                r = r.getSig();
            }
            T dato = r.getInfo();
            r.getAnt().setSig(null);
            return dato;
        }
    }

    public void recorrer(){
        if(inicio == null){
            System.out.println("Lista vacia");
        } else{
            NodoDoble<T> r = inicio;
            while(r != null){
                System.out.print(r.toString());
                r = r.getSig();
            }
        }
    }

    //Ejercicios examen
    private String mostrarRecursivo(NodoDoble<T> x){
        if(x == null){
            return "";
        }
        return x.getInfo() + " " + mostrarRecursivo(x.getSig());
    }

    public String mostrarListaRecursivo(){
        return mostrarRecursivo(inicio);
    }

    public T eliminaX(T x){
        if(inicio == null){
            System.out.println("Lista vacia");
            return null;
        }

        if(inicio.getInfo().equals(x)){
            T dato = inicio.getInfo();
            inicio = inicio.getSig();
            if(inicio != null){
                inicio.setAnt(null);
            }
            return dato;
        }

        NodoDoble<T> actual = inicio.getSig();
        while(actual != null){
            if(actual.getInfo().equals(x)){
                T dato = actual.getInfo();
                if(actual.getSig() != null){
                    actual.getSig().setAnt(actual.getAnt());
                }
                if(actual.getAnt() != null){
                    actual.getAnt().setSig(actual.getSig());
                }
                return dato;
            }
            actual = actual.getSig();
        }

        return null;
    }

    public int buscar(T x){
        int posicion = 0;

        if(inicio.getInfo().equals(x)){
            return posicion;
        }

        NodoDoble<T> actual = inicio;
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
        int index = 1;
        if(inicio == null || posicion < 0){
            return null;
        }

        if(posicion == 0){
            T dato = inicio.getInfo();
            inicio = inicio.getSig();
            if(inicio != null) {
                inicio.setAnt(null);
            }
            return dato;
        }

        NodoDoble<T> actual = inicio.getSig();
        while(actual != null){
            if(index == posicion){
                T dato = actual.getInfo();
                if(actual.getSig() != null){
                    actual.getSig().setAnt(actual.getAnt());
                }
                if(actual.getAnt() != null){
                    actual.getAnt().setSig(actual.getSig());
                }
                return dato;
            }
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
           NodoDoble<T> actual = inicio;

           while(actual.getSig() != null){
               NodoDoble<T> siguiente = actual.getSig();

               if(((Comparable<T>) actual.getInfo()).compareTo(siguiente.getInfo()) > 0){
                   if(actual.getAnt() != null){
                       actual.getAnt().setSig(siguiente);
                   } else{
                       inicio = siguiente;
                   }

                   if(siguiente.getSig() != null){
                       siguiente.getSig().setAnt(actual);
                   }

                   actual.setSig(siguiente.getSig());
                   siguiente.setAnt(actual.getAnt());
                   siguiente.setSig(actual);
                   actual.setAnt(siguiente);

                   intercambio = true;
               } else{
                   actual = actual.getSig();
               }
           }
        }while(intercambio);
    }

    public void insertaEnPosicion(T dato, int posicion) {
        NodoDoble<T> n = new NodoDoble<>();

        if (posicion == 0) {
            n.setInfo(dato);
            n.setSig(inicio);
            if (inicio != null) {
                inicio.setAnt(n);
            }
            inicio = n;
            return;
        }

        NodoDoble<T> actual = inicio;
        int index = 1;
        while (actual != null && index < posicion - 1) {
            actual = actual.getSig();
            index++;
        }
        if (actual == null) {
            System.out.println("Fuera de rango");
            return;
        }

        n.setSig(actual.getSig());
        n.setAnt(actual);
        if(actual.getSig() != null){
            actual.getSig().setAnt(n);
        }
        actual.setSig(n);
    }

}
