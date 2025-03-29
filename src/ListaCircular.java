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

}
