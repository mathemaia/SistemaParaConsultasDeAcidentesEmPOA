package Listas;

/**
 * Classe que implementa uma lista encadeada (alocação dinâmica).
 * @author Matheus Maia
 * @version 02-10-2022
 */

public class ListaDeAcidentes {
    /**
     * Classe interna Nodo. Contém um elemento e uma referência para o próximo.
     */
    private static class Acidente {
        // Referência para o próximo nodo.
        private Acidente proximo;
        // Dados do acidente.
        private String data;
        private String hora;
        private int idade;
        private String sexo;
        private String sitVitima;
        private String log1;
        private String tipoAcid;
        private int auto;
        private int taxi;
        private int onibusUrb;
        private int onibusMet;
        private int onibusInt;
        private int caminhao;
        private int moto;
        private int carroca;
        private int bicicleta;
        private int outro;
        private int lotacao;
        private String diaSem;
        private String periodoDia;
        private String fxEt;
        private String tipoVeic;

        /**
         * Construtor.
         * @param proximo Nodo seguinte.
         * @param data Data em que ocorreu o acidente.
         * @param hora Hora em que ocorreu o acidente.
         * @param idade Idade da vítima.
         * @param sexo Sexo da vítima.
         * @param sitVitima Informação da condição da vitima.
         * @param log1 Nomo do logradouro onde ocorreu o acidente.
         * @param tipoAcid Informação descritiva do tipo de acidente.
         * @param auto Número de veículos do típo automóvel envolvidos.
         * @param taxi Número de táxis envolvidos no acidente.
         * @param onibusUrb Número de ônibus urbanos envolvidos no acidente.
         * @param onibusMet Número de ônibus metropolitanos envolvidos no acidente.
         * @param onibusInt Número de ônibus interurbanos envolvidos no acidente.
         * @param caminhao Número de veículos do tipo caminhão envolvidos no acidente.
         * @param moto Número de motocicletas envolvidas no acidente.
         * @param carroca Número de carroças envolvidas no acidente.
         * @param bicicleta Número de bicicletas envolvidas no acidente.
         * @param outro Número de outros veículos envolvidos no acidente
         * @param lotacao Número de veículos do tipo lotações envolvidas no acidente.
         * @param diaSem Dia da semana em que ocorreu o acidente.
         * @param periodoDia Período do dia em que ocorreu o acidente.
         * @param fxEt Faixa etária da vítima.
         * @param tipoVeic Informação descritiva do tipo de veículo onde encontrava-se a vítima naquele acidente.
         */
        public Acidente(Acidente proximo, String data, String hora, int idade, String sexo, String sitVitima,
                        String log1, String tipoAcid, int auto, int taxi, int onibusUrb, int onibusMet, int onibusInt,
                        int caminhao, int moto, int carroca, int bicicleta, int outro, int lotacao, String diaSem,
                        String periodoDia, String fxEt, String tipoVeic) {
            this.proximo = proximo;
            this.data = data;
            this.hora = hora;
            this.idade = idade;
            this.sexo = sexo;
            this.sitVitima = sitVitima;
            this.log1 = log1;
            this.tipoAcid = tipoAcid;
            this.auto = auto;
            this.taxi = taxi;
            this.onibusUrb = onibusUrb;
            this.onibusMet = onibusMet;
            this.onibusInt = onibusInt;
            this.caminhao = caminhao;
            this.moto = moto;
            this.carroca = carroca;
            this.bicicleta = bicicleta;
            this.outro = outro;
            this.lotacao = lotacao;
            this.diaSem = diaSem;
            this.periodoDia = periodoDia;
            this.fxEt = fxEt;
            this.tipoVeic = tipoVeic;
        }
    }

    // Referência para o primeiro elemento da lista encadeada.
    private Acidente head;
    // Referência para o último elemento da lista encadeada.
    private Acidente tail;
    // Contador de elementos.
    private int count;

    /**
     * Construtor.
     */
    public ListaDeAcidentes() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    /**
     * Valor booleano para o estado de tamanho atual da lista - se está vazia ou não.
     * @return true ou false
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Informa o tamanho atual da lista.
     * @return tamanho da lista.
     */
    public int size() {
        return this.count;
    }

