package Listas;

import java.util.Objects;

/**
 * Esta é a classe da lista de acidentes.
 * @author matheus maia
 * @version 27-10-2022
 */

public class ListaDeRuas {
    // Contador de elementos.
    private int count;
    // Sentinelas.
    private final Rua head;
    private final Rua tail;

    /**
     * Classe interna Nodo. Contém um elemento, uma referência para o Nodo anterior outra para o próximo
     */
    private static class Rua {
        private ListaDeAcidentes acidentes;
        private Rua next;
        private Rua prev;

        public Rua(ListaDeAcidentes acidentes) {
            this.acidentes = acidentes;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * Construtor.
     */
    public ListaDeRuas() {
        this.head = new Rua(null);
        this.tail = new Rua(null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.count = 0;
    }

    /**
     * Adiciona um elemento à última posição da lista.
     * @param acidentes elemento a ser inserido.
     */
    public void add(ListaDeAcidentes acidentes) {
        Rua aux = new Rua(acidentes);

        // Conecta o nodo na última posição da lista.
        aux.next = this.tail;
        aux.prev = this.tail.prev;
        this.tail.prev.next = aux;
        this.tail.prev = aux;

        this.count++;
    }

    /**
     * Adiciona um elemento (ListaDeAcidentes) por indice.
     * @param acidentes elemento a ser inserido na lista.
     * @param indice indice do elemento a ser inserido.
     */
    public void set(int indice, ListaDeAcidentes acidentes) {
        // Lança uma exceção se o indice passado for inválido.
        if ((indice > this.count) || (indice < 0))
            throw new IndexOutOfBoundsException("Indice inválido!");

        // Se o índice for igual ao tamanho atual da lista, adiciona no fim.
        if (this.count == indice) add(acidentes);

        // Percorre a lista até o índice passado.
        Rua aux = new Rua(acidentes);
        Rua ptr = getRua(indice);

        // Linka o novo Nodo como o próximo do Nodo de índice passado.
        ptr.prev.next = aux;
        aux.prev = ptr.prev;
        ptr.prev = aux;
        aux.next = ptr;

        this.count++;
    }

    /**
     * Retorna o Nodo do índice passado como parâmetro sem removê-lo.
     *
     * @param indice índice do nodo.
     * @return Nodo.
     */
    public Rua getRua(int indice) {
        // Lança um erro caso o parâmetro passado seja negativo ou maior/igual ao número de elementos.
        if ((indice < 0) || (indice >= count))
            throw new IndexOutOfBoundsException();

        // Percorre a lista até o índice passado como parâmentro.
        Rua aux;
        if (indice <= (this.count / 2)) {
            aux = this.head.next;
            for (int i = 0; i < indice; i++) {
                aux = aux.next;
            }
        } else {
            aux = this.tail.prev;
            for (int i = count - 1; i > indice; i--) {
                aux = aux.prev;
            }
        }

        return aux;
    }

    /**
     * Retorna o elemento do índice passado como parâmentro.
     * @param indice posição do elemento.
     * @return elemento de posição índice.
     */
    public Integer get(int indice) {
        // Checa se o índice é válido.
        if ((indice < 0) || (indice >= this.count))
            throw new IndexOutOfBoundsException("Indice invalido!");

        return getRua(indice).acidentes;
    }

    /**
     * Remove o elemento de posição indice.
     * @param indice posição do elemento a ser removido.
     * @return elemento removido.
     */
    public Integer remove(int indice) {
        // Verifica se o index é válido.
        if ((indice < 0) || (indice >= count))
            throw new IndexOutOfBoundsException("Indice invalido!");

        // Se está antes da metade, começa percorrendo pelo header.
        Rua aux = getRua(indice);
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;

        // Retorna o elemento.
        this.count--;
        return aux.acidentes;
    }

    /**
     * Retorna um valor booleano para se a lista está ou não vazia.
     * @return true ou false.
     */
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Retorna o tamanho atual da lista.
     * @return tamanho atual.
     */
    public int size() {
        return this.count;
    }

    /**
     * Retorna um valor booleano para se existe o elemento passado como parâmetro.
     * @param elemento elemento a ser procurado.
     * @return true ou false.
     */
    public boolean contains(Integer elemento) {
        Rua aux = this.head.next;
        boolean contem = false;

        // Começa a iteração no primeiro elemento e termina quando alcançar o trailer.
        while (aux != this.tail) {
            if (Objects.equals(aux.acidentes, elemento)) {
                contem = true;
                break;
            }
            aux = aux.next;
        }
        return contem;
    }

    /**
     * Retorna o indice da primeira aparição do elemento. Caso não exista, retorna -1.
     * @param elemento elemento a ter o indice retornado.
     * @return indice do elemento passado como parâmetro.
     */
    public int indexOf(Integer elemento) {
        if (contains(elemento)) {
            Rua aux = this.head.next;
            int idx = 0;

            // Itera a lista até encontrar o trailer.
            for (int i = 0; i < count; i++) {
                if (Objects.equals(aux.acidentes, elemento)) {
                    idx = i;
                    break;
                }
            }

            return idx;
        }

        return -1;
    }

    /**
     * Esvazia a lista.
     */
    public void clear() {
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.count = 0;
    }

    /**
     * Imprime no terminal todos os elementos da lista.
     * @return todos os elementos da lista.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Rua aux = head.next;
        for (int i = 0; i < this.count; i++) {
            s.append(aux.acidentes.toString());
            s.append("\n");
            aux = aux.next;
        }

        return s.toString();
    }

    /**
     * Retorna a quantidade vezes que o elemento passado como parâmetro aparece na lista.
     * @param elemento elemento a ser contabilizado.
     * @return quantidade de vezes que o elemento aparece.
     */
    public int countOccurrences(Integer elemento) {
        Rua aux = head.next;
        int contador = 0;

        for (int i = 0; i < this.count; i++) {
            if (aux.acidentes.equals(elemento)) {
                contador++;
            }
            aux = aux.next;
        }

        return contador;
    }
}
