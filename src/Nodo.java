public class Nodo <T>{
    private T info;
    private Nodo sig;

    public Nodo(T info){
        this.info = info;
        this.sig = null;
    }

    public Nodo(){
        this.info = null;
        this.sig = null;
    }

    public Nodo(T info, Nodo sig){
        this.info = info;
        this.sig = sig;
    }

    public void setInfo(T info){
        this.info = info;
    }

    public T getInfo(){
        return info;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public Nodo getSig(){
        return sig;
    }
}
