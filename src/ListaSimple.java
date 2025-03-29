public class ListaSimple <T>{
    private Nodo inicio;

    public ListaSimple(){
        this.inicio = null;
    }

    public void insertarInicio(T dato){
        Nodo n = new Nodo(dato, inicio);
        inicio = n;
    }

    public void insertarFin(T dato){
        Nodo n = new Nodo(dato);
        if(inicio == null){
            n.setSig(inicio);
            inicio = n;
        } else{
            Nodo r = inicio;
            while(r.getSig() != null){
                r = r.getSig();
            }
            r.setSig(n);
            n.setSig(null);
        }
    }

    public void eliminarInicio(){
        if(inicio == null){
            System.out.println("Lista vacia");
        } else{
            inicio = inicio.getSig();
        }
    }

    public void eliminarFin(){
        if(inicio == null){
            System.out.println("Lista vacia");
        } else{
            if(inicio.getSig() == null){
                inicio = null;
            } else{
                Nodo r = inicio;
                Nodo a = r;
                while(r.getSig() != null){
                   a = r;
                   r = r.getSig();
                }
                a.setSig(null);
            }
        }
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
}
