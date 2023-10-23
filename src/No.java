public class No {
    public Object valor;
    public No proximo;
    public No anterior;

    public No(Object valor) {
        this.valor = valor;
        proximo = null;
        anterior = null;
    }
}
