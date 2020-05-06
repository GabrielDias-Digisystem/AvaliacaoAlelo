package com.alelo.AvaliacaoAlelo.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.alelo.AvaliacaoAlelo.interfaces.Funcionalidades;
import com.alelo.AvaliacaoAlelo.models.Diretor;

public class diretorController implements Funcionalidades {
	String valor = "";
	ArrayList<Diretor> ListaDir = new ArrayList<Diretor>();

	public void MenuDir() {

		do {
			Scanner leitor = new Scanner(System.in);
			valor = "";

			System.out.println("\n*** Menu Diretor ***\n");
			System.out.println("Digite a opção desejada no menu abaixo:\n\n");
			System.out.println("Listar    ................... 1");
			System.out.println("Cadastrar ................... 2");
			System.out.println("Pesquisar ................... 3");
			System.out.println("Excluir   ................... 4");
			System.out.println("Retornar ao Menu Principal .. 0\n");

			Scanner scr = new Scanner(System.in);
			String valorLido = "";

			valor = LerMenu();

			switch (valor) {
			case "1":
				Listar();
				break;
			case "2":
				Cadastro();
				break;
			case "3":
				Pesquisar();
				break;
			case "4":
				Excluir();
				break;
			}
		} while (!valor.equals("0"));
	}

	@Override
	public void Listar() {

		Scanner scr = new Scanner(System.in);
		int maiorValor = 0;

		System.out.println("\n***Diretores Cadastrados***\n");

		if (ListaDir.isEmpty())
			System.out.println("Não há registros");
		else {

			// Percorre a lista de diretores cadastrados
			System.out.println("\n| ID | NOME | ANO DE LANÇAMENTO |");
			int indice = 0;
			for (Diretor diretor : ListaDir) {
				System.out
						.println("\n|" + indice + " - " + diretor.getNome() + " - " + diretor.getDtNascimento() + "|");
				indice++;

			}

		}

	}

	@Override
	public void Pesquisar() {

		String desejaCadastrar = "S";

		do {
			Scanner scr = new Scanner(System.in);
			String valor = "";

			System.out.println("\nPesquisar\n");

			if (ListaDir.isEmpty())
				System.out.println("Não há registros!");
			else {
				System.out.print("Digite o valor que deseja pesquisar: ");
				try {
					valor = scr.nextLine();
				} catch (Exception e) {
					System.out.println("Ocorreu um erro na leitura,tente novamente !");
					continue;
				}

				// Validando o nome inserido.
				if (valor.equals("")) {
					System.out.println("Por favor, preencha o campo!");
					continue;
				}

				// Pesquisando o nome informado.
				boolean Encontrado = false;
				ArrayList<Diretor> DirEncontrado = new ArrayList<Diretor>();
				for (Diretor diretor : ListaDir) {
					if (diretor.getNome().contains(valor) || diretor.getDtNascimento().contains(valor)) {
						Encontrado = true;
						DirEncontrado.add(diretor);
					}

				}

				if (Encontrado == false)
					System.out.println("\nO Diretor(a) informado '" + valor + "' não foi encontrado!\n");
				else {
					System.out.println("\nRegistros\n");

					System.out.println("\n| ID - NOME - DATA DE NASCIMENTO |");
					int indice = 0;
					for (Diretor diretor : DirEncontrado) {
						System.out.println(
								"\n|" + indice + " - " + diretor.getNome() + " - " + diretor.getDtNascimento() + "|");
						indice++;
					}
				}
			}

			do {
				System.out.print("\nDeseja consultar mais? S/N");
				desejaCadastrar = scr.next().toUpperCase();

				// Validando o valor informado.
				if (!desejaCadastrar.equals("S") && !desejaCadastrar.equals("N"))
					System.out.println("Valor Informado inválido");
			} while (!desejaCadastrar.equals("S") && !desejaCadastrar.equals("N"));
		} while (desejaCadastrar.equals("S"));

	}

