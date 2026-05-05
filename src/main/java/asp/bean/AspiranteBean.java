package asp.bean;

/*Cristian Camilo Torres Huertas 20241578207*/

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import asp.modelo.AspiranteDAO;
import asp.modelo.DatosCompartidos;
import asp.modelo.ProgAcad;
import asp.modelo.ProgAcadDAO;
import asp.modelo.Aspirante;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("asp")
@RequestScoped


public class AspiranteBean implements Serializable{
	@Inject 
	private DatosCompartidos datosGlobales; 
	
	
	private static final long serialVersionUID = 1L;
	private Aspirante dto = new Aspirante();
	private ArrayList<Aspirante> listaAS = AspiranteDAO.lista_A;
	private ArrayList<ProgAcad> listaPa = ProgAcadDAO.lista_P;
	
	public AspiranteBean() {
		ProgAcadDAO.cargaDatos();
	}

	public Aspirante getDto() {
		return dto;
	}

	public void setDto(Aspirante dto) {
		this.dto = dto;
	}

	public ArrayList<Aspirante> getListaAS() {
		return listaAS;
	}

	public void setListaAS(ArrayList<Aspirante> listaAS) {
		this.listaAS = listaAS;
	}

	public ArrayList<ProgAcad> getListaPa() {
		return listaPa;
	}

	public void setListaPa(ArrayList<ProgAcad> listaPa) {
		this.listaPa = listaPa;
	}
	
	public void registrar() {
		
		dto.setFecha_reg(LocalDate.now());
		if(dto.getPro_acad().getCod() >= 0 && dto.getPro_acad().getCod() < listaPa.size()) 
		{
			dto.setPro_acad(listaPa.get(dto.getPro_acad().getCod()));
		} else 
		{
			dto.setPro_acad(null);
		}
		listaAS.add(dto);
		datosGlobales.agregarAspirante(dto);   
		System.out.println("Se a registrado: " + dto.toString());
	}
	
	
	
}
