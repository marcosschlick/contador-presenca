package br.com.ifsul.contador_presenca.model.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "presencas")
@Table(name = "presencas")
public class Presenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    @Column(name = "data_entrada", nullable = true)
    private LocalDate dataEntrada;

    @Column(name = "horario_entrada", nullable = true)
    private LocalTime horarioEntrada;

    @Column(name = "data_saida", nullable = true)
    private LocalDate dataSaida;

    @Column(name = "horario_saida", nullable = true)
    private LocalTime horarioSaida;

	public Presenca() {
		super();
	}

	public Presenca(int id, Usuario usuario, LocalDate dataEntrada, LocalTime horarioEntrada, LocalDate dataSaida,
			LocalTime horarioSaida) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.dataEntrada = dataEntrada;
		this.horarioEntrada = horarioEntrada;
		this.dataSaida = dataSaida;
		this.horarioSaida = horarioSaida;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalTime getHorarioEntrada() {
		return horarioEntrada;
	}

	public void setHorarioEntrada(LocalTime horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public LocalTime getHorarioSaida() {
		return horarioSaida;
	}

	public void setHorarioSaida(LocalTime horarioSaida) {
		this.horarioSaida = horarioSaida;
	}

}
