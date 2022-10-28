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
    private final Rua headStreet;
    private final Rua tailStreet;

    /**
     * Classe interna Nodo. Contém um elemento, uma referência para o Nodo anterior outra para o próximo
     */
    private static class Rua {
        private Integer rua;
        private Rua nextStreet;
        private Rua prevStreet;

        public Rua(Integer elemento) {
            this.rua = elemento;
            this.nextStreet = null;
            this.prevStreet = null;
        }
    }

    /**
     * Construtor.
     */
    public ListaDeRuas() {
        this.headStreet = new Rua(null);
        this.tailStreet = new Rua(null);
        this.headStreet.nextStreet = this.tailStreet;
        this.tailStreet.prevStreet = this.headStreet;
        this.count = 0;
    }

    /**
     * Adiciona um elemento à última posição da lista.
     * @param elemento elemento a ser inserido.
     */
    public void add(Integer elemento) {
        Rua aux = new Rua(elemento);

        // Conecta o nodo na última posição da lista.
        aux.nextStreet = this.tailStreet;
        aux.prevStreet = this.tailStreet.prevStreet;
        this.tailStreet.prevStreet.nextStreet = aux;
        this.tailStreet.prevStreet = aux;

        this.count++;
    }

    /**
     * Adiciona um elemento por indice.
     * @param elemento elemento a ser inserido na lista.
     * @param indice indice do elemento a ser inserido.
     */
    public void set(int indice, Integer elemento) {
        // Lança uma exceção se o indice passado for inválido.
        if ((indice > this.count) || (indice < 0))
            throw new IndexOutOfBoundsException("Indice inválido!");

        // Se o índice for igual ao tamanho atual da lista, adiciona no fim.
        if (this.count == indice) add(elemento);

        // Percorre a lista até o índice passado.
        Rua aux = new Rua(elemento);
        Rua ptr = getNode(indice);

        // Linka o novo Nodo como o próximo do Nodo de índice passado.
        ptr.prevStreet.nextStreet = aux;
        aux.prevStreet = ptr.prevStreet;
        ptr.prevStreet = aux;
        aux.nextStreet = ptr;

        this.count++;
    }

    /**
     * Retorna o Nodo do índice passado como parâmetro sem removê-lo.
     *
     * @param indice índice do nodo.
     * @return Nodo.
     */
    public Rua getNode(int indice) {
        // Lança um erro caso o parâmetro passado seja negativo ou maior/igual ao número de elementos.
        if ((indice < 0) || (indice >= count))
            throw new IndexOutOfBoundsException();

        // Percorre a lista até o índice passado como parâmentro.
        Rua aux;
        if (indice <= (this.count / 2)) {
            aux = this.headStreet.nextStreet;
            for (int i = 0; i < indice; i++) {
                aux = aux.nextStreet;
            }
        } else {
            aux = this.tailStreet.prevStreet;
            for (int i = count - 1; i > indice; i--) {
                aux = aux.prevStreet;
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

        return getNode(indice).rua;
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
        Rua aux = getNode(indice);
        aux.prevStreet.nextStreet = aux.nextStreet;
        aux.nextStreet.prevStreet = aux.prevStreet;

        // Retorna o elemento.
        this.count--;
        return aux.rua;
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
        Rua aux = this.headStreet.nextStreet;
        boolean contem = false;

        // Começa a iteração no primeiro elemento e termina quando alcançar o trailer.
        while (aux != this.tailStreet) {
            if (Objects.equals(aux.rua, elemento)) {
                contem = true;
                break;
            }
            aux = aux.nextStreet;
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
            Rua aux = this.headStreet.nextStreet;
            int idx = 0;

            // Itera a lista até encontrar o trailer.
            for (int i = 0; i < count; i++) {
                if (Objects.equals(aux.rua, elemento)) {
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
        this.headStreet.nextStreet = this.tailStreet;
        this.tailStreet.prevStreet = this.headStreet;
        this.count = 0;
    }

    /**
     * Imprime no terminal todos os elementos da lista.
     * @return todos os elementos da lista.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Rua aux = headStreet.nextStreet;
        for (int i = 0; i < this.count; i++) {
            s.append(aux.rua.toString());
            s.append("\n");
            aux = aux.nextStreet;
        }

        return s.toString();
    }

    /**
     * Retorna a quantidade vezes que o elemento passado como parâmetro aparece na lista.
     * @param elemento elemento a ser contabilizado.
     * @return quantidade de vezes que o elemento aparece.
     */
    public int countOccurrences(Integer elemento) {
        Rua aux = headStreet.nextStreet;
        int contador = 0;

        for (int i = 0; i < this.count; i++) {
            if (aux.rua.equals(elemento)) {
                contador++;
            }
            aux = aux.nextStreet;
        }

        return contador;
    }
}
