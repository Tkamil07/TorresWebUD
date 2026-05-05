package asp.bean;

/*Cristian Camilo Torres Huertas 20241578207*/

import asp.modelo.Aspirante;
import asp.modelo.DatosCompartidos;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("admin")
@RequestScoped

public class AdminBean implements Serializable{
	
	@Inject
    private DatosCompartidos datosGlobales;

    public List<Aspirante> getTodosAspirantes() {
        return datosGlobales.getListaGlobal();
    }
	
}
