public class NodoDoble <T>{
    private T info;
    private NodoDoble<T> sig;
    private NodoDoble<T> ant;

    public NodoDoble(){

    }

    public NodoDoble(T info, NodoDoble<T> ant, NodoDoble<T> sig){
        this.info = info;
        this.ant = ant;
        this.sig = sig;
    }

    public void setSig(NodoDoble<T> sig){
       this.sig = sig;
    }

    public NodoDoble<T> getSig(){
        return sig;
    }

    public void setAnt(NodoDoble<T> ant){
        this.ant = ant;
    }

    public NodoDoble<T> getAnt(){
        return ant;
    }

    public void setInfo(T info){
        this.info = info;
    }

    public T getInfo(){
        return info;
    }

    @Override
    public String toString(){
        return info + " ";
    }
}