	@Override
	public void Cadastro() {

		String Valor = "S";

		do {
			Scanner scr = new Scanner(System.in);
			String nome = "";
			String dtNascimento = "";

			System.out.println("\nPor favor, Digite as informações!\n");

			System.out.print("Nome do Diretor: ");
			try {
				nome = scr.nextLine();
			} catch (Exception e) {
				System.out.println("Ocorreu um erro na leitura do Nome. Por favor, tente novamente !");
				continue;
			}

			// Validando o nome.
			if (nome.equals("")) {
				System.out.println("Preencha o campo Nome");
				continue;
			}

			System.out.print("Data de Nascimento: ");
			dtNascimento = scr.nextLine();

			if (dtNascimento.equals("")) {
				System.out.println("Preencha o campo Data de Nascimento");
				continue;
			}

			// Cadastrando o registro informado.
			Diretor diretor = new Diretor();
			diretor.setNome(nome);
			diretor.setDtNascimento(dtNascimento);

			ListaDir.add(diretor);

			do {
				System.out.print("\nDeseja cadastrar mais? S/N");
				Valor = scr.next().toUpperCase();

				// Validando o valor informado.
				if (!Valor.equals("S") && !Valor.equals("N"))
					System.out.println("Valor Informado inválido");
			} while (!Valor.equals("S") && !Valor.equals("N"));
		} while (Valor.equals("S"));
	}

	@Override
	public void Excluir() {
		String desejaCadastrar = "S";

		do {
			Scanner scr = new Scanner(System.in);

			System.out.println("\nExcluir\n");

			if (ListaDir.isEmpty())
				System.out.println("Não há registros!");
			else {
				System.out.println("***Lista de registros cadastrados***\n");

				System.out.println("\n| ID - NOME - DATA DE NASCIMENTO |");

				// Percorre a lista de diretores cadastrados.
				int indice = 0;
				for (Diretor diretor : ListaDir) {
					System.out.println(
							"\n|" + indice + " - " + diretor.getNome() + " - " + diretor.getDtNascimento() + "|");
					indice++;
				}

				// Solicita o ID a ser excluido.
				String indiceEx = "";
				do {
					System.out.print("\n\nDigite o ID que deseja excluir: ");
					indiceEx = scr.nextLine();

					if (valor.substring(0, valor.length()).matches("[0-9]*")) {
						break;
					} else
						System.out.println("Valor informado '" + indiceEx + "' não é válido !");

					System.out.println("informe apenas os ID contidos na tabela.\n");
					valor = "";
				} while (valor != "0");

				// Remove o Registro da Lista.
				try {
					ListaDir.remove(Integer.parseInt(indiceEx));
					System.out.println("Registro excluido com sucesso !");
				} catch (Exception e) {
					System.out.println("\nDesculpe não foi possível excluir o registro");
				}
			}

			do {
				System.out.print("\nDeseja excluir mais? S/N");
				desejaCadastrar = scr.next().toUpperCase();

				// Validando o valor informado.
				if (!desejaCadastrar.equals("S") && !desejaCadastrar.equals("N"))
					System.out.println("Valor Informado inválido");

			} while (!desejaCadastrar.equals("S") && !desejaCadastrar.equals("N"));
		} while (desejaCadastrar.equals("S"));
	}

	// Metodo responsavel por ler o menu
	public static String LerMenu() {

		Scanner scr = new Scanner(System.in);
		String valorLido = "";

		do {
			System.out.print("Digite a opção desejada: ");
			valorLido = scr.nextLine();

			if (valorLido == "1" || valorLido == "2" || valorLido == "3")
				System.out.println("Valor informado '" + valorLido + "' é invalido!");
			else
				break;

			System.out.println("Por favor, informe valores contidos no menu ou pressione 0 para sair.\n");
			valorLido = "";
		} while (valorLido != "0");

		return valorLido;

	}

}
