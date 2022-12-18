package org.devinhouse.superherois.cli;

import org.devinhouse.superherois.exception.OpcaoInvalidaException;
import org.devinhouse.superherois.model.*;
import org.devinhouse.superherois.repository.PersonagemRepository;

import java.util.List;
import java.util.Scanner;

/**
 * Responsável por prover a interacao com o usuário da aplicaçao.
 */

public class Display {

    public void exibirMenu(){
        System.out.println();
        System.out.println("== MENU ==");
        System.out.println("1 - Cadastrar Heroi");
        System.out.println("2 - Cadastrar Vilao");
        System.out.println("3 - Listar");
        System.out.println("4 - Sair");
        System.out.println();
    }

    public Operacao obterOperacao() throws OpcaoInvalidaException {
        System.out.println("Digite a opcao desejada: ");
        Scanner scanner = new Scanner(System.in);
        int codigoOpcao = scanner.nextInt();


        String entrada = scanner.nextLine();
        try{
            Integer codigo = Integer.valueOf(entrada);
        }catch (NumberFormatException e) {
            System.out.println("Isso nao é numero");
        }


        if (codigoOpcao <= 0 || codigoOpcao > Operacao.values().length){
            throw new OpcaoInvalidaException();
        }

        Operacao operacao = Operacao.obterPeloCodigo(codigoOpcao);
        return operacao;
    }

    public Personagem cadastrar(TipoPersonagem tipo) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome: ");
        String nome = scanner.nextLine();
        System.out.println();
        System.out.println("Informe o super-poder: ");
        String poder = scanner.nextLine();
        System.out.println();
        Personagem personagem;
        if (tipo == TipoPersonagem.HEROI) {
            System.out.println("Informe o nome na vida real: ");
            String outroNome = scanner.nextLine();
            System.out.println();
            personagem = new Heroi(nome, poder, outroNome);
        }else {
            System.out.println("Informe o tempo de prisao: ");
            String prisao = scanner.nextLine();
            System.out.println();
            personagem = new Vilao(nome, poder, Integer.valueOf(prisao));
        }
        return personagem;
    }

    public void exibirMensagem(String msg) {
        System.out.println(msg);
    }

    public void listar(List<Personagem> personagens) {
        for (Personagem personagem : personagens){
            System.out.println(personagem);
        }
    }
}
