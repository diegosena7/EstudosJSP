package bean;

import java.io.Serializable;

/*
 * Um JavaBean é uma classe Java que deve seguir as seguintes convenções:
 * Ele deve ter um construtor sem argumentos.
 * Deve ser serializável.
 * Ele deve fornecer métodos para definir e obter os valores das propriedades, conhecidos como métodos getter e setter.
 * 
 * Vantagens do JavaBean

As propriedades e métodos JavaBean podem ser expostos a outro aplicativo.
Proporciona facilidade de reutilização dos componentes do software.

 * Desvantagens do JavaBean

JavaBeans são mutáveis. Portanto, não pode tirar vantagens de objetos imutáveis.
Criar os métodos getter e setter para cada propriedade separadamente pode levar ao código clichê
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
