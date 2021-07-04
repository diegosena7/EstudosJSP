package bean;

import java.io.Serializable;

/*
 * Um JavaBean � uma classe Java que deve seguir as seguintes conven��es:
 * Ele deve ter um construtor sem argumentos.
 * Deve ser serializ�vel.
 * Ele deve fornecer m�todos para definir e obter os valores das propriedades, conhecidos como m�todos getter e setter.
 * 
 * Vantagens do JavaBean

As propriedades e m�todos JavaBean podem ser expostos a outro aplicativo.
Proporciona facilidade de reutiliza��o dos componentes do software.

 * Desvantagens do JavaBean

JavaBeans s�o mut�veis. Portanto, n�o pode tirar vantagens de objetos imut�veis.
Criar os m�todos getter e setter para cada propriedade separadamente pode levar ao c�digo clich�
 */
public class Funcionario implements Serializable{
	private static final long serialVersionUID = 1L;

	private int id;  
	private String nome;  
	
	public Funcionario() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
