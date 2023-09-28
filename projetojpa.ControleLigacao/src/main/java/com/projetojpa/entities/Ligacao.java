package com.projetojpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ligacao")
public class Ligacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Size(min= 4, message= "Mínimo de 4 dígitos!")
	private String data;
	
	@NotNull
	@NotBlank
	private String horarioInicio;
	
	@NotNull
	@NotBlank
	private String horarioTermino;
	
	@NotNull
	@NotBlank
	@Size(min= 11, message= "Mínimo de 11 dígitos!")
	private String telefoneDiscado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHorarioInicio() {
		return  horarioInicio;
	}
	public void setHoarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	public String getHorarioTermino() {
		return  horarioTermino;
	}
	public void setHorarioTermino(String horarioTermino) {
		this.horarioTermino = horarioTermino;
	}
	public String getTelefoneDiscado() {
		return  telefoneDiscado;
	}
	public void setTelefoneDiscado(String telefoneDiscado) {
		this.telefoneDiscado = telefoneDiscado;
	}
}
