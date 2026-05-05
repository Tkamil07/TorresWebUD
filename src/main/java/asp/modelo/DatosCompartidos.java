package asp.modelo;

/*Cristian Camilo Torres Huertas 20241578207*/

import asp.modelo.Aspirante;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("datosGlobales")
@ApplicationScoped
public class DatosCompartidos {

	private List<Aspirante> listaGlobal = new ArrayList();
	
	public void agregarAspirante(Aspirante dto) {
        listaGlobal.add(dto);
    }

    public List<Aspirante> getListaGlobal() {
        return listaGlobal;
    }

}
