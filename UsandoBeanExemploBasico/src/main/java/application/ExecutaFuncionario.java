package application;

import bean.Funcionario;

/*
 * Para acessar a classe JavaBean, devemos usar os m�todos getter e setter.
 */
public class ExecutaFuncionario {

	public static void main(String[] args) {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Diego");
		funcionario.setId(1);
		
		System.out.println("Nome do colaborador: " + funcionario.getNome());
		System.out.println("Id do colaborador: " + funcionario.getId());
	}
}
