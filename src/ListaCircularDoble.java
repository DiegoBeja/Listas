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
}