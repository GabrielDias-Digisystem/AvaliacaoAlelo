package com.alelo.AvaliacaoAlelo.main;

import java.util.Scanner;

import com.alelo.AvaliacaoAlelo.controller.diretorController;
import com.alelo.AvaliacaoAlelo.controller.filmeController;

public class menuPrincipal {

	private static String valorLido = "";

	public static void main(String[] args) {
		diretorController dir = new diretorController();
		filmeController fim = new filmeController();

		do {
			valorLido = "";

			System.out.println("\n*** Menu Principal ***\n");
			System.out.println("Cadastrar Diretor ...................... 1");
			System.out.println("Cadastrar Filme ........................ 2");
			System.out.println("Sair do Sistema ........................ 0\n");

			Scanner scr = new Scanner(System.in);
			String Valor = "";
			
			valorLido = LerMenu();
			
			switch (valorLido) {
			case "1":
				dir.MenuDir();
				break;
			case "2":
				fim.MenuFilme();
			}
		} while (!valorLido.equals("0"));

		System.out.println("\n\nSaindo do sistema....");
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
