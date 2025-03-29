public class NodoCircular <T>{
    private T info;
    private NodoCircular<T> sig;

    public NodoCircular(T info, NodoCircular sig){
        this.info = info;
        this.sig = sig;
    }

    public NodoCircular(){

    }

    public T getInfo(){
        return info;
    }

    public void setInfo(T info){
        this.info = info;
    }

    public NodoCircular<T> getSig(){
        return sig;
    }

    public void setSig(NodoCircular<T> sig) {
        this.sig = sig;
    }

    @Override
    public String toString(){
        return "Info:" + info;
    }
}
