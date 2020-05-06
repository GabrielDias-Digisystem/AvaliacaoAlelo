package com.alelo.AvaliacaoAlelo.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.alelo.AvaliacaoAlelo.interfaces.Funcionalidades;
import com.alelo.AvaliacaoAlelo.models.Filmes;

public class filmeController implements Funcionalidades {

	private static String valor = "";
	public static ArrayList<Filmes> listaFilmes = new ArrayList<Filmes>();

	public void MenuFilme() {

		do {
			Scanner scr = new Scanner(System.in);
			String valorLido = "";

			System.out.println("\n\n\n*** MENU FILME ***\n\n");
			System.out.println("digite a opção desejada no menu abaixo:\n\n");
			System.out.println("Listar    ................... 1");
			System.out.println("Cadastrar ................... 2");
			System.out.println("Pesquisar ................... 3");
			System.out.println("Excluir   ................... 4");
			System.out.println("Retornar ao Menu Principal .. 0\n");

			// le o menu
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

		System.out.println("\nFilmes Cadastrados\n");

		if (listaFilmes.isEmpty())
			System.out.println("Não há registros cadastrados !");
		else {
			// Percorre a lista de filmes cadastrados
			int indice = 0;
			System.out.println("\n| ID | NOME | ANO DE LANÇAMENTO |");
			for (Filmes filme : listaFilmes) {
				System.out.println("\n|" + indice + " - " + filme.getNome() + " - " + filme.getAnoLancamento() +"|");
				indice++;
			}
		}
	}

	@Override
	public void Pesquisar() {
		String Valor = "S";

		do {
			Scanner scr = new Scanner(System.in);
			String valor = "";

			System.out.println("\nPesquisar\n");

			if (listaFilmes.isEmpty())
				System.out.println("Não há registros!");
			else {
				System.out.print("Digite o valor para pesquisar: ");
				try {
					valor = scr.nextLine();
				} catch (Exception e) {
					System.out.println("Ocorreu um erro na leitura, tente novamente !");
					continue;
				}

				// Validando o valor inserido.
				if (valor.equals("")) {
					System.out.println("Por favor, preencha o campo!");
					continue;
				}

				// Pesquisando o valor informado.
				boolean encontrado = false;
				ArrayList<Filmes> filmeEncontrado = new ArrayList<Filmes>();
				for (Filmes filme : listaFilmes) {
					if (filme.getNome().contains(valor)) {
						encontrado = true;
						filmeEncontrado.add(filme);
					}

					if (valor.substring(0, valor.length()).matches("[0-9]*")) {
						if (filme.getAnoLancamento() == Integer.parseInt(valor)) {
							encontrado = true;
							filmeEncontrado.add(filme);
						}
					}
				}

				if (!encontrado)
					System.out.println("\nO Filme informado '" + valor + "' não foi encontrado!\n");
				else {
					System.out.println("\n\nRegistro\n");

					System.out.println("\n| ID | NOME | ANO DE LANÇAMENTO |");
					int indice = 0;
					for (Filmes filme : filmeEncontrado) {
						System.out.println("\n" + indice + " | " + filme.getNome() + " | " + filme.getAnoLancamento());
						indice++;
					}
				}
			}

			do {
				System.out.print("\nDeseja consultar mais? S/N: ");
				Valor = scr.next().toUpperCase();

				// Validando o valor informado.
				if (!Valor.equals("S") && !Valor.equals("N"))
					System.out.println("Valor Informado inválido");
			} while (!Valor.equals("S") && !Valor.equals("N"));
		} while (Valor.equals("S"));

	}

	@Override
	public void Cadastro() {
		String Valor = "S";

		do {
			Scanner scr = new Scanner(System.in);
			String nomeFilme = "";
			String anoLancamento = "";
			String Sair = "";

			System.out.println("\nPor favor, Digite os valores\n");

			System.out.print("Nome do Filme: ");
			try {
				nomeFilme = scr.nextLine();
			} catch (Exception e) {
				System.out.println("Ocorreu um erro na leitura do Nome. Por favor, tente novamente !");
				continue;
			}

			// Validando o nome inserido.
			if (nomeFilme.equals("")) {
				System.out.println("Por favor, preencha o campo Nome");
				continue;
			}

			do {
				System.out.print("Ano de Lançamento: ");
				anoLancamento = scr.nextLine();

				if (anoLancamento.equals("")) {
					System.out.println("Por favor, preencha o campo Ano de Lançamento");
					anoLancamento = "1";
					continue;
				} else {
					Sair = "0";
				}
				
				
			} while (Sair != "0");

			// Cadastrando o registro informado.
			Filmes filme = new Filmes();
			filme.setNome(nomeFilme);
			filme.setAnoLancamento(Integer.parseInt(anoLancamento));

			listaFilmes.add(filme);

			do {
				System.out.print("Deseja cadastrar mais? S/N: ");
				Valor = scr.next().toUpperCase();

				// Validando o valor informado.
				if (!Valor.equals("S") && !Valor.equals("N"))
					System.out.println("Valor Informado inválido");
			} while (!Valor.equals("S") && !Valor.equals("N"));
		} while (Valor.equals("S"));

	}

	@Override
	public void Excluir() {
		String Valor = "S";

		do {
			Scanner scr = new Scanner(System.in);

			System.out.println("\nExcluir\n");

			if (listaFilmes.isEmpty())
				System.out.println("Não há registros para serem excluidos !");
			else {
				System.out.println("Registros\n");
				int maiorValor = 0;

				// Percorre a lista de filmes
				System.out.println("\n| ID | NOME | ANO DE LANÇAMENTO |");
				int indice = 0;
				for (Filmes filme : listaFilmes) {
					System.out.println("\n|" + indice + " | " + filme.getNome() + " | " + filme.getAnoLancamento()+"|");
					indice++;

				}

				// Solicita o ID a ser excluido.
				String indiceEx = "";
				do {
					System.out.print("\n\nDigite o ID para excluir: ");
					indiceEx = scr.nextLine();
					
					if (valor.substring(0, valor.length()).matches("[0-9]*")) {
						break;
					} else
						System.out.println("Valor informado '" + indiceEx + "' não é válido !");

					System.out.println("informe apenas os ID contidos na tabela.\\n");
					Valor = "";
				} while (Valor != "0");

				// Remove o Registro da Lista.
				try {
					listaFilmes.remove(Integer.parseInt(indiceEx));
					System.out.println("Registro excluido com sucesso !");
				} catch (Exception e) {
					System.out.println("\nDesculpe não foi possível excluir o registro!");
				}
			}

			do {
				System.out.print("\nDeseja excluir mais? S/N");
				Valor = scr.next().toUpperCase();

				// Validando o valor informado.
				if (!Valor.equals("S") && !Valor.equals("N"))
					System.out.println("Valor Informado inválido");

			} while (!Valor.equals("S") && !Valor.equals("N"));
		} while (Valor.equals("S"));

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
