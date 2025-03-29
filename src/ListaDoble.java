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
                System.out.println(r.toString());
                r = r.getSig();
            }
        }
    }
}
