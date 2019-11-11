package com.br.model.mongo;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "players")
public class Players {

	private String nome;
	private Long preco;
	private Date dataAtualizacaoPreco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getPreco() {
		return preco;
	}

	public void setPreco(Long preco) {
		this.preco = preco;
	}

	public Date getDataAtualizacaoPreco() {
		return dataAtualizacaoPreco;
	}

	public void setDataAtualizacaoPreco(Date dataAtualizacaoPreco) {
		this.dataAtualizacaoPreco = dataAtualizacaoPreco;
	}

}
