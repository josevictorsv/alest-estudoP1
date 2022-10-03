package br.pucrs.adt;

public class ListSimpleLinkedFull<E> implements ListTAD<E>{

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
        Node aux, ant, prox;
        E auxD = null;
        int i;

        if((pos >= 0) && (pos <= qtdElem)){  //SE A POSIÇAO ESTIVER ENTRE 0 E QTD ELEMENTOS
            if(pos == 0){                       //SE POS = 0
                auxD = refHead.getElement();    //COLOCA O ELEMENTO DE REFHEAD EM AUXD
                refHead = refHead.getNext();    //SUBSTITUI O REFHEAD PELA REFERENCIA DO PROXIMO NODO TORNANDO ELE INICIAL
            }
            else{                           //SE FOR MAIOR Q 0
                ant = aux = refHead;                      //CRIA AUXILIAR
                for (i = 1 ; i <= pos; i++){              //PERCORRE A LISTA ATE A POSIÇAO
                    ant = aux;                            //ANTERIOR VIRANDO O AUX
                    aux = aux.getNext();                  //E AUX VIRANDO O PROX
                }
                                                    //APOS PERCORRER E CHEGAR NA POSIÇAO
                auxD = aux.getElement();            //COLOCA O ELEMENTO DE AUX EM AUXD
                prox = aux.getNext();            //TRANSFORMA O PROX NO NEXT DO AUX

                ant.setNext(prox);              //SETA O NEXT DO ANT COM A REFERENCIA DO PROX
            }
        }


        return null;
    }

    @Override
    public E remove(E element) {
        E res = null;
        Node aux, ant;                      //AUXILIARES

        ant = aux = refHead;                      //AUXILIARES IGUAIS A REFHEAD
        while( aux != null && !aux.getElement().equals(element)){      //ENQUANTO AUX FOR DIFERENTE DE NULO E DO ELEMENTO
            ant = aux;                                                 //PERCORRE A LISTA
            aux = aux.getNext();
        }
                                            //LISTA PERCORRIDA ATE O ELEMENTO ENCONTRADO OU FIM DELA
        if(aux != null) {                    //SE AUX NAO FOR NULO
            res = aux.getElement();            //COLOCA O ELEMENTO DE AUX EM RES
            qtdElem--;                          //DIMINUI QTD DE ELEMENTO

            if (qtdElem == 0)                           //VERIFICA SE A QTD É 0
                refHead = null;                         //SE FOR COLOCA O INICIO COMO NULL

            else {                                       //SENAO FOR
                if (aux == refHead)                 //SE AUX É IGUAL AO INICIO
                    refHead = refHead.getNext();    //TRANSFORMA O INICIAL NO PROXIMO

                else {                           //SE AUX DIFERENTE DO INICIAL
                    ant.setNext(aux.getNext());     //DETERMINA O ANT COMO O PROXIMO APAGANDO O ELEMENTO DE ANT

                }

            }
        }
        return res;
    }



    @Override
    public E get(int pos) {
            E res = null;
            Node aux, ant;             //AUXILIAR
            int i;

            if ((pos >= 0) && (pos < qtdElem))      //SE POS ESTA DENTRO DA QDT DA LISTA
            {
                if(refHead != null)     //SE O INICIAL NAO ESTIVER VAZIO
                {
                    aux = refHead;                      //AUXILIAR IGUAL AO INICIAL
                    for(i = 1 ; i <= pos; i++)          //PERCORRE A LISTA ATE A POSIÇAO
                        aux = aux.getNext();

                    res = aux.getElement();            //COLOCA O ELEMENTO DE AUX EM RES
                }
            }
            else
                throw(new IndexOutOfBoundsException());

            return res;          //RETORNA RES MOSTRANDO O ELEMENTO NA POSIÇAO DA LISTA COLOCADA NO PARAMETRO
        }

    @Override
    public void set(int index, E element) {
        Node aux = refHead;     //CRIA AUXILIAR COMO INICIAL

        for(int i = 1 ; i <= index; i++)
            aux = aux.getNext();           // PERCORRE A LISTA ATE A POSIÇAO

        if(aux != null)                   //SE AUX NAO FOR NULO
            aux.setElement(element);        //SETA ELEMENTO NA POSIÇAO

        else
            throw new IllegalArgumentException();
    }

    @Override
    public E search(E element) {

        Node aux = refHead , ant;

        while( aux != null && !aux.getElement().equals(element)){      //ENQUANTO AUX FOR DIFERENTE DE NULO E DO ELEMENTO
            ant = aux;                                                 //PERCORRE A LISTA
            aux = aux.getNext();
        }

        if(aux != null){
            return aux.getElement();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        if(refHead == null){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return qtdElem;
    }

    @Override
    public int count(E element) {
        int cont = 0;
        Node aux = refHead, ant;

        for(int i = 0; i < qtdElem; i++){
            if(aux.getElement().equals(element)){  //VERIFICA SE O ELEMENTO É IGUAL AO QUE ESTA NO NODO
                cont++;             //SE FOR CONTA 1
            }
            ant = aux;                                                 //PERCORRE A LISTA
            aux = aux.getNext();
        }
        return cont;
    }

    @Override
    public void clean() {

    }

    @Override
    public void addFirst(E element) {
        Node novo = new Node(element);

        novo.setNext(refHead);

        refHead = novo;

    }

    @Override
    public void addLast(E element) {
        Node novo = new Node(element);

        Node aux = refHead, ant;

        while(aux.getNext() != null){
            ant = aux;
            aux = aux.getNext();
        }

        aux.setNext(novo);
    }

    @Override
    public E removeFirst() {
        E res = null;
        Node aux;

        if(refHead == null){
            return null;
        }
        else {
            res = refHead.getElement();
            aux = refHead.getNext();

            refHead = aux;
            return res;
        }

    }

    @Override
    public E removeLast() {
        E auxD = null;
        Node aux;

        if(refHead != null)
        {
            if(refHead.getNext() == null)
            {
                auxD = refHead.getElement();
                refHead = null;
            }

            else
            {
                aux = refHead;
                while(aux.getNext().getNext() != null)
                    aux = aux.getNext();

                auxD = aux.getNext().getElement();
                aux.setNext(null);
            }
            qtdElem--;
        }
        return auxD;
    }

    @Override
    public E getFirst() {
        return refHead.getElement();
    }



    @Override
    public E getLast() {
        Node aux = refHead, ant;
       for(int i = 0 ; i < qtdElem; i++){
           ant = aux;
           aux = aux.getNext();
       }
       return aux.getElement();
    }
}
