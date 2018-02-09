package com.projeto.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean
public class CadastroBean {
	
	private Long codigo;
	private String nome;
	private Integer idade;
	private String cpf;
	private String telefone;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
	public void cadastrar(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		CadastroBean pessoa = new CadastroBean();
		
		pessoa.setCodigo(codigo);
		pessoa.setIdade(idade);
		pessoa.setNome(nome);
		pessoa.setTelefone(telefone);
		pessoa.setCpf(cpf);
		
		em.getTransaction().begin();
		em.persist(pessoa);
		em.getTransaction().commit();
		
		
	}
	
	public void consultar(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		

		CadastroBean pessoa  = em.find(CadastroBean.class, codigo);
			if(pessoa!= null){
				pessoa.getNome();
				pessoa.getIdade();
				pessoa.getCpf();
				List<String> lista = new ArrayList<String>();
				lista.set(codigo, telefone);
				for(CadastroBean list : lista.set(pessoa.getCodigo(),pessoa.getTelefone())){
					pessoa = list;
				}
				pessoa.getTelefone();
			}else{
				cadastrar();
			}
			
			
	}
	
	public void editar(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emf.createEntityManager();
		
		CadastroBean pessoa = new CadastroBean();
		
		em.getTransaction().begin();
		pessoa.setNome(nome);
		pessoa.setIdade(idade);
		pessoa.setCpf(cpf);
		pessoa.setTelefone(telefone);
		em.getTransaction().commit();
		
		System.out.println("Cliente alterado com sucesso!");
		
		
	}
	
	
	
}