    /**
     * Esvazia a lista e retorna aos seus valores padrão.
     */
    public void clear() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    /**
     * Adiciona elementos na posição passada como parâmentro.
     * @param indice Posição que o nodo Acidente será inserido na lista.
     * @param data Data em que ocorreu o acidente.
     * @param hora Hora em que ocorreu o acidente.
     * @param idade Idade da vítima.
     * @param sexo Sexo da vítima.
     * @param sitVitima Informação da condição da vitima.
     * @param log1 Nomo do logradouro onde ocorreu o acidente.
     * @param tipoAcid Informação descritiva do tipo de acidente.
     * @param auto Número de veículos do típo automóvel envolvidos.
     * @param taxi Número de táxis envolvidos no acidente.
     * @param onibusUrb Número de ônibus urbanos envolvidos no acidente.
     * @param onibusMet Número de ônibus metropolitanos envolvidos no acidente.
     * @param onibusInt Número de ônibus interurbanos envolvidos no acidente.
     * @param caminhao Número de veículos do tipo caminhão envolvidos no acidente.
     * @param moto Número de motocicletas envolvidas no acidente.
     * @param carroca Número de carroças envolvidas no acidente.
     * @param bicicleta Número de bicicletas envolvidas no acidente.
     * @param outro Número de outros veículos envolvidos no acidente
     * @param lotacao Número de veículos do tipo lotações envolvidas no acidente.
     * @param diaSem Dia da semana em que ocorreu o acidente.
     * @param periodoDia Período do dia em que ocorreu o acidente.
     * @param fxEt Faixa etária da vítima.
     * @param tipoVeic Informação descritiva do tipo de veículo onde encontrava-se a vítima naquele acidente.
     */
    public void add(int indice, String data, String hora, int idade, String sexo, String sitVitima,
                    String log1, String tipoAcid, int auto, int taxi, int onibusUrb, int onibusMet, int onibusInt,
                    int caminhao, int moto, int carroca, int bicicleta, int outro, int lotacao, String diaSem,
                    String periodoDia, String fxEt, String tipoVeic) {
        Acidente aux = new Acidente(null, data, hora, idade, sexo, sitVitima, log1, tipoAcid, auto, taxi, onibusUrb,
                onibusMet, onibusInt, caminhao, moto, carroca, bicicleta, outro, lotacao, diaSem, periodoDia, fxEt, tipoVeic);

        // Lança exceção se o índice for inválido.
        if (indice < 0 || indice > this.count)
            throw new IndexOutOfBoundsException("Indice invalido!");

        // Se o índice for a primeira posição...
        if (indice == 0) {
            // ...e a lista estiver vazia:
            if (this.head == null) {
                this.tail = aux;
            // ...e a lista não estiver vazia:
            } else {
                aux.proximo = head;
            }
            this.head = aux;
        // Se o índice for a última posição:
        } else if (indice == this.count) {
            this.tail.proximo = aux;
            this.tail = aux;
        // Se o índice estiver no meio da lista.
        } else {
            Acidente ant = head;
            for (int i = 0; i < indice; i++) {
                ant = ant.proximo;
            }
            aux.proximo = ant.proximo;
            ant.proximo = aux;
        }

        this.count++;
    }

    /**
     * Retorna o elemento de indice passado como argumento.
     * @param indice indice do elemento a ser retornado.
     * @return elemento a ser retornado.
     */
    public String get(int indice) {
        // Lança uma exceção se o indice passado for inválido.
        if (indice < 0 || indice >= this.count)
            throw new IndexOutOfBoundsException("Indice invalido!");

        // Retorna o tail se o indice for o deste.
        if (indice == this.count - 1)
            return this.tail.infos;

        // Procura pelo indice passado.
        Acidente aux = this.head;
        for (int i = 0; i < indice; i++) {
            aux = aux.proximo;
        }

        return aux.infos;
    }

