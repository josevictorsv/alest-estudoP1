package br.pucrs.adt;

public class ListSimpleLinked<E> implements ListTAD<E>{

    private class Node{                    //Criaçao do Nodo
        private Node refNext;     //Referencia do proximo Nodo
        private E element;      //Elemento do Nodo

        public Node(){
            element = null;
            refNext = null;
        }

        public Node(E e){
            element = e;
            refNext = null;
        }

        public Node(E e, Node next){
            element = e;
            refNext = next;
        }

        public void setElement(E element){
            this.element = element;
        }

        public E getElement(){return element;}

        public void setNext(Node n){refNext = n;}

        public Node getNext(){return refNext;}

    }

    public int qtdElem = 0;
    private Node refHead = null;  //Inicio da lista

    @Override
    public void add(E element) {
        Node novo = new Node((element));
        Node aux , ant;

        if (refHead == null) {        //Se não houver inicial
            refHead = novo;         //Determina o novo elemento como inicial
        }
        else{                           //Se houver inicial
            ant  = aux = refHead;       //

            while(aux != null){       //Roda ate o aux ser nulo = ultimo
                ant = aux;
                aux = aux.getNext();
            }

            ant.setNext(novo);         //Coloca o novo elemento na ultima posição
        }
        qtdElem++;
    }

    public void addAlt(E element) {
        Node novo = new Node(element);  //CRIA UM NODO COM O ELEMENTO ESCOLHIDO
        Node aux;                       //NODO AUXILIAR
        int cont;               //CONTADOR

        if (refHead == null)    //SE O INICIO FOR VAZIO
            refHead = novo;     //DETERMINAR ELEMENTO COMO INICIAL
        else {
            aux = refHead;      //SENAO GUARDA O INICIO NO AUXILIAR

            for (int i = 1; i < qtdElem; i++)   //RODA ATE TERMINAR A QTD DE ELEMENTOS
                aux = aux.getNext();            //TRANSFORMANDO O AUX NO NEXT

            aux.setNext(novo);                  //QUANDO ACABAR FAZ O AUX SETAR O NEXT COMO O ELEMENTO ESCOLHIDO
        }

        qtdElem++;          //AUMENTA A QTD DE ELEMENTOS
    }

    @Override
    public void add(int index, E element) {
        Node ant, novo, prox = null;        //CRIA 3 AUXILIARES
        int i;

        if((index >= 0) && (index <= qtdElem)){     //SE A POSIÇAO FOR MAIOR OU IGUAL A 0 E MENOR OU IGUAL A QTD
            novo = new Node(element);               //DE ELEMENTOS CRIA UM NODO COM O ELEMENTO ESCOLHIDO

            if(index == 0){                         //SE A POSIÇAO FOR IGUAL A ZERO
                novo.setNext(refHead);              //DETERMINAR O NEXT DO NODO COMO O ANTIGO INICIAL
                refHead = novo;                     //E TRANSFORMA O INICIAL NO NODO
            }
            else {                                  //SE FOR DIFERENTE DE ZERO
                ant = refHead;                      //DETERMINA O INICIAL COMO ANTERIOR
                for (i = 1; i < index; i++)         //RODA UM FOR O NUMERO DE VEZES BASEADO NA POSIÇAO DESEJADA
                    ant = ant.getNext();            //TRANSFORMANDO O ANTERIOR NO NEXT PARA PERCORRER A LISTA
                                                //CHEGA NA POSIÇAO
                prox = ant.getNext();           //CRIA UMA REFERENCIA DO NEXT DA POS EM PROX
                ant.setNext(novo);              //DETERMINAR O ANT COMO O ELEMENTO ESCOLHIDO
                novo.setNext(prox);              //COLOCA REFERENCIA DO PROX NA LISTA DPS DO ESCOLHIDO
            }

            qtdElem++;   //AUMENTA A QTD DE ELEMENTOS
        }
        else
            throw(new IndexOutOfBoundsException());
    }

    @Override
    public E remove(int pos) {
        return null;
    }

    @Override
    public E remove(E element) {
        return null;
    }

    @Override
    public E get(int pos) {
        return null;
    }

    @Override
    public void set(int index, E element) {

    }

    @Override
    public E search(E element) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int count(E element) {
        return 0;
    }

    @Override
    public void clean() {

    }

    @Override
    public void addFirst(E element) {

    }

    @Override
    public void addLast(E element) {

    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }
}
