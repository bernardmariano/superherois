package org.devinhouse.superherois.model;

public enum Operacao {

    CADASTRAR_HEROI,
    CADASTRAR_VILAO,
    LISTAR,
    SAIR;

    public static Operacao obterPeloCodigo(int codigo){
        Operacao[] operacoes = Operacao.values(); // "Operacao.values()" me retorna um array de operaçoes.
        return operacoes[codigo-1];
    }

}
