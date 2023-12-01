package aplicacao;

import java.time.LocalDate;
import java.util.Scanner;

import db.AjudanteDAO;
import db.EmpresaDAO;
import db.FichaMedicaDAO;
import db.MotoristaDAO;
import seminario.Ajudante;
import seminario.Empresa;
import seminario.FichaMedica;
import seminario.Motorista;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MotoristaDAO motoristaDAO = new MotoristaDAO();
		FichaMedicaDAO fichaMedicaDAO = new FichaMedicaDAO();
		AjudanteDAO ajudanteDAO = new AjudanteDAO();
		EmpresaDAO empresaDAO = new EmpresaDAO();
		System.out.println("BEM VINDO! O QUE DESEJA FAZER ?");
		System.out.println(
				" 1 - CADASTRO DE MOTORISTA\n 2 - CADASTRO DE FICHA MEDICA \n 3 - CADASTRO DE AJUDANTE \n 4 - CADASTRO DE EMPRESA");
		int n = sc.nextInt();

		if (n == 1) {
			System.out.println("O QUE DESEJA FAZER ? ");
			System.out.println(" 1 - INSERIR\n 2 - ATUALIZAR\n 3 - DELETAR\n 4 - BUSCAR ");
			int x = sc.nextInt();
			sc.nextLine();
			if (x == 1) {
				System.out.println("Insira os dados do motorista: ");
				System.out.print("Nome: ");
				String nome = sc.nextLine();
				System.out.print("Sobrenome: ");
				String sobrenome = sc.nextLine();
				System.out.print("email: ");
				String email = sc.nextLine();
				System.out.print("Senha: ");
				String senha = sc.nextLine();
				System.out.print("Data: ");
				LocalDate data = LocalDate.parse(sc.nextLine());
				System.out.print("CPF: ");
				String cpf = sc.nextLine();
				System.out.print("Telefone: ");
				String telefone = sc.nextLine();
				// Criar um novo motorista
				Motorista novoMotorista = new Motorista(nome, sobrenome, email, senha, data, cpf, telefone);
				// Inserir o novo motorista no banco de dados

				motoristaDAO.inserirMotorista(novoMotorista);
			}

			else if (x == 2) {
				System.out.println("Digite o codigo ID do motorista");
				System.out.println("Insira os dados do motorista para atualização: ");
				int y = sc.nextInt();
				sc.nextLine();
				System.out.print("Nome: ");
				String nome = sc.nextLine();
				System.out.print("Sobrenome: ");
				String sobrenome = sc.nextLine();
				System.out.print("email: ");
				String email = sc.nextLine();
				System.out.print("Senha: ");
				String senha = sc.nextLine();
				System.out.print("Data: ");
				LocalDate data = LocalDate.parse(sc.nextLine());
				System.out.print("CPF: ");
				String cpf = sc.nextLine();
				System.out.print("Telefone: ");
				String telefone = sc.nextLine();

				Motorista novoMotoristaat = new Motorista(nome, sobrenome, email, senha, data, cpf, telefone, y);

				motoristaDAO.atualizarMotorista(novoMotoristaat);
			}

			else if (x == 3) {
				System.out.println("Qual ID DO MOTORISTA QUE DESEJA APAGAR? ");
				int y = sc.nextInt();
				motoristaDAO.deletarMotorista(y);

			} else if (x == 4) {

				motoristaDAO.buscarTodosMotoristas()
						.forEach(motorista -> System.out.println(motorista + "\n-------------------------------"));

			}

		} else if (n == 2) {
			// ADICIONAR A FICHA MEDICA
			System.out.println("O QUE DESEJA FAZER ? ");
			System.out.println(" 1 - INSERIR\n 2 - ATUALIZAR\n 3 - DELETAR\n 4 - BUSCAR ");
			int x = sc.nextInt();
			sc.nextLine();
			if (x == 1) {
				System.out.print("DIGITE O ID DO MOTORISTA PARA ACESSAR A FICHA MÉDICA : ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.print("Tipo de Sangue: ");
				String tipoSangue = sc.nextLine();
				System.out.print("Alergias: ");
				String alergias = sc.nextLine();
				System.out.print("Doenças Crônicas: ");
				String doencasCronicas = sc.nextLine();
				System.out.print("Medicamentos: ");
				String medicamentos = sc.nextLine();

				FichaMedica ficha = new FichaMedica(id, tipoSangue, alergias, doencasCronicas, medicamentos);

				// Inserir a nova ficha médica no banco de dados
				fichaMedicaDAO.inserirFichaMedica(ficha);
				System.out.println("Ficha médica inserida com sucesso! ID: " + ficha.getIdFichaMedica());
			} else if (x == 2) {
				System.out.println("Adicione o ID do motorista ao qual deseja alterar a ficha médica: ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.print("Tipo de Sangue: ");
				String tipoSangue = sc.nextLine();
				System.out.print("Alergias: ");
				String alergias = sc.nextLine();
				System.out.print("Doenças Crônicas: ");
				String doencasCronicas = sc.nextLine();
				System.out.print("Medicamentos: ");
				String medicamentos = sc.nextLine();

				FichaMedica ficha = new FichaMedica(id, tipoSangue, alergias, doencasCronicas, medicamentos);

				fichaMedicaDAO.atualizarFichaMedica(ficha);

			} else if (x == 3) {
				System.out.println("DIGITE O ID DO MOTORISTA AO QUAL DESEJA DELETAR A FICHA MÉDICA: ");
				int id = sc.nextInt();
				fichaMedicaDAO.deletarFichaMedica(id);

			}

		} else if (n == 3) {

			System.out.println("O QUE DESEJA FAZER ? ");
			System.out.println(" 1 - INSERIR\n 2 - ATUALIZAR\n 3 - DELETAR\n 4 - BUSCAR ");
			int x = sc.nextInt();
			sc.nextLine();
			if (x == 1) {
				System.out.println("Insira os dados do ajudante: ");
				System.out.print("Nome: ");
				String nome = sc.nextLine();
				System.out.print("Sobrenome: ");
				String sobrenome = sc.nextLine();
				System.out.print("email: ");
				String email = sc.nextLine();
				System.out.print("Senha: ");
				String senha = sc.nextLine();
				System.out.print("Data: ");
				LocalDate data = LocalDate.parse(sc.nextLine());
				System.out.print("CPF: ");
				String cpf = sc.nextLine();
				System.out.print("Telefone: ");
				String telefone = sc.nextLine();
				// Criar um novo ajudante
				Ajudante ajudante = new Ajudante(nome, sobrenome, email, senha, data, cpf, telefone);
				// Inserir o novo ajudante no banco de dados
				ajudanteDAO.inserirAjudante(ajudante);
				System.out.println("Cadastrado com sucesso!");

			}

			else if (x == 2) {
				System.out.println("Digite o codigo ID do ajudante");
				System.out.println("Insira os dados do ajudante para atualização: ");
				int y = sc.nextInt();
				sc.nextLine();
				System.out.print("Nome: ");
				String nome = sc.nextLine();
				System.out.print("Sobrenome: ");
				String sobrenome = sc.nextLine();
				System.out.print("email: ");
				String email = sc.nextLine();
				System.out.print("Senha: ");
				String senha = sc.nextLine();
				System.out.print("Data: ");
				LocalDate data = LocalDate.parse(sc.nextLine());
				System.out.print("CPF: ");
				String cpf = sc.nextLine();
				System.out.print("Telefone: ");
				String telefone = sc.nextLine();

				Ajudante ajudante = new Ajudante(nome, sobrenome, email, senha, data, cpf, telefone, y);
				// Inserir o novo ajudante no banco de dados
				ajudanteDAO.atualizarAjudante(ajudante);

			}

			else if (x == 3) {
				System.out.println("Qual ID DO MOTORISTA QUE DESEJA APAGAR? ");
				int y = sc.nextInt();
				ajudanteDAO.deletarAjudante(y);
			} else if (x == 4) {

				ajudanteDAO.buscarTodosAjudantes()
						.forEach(ajudante -> System.out.println(ajudante + "\n-------------------------------"));

			}

		} else if (n == 4) {

			System.out.println("O QUE DESEJA FAZER ? ");
			System.out.println(" 1 - INSERIR\n 2 - ATUALIZAR\n 3 - DELETAR\n 4 - BUSCAR ");
			int x = sc.nextInt();
			sc.nextLine();
			if (x == 1) {

				System.out.println("Insira os dados para cadastrar a empresa: ");
				System.out.print("Nome da Empresa: ");
				String nomeEmpresa = sc.nextLine();

				System.out.print("CNPJ: ");
				String cnpj = sc.nextLine();

				System.out.print("Endereço: ");
				String endereco = sc.nextLine();

				System.out.print("Nome do Contato: ");
				String contatoNome = sc.nextLine();

				System.out.print("Telefone do Contato: ");
				String contatoTelefone = sc.nextLine();

				// Criando um objeto da classe Empresa com os dados fornecidos
				Empresa empresa = new Empresa(nomeEmpresa, cnpj, endereco, contatoNome, contatoTelefone);
				empresaDAO.inserirEmpresa(empresa);
			} else if (x == 2) {

				System.out.println("DIGITE O CÓDIGO DA EMPRESA QUE DESEJA ATUALIZAR OS DADOS: ");
				int id = sc.nextInt();
				sc.nextLine(); // Consumir a quebra de linha pendente
				System.out.print("Nome da Empresa: ");
				String nomeEmpresa = sc.nextLine();

				System.out.print("CNPJ: ");
				String cnpj = sc.nextLine();

				System.out.print("Endereço: ");
				String endereco = sc.nextLine();

				System.out.print("Nome do Contato: ");
				String contatoNome = sc.nextLine();

				System.out.print("Telefone do Contato: ");
				String contatoTelefone = sc.nextLine();
				Empresa empresa = new Empresa(nomeEmpresa, cnpj, endereco, contatoNome, contatoTelefone, id);
				empresaDAO.atualizarEmpresa(empresa);
			} else if (x == 3) {
				System.out.println("QUAL ID DA EMPRESA QUE DESEJA APAGAR? ");
				int y = sc.nextInt();
				empresaDAO.deletarEmpresa(y);
				System.out.println("Deletado com sucesso!");
			}
		}
		sc.close();

	}
}