    /**
     * Remove a primeira aparição do elemento na lista.
     * @param infos elemento a ser removido.
     */
    public void remove(String[] infos) {
        // Se a lista estiver vazia:
        if (this.count == 0)
            throw new ListaVaziaErro("Lista vazia!");


        // Se o elemento for o primeiro da lista:
        if (Arrays.equals(this.head.infos, infos)) {
            this.head = this.head.proximo;
            // Se a lista conter apenas um elemento:
            if (this.count == 1) this.tail = null;
            this.count--;
        }

        // Percorre a lista até encontrar o elemento.
        Acidente aux = this.head.proximo;
        Acidente ant = this.head;
        while (aux != null) {
            // Se o elemento a ser removido foi encontrado...
            if (Arrays.equals(aux.infos, infos)) {
                // ...e o elemento for o último.
                if (aux == this.tail) {
                    this.tail = ant;
                    tail.proximo = null;
                // ...e o elemento estiver no meio da lista.
                } else {
                    assert ant != null;
                    ant.proximo = aux.proximo;
                }
                this.count--;
            }

            assert ant != null;
            ant = ant.proximo;
            aux = aux.proximo;
        }
        this.count--;
    }

    /**
     * Remove o elemento da posição passada como parâmetro.
     * @param indice indice do elemento a ser removido.
     * @return elemento passado como parâmetro.
     */
    public String[] removeByIndex(int indice) {
        // Lança uma exceção se o indice for inválido.
        if (indice < 0 || indice > this.count)
            throw new IndexOutOfBoundsException("Indice invalido!");

        // Se o elemento a ser removido for o primeiro.
        if (indice == 0) {
            String[] infos = head.infos;
            this.head = this.head.proximo;

            // Se houver apenas 1 elemento na lista.
            if (count == 1) {
                this.tail = null;
            }
            this.count--;
            return infos;
        }

        // Se o elemento for o último ou estiver no meio da lista.
        Acidente aux = this.head;
        Acidente ant = null;
        for (int i = 0; i < indice; i++) {
            ant = aux;
            aux = aux.proximo;
        }
        if (aux == this.tail) {
            this.tail = ant;
            this.tail.proximo = null;
        } else {
            ant.proximo = aux.proximo;
        }

        this.count--;
        return aux.infos;
    }

    /**
     * Retorna o indice da primeira aparição do elemento passado como parâmetro.
     * @param infos elemento a ser buscado.
     * @return indice do elemento ou -1 se ele não existir.
     */
    public int indexOf(String[] infos) {
        Acidente aux = this.head;
        int indice = 0;

        // Procura pelo elemento na lista.
        for (int i = 0; i < this.count; i++) {
            if (Arrays.equals(aux.infos, infos)) return i;

            aux = aux.proximo;
        }

        return -1;
    }

    /**
     * Procura o infos passado como parâmetro e retorna um valor booleano.
     * @param infos infos a ser procurado.
     * @return true ou false.
     */
    public boolean contains(String[] infos) {
        Acidente aux = this.head;

        for (int i = 0; i < this.count; i++) {
            if (Arrays.equals(aux.infos, infos)) return true;
            aux = aux.proximo;
        }

        return false;
    }

    /**
     * Conta o número de ocorrências do elemento passado como parâmetro.
     * @param elemento elemento a ser contabilizado.
     * @return quantidade de vezes que ele aparece na lista.
     */
    public int countOccurrences(String[] elemento) {
        Acidente aux = this.head;
        int count = 0;

        for (int i = 0; i < this.count; i++) {
            if (Arrays.equals(aux.infos, elemento)) count++;
            aux = aux.proximo;
        }

        return count;
    }

    /**
     * Retorna um vetor que contém os elementos da lista original entre os indices passados como argumento.
     * @param from indice inicial da lista.
     * @param to indice final da lista.
     * @return sublista.
     */
    public Integer[] sublist(int from, int to) {
        // Se o tamanho for negativo ou zero lança uma exceção.
        if ((to <= from) || (to > this.count) || (from < 0))
            throw new IndexOutOfBoundsException("Indice invalido.");

        Acidente aux = this.head;
        Integer[] sublista = new Integer[to - from];
        int count = 0;

        for (int i = 0; i < this.count; i++) {
            if ((i >= from) && (i < to)) {
                sublista[count] = aux.infos;
                count++;
            }
            aux = aux.proximo;
        }

        return sublista;
    }

    /**
     * Retorna a lista em formato string.
     * @return lista em formato String.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        Acidente aux = this.head;

        while (aux != null) {
            s.append(Arrays.toString(aux.infos)).append(" ");
            aux = aux.proximo;
        }

        return s.toString();
    }
}
