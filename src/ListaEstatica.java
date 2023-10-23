public class ListaEstatica {
    private Object[] v;
    private int capacidade;
    private int tamanho;

    public ListaEstatica() {
        capacidade = 10;
        v = new Object[capacidade];
        tamanho = 0;
    }

    public ListaEstatica(int n) {
        capacidade = n;
        v = new Object[capacidade];
        tamanho = 0;
    }

    public int tamanho() {
        return tamanho;
    }

    public void adiciona(Object objeto) {
        if (tamanho<v.length) {
            v[tamanho] = objeto;
            tamanho++;
        } else {
            Object[] aux = new Object[v.length*2];
            for (int i=0;i<v.length;i++) {
                aux[i] = v[i];
            }
            v = aux;
            v[tamanho] = objeto;
            tamanho++;
        }
    }

    public void adiciona(int indice, Object objeto) {
        if (indice>tamanho) {
            throw new IndexOutOfBoundsException();
        } else {
            v[indice] = objeto;
        }
    }

    public void limpar() {
        v = new Object[capacidade];
        tamanho = 0;
    }

    public boolean contem(Object objeto) {
        for (int i=0;i<tamanho;i++) {
            if (objeto.equals(v[i])) {
                return true;
            }
        }
        return false;
    }

    public void remover(Object objeto) {
        boolean removido = false;
        for (int i=0;i<tamanho;i++) {
            if (!removido) {
                if (objeto == v[i]) {
                    v[i] = null;
                    removido = true;
                    continue;
                }
            } else {
                v[i-1] = v[i];
            }
        }
        tamanho--;
        if (!removido) {
            System.out.println("Objeto não encontrado");
        }
    }

    public void remover(int indice) {
        if (indice>tamanho) {
            throw new IndexOutOfBoundsException();
        } else {
            v[indice] = null;
        }
        for (int i=indice;i<tamanho-1;i++) {
            v[i] = v[i+1];
        }
        tamanho--;
    }

    public Object get(int indice) {
        return v[indice];
    }

    public int indexOf(Object objeto) {
        for (int i=0;i<tamanho;i++) {
            if (objeto == v[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String str = "[ ";
        for (int i=0;i<tamanho;i++) {
            str += v[i] + " ";
        }
        return str + "]";
    }
}
