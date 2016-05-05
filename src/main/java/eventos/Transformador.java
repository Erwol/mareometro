package eventos;

import org.mule.api.annotations.ContainsTransformerMethods;
import org.mule.api.annotations.Transformer;
import org.mule.module.json.JsonData;

import eventos.eventoMarea;

// ver http://www.mulesoft.org/docs/site/current3/apidocs/org/mule/module/json/JsonData.html


@ContainsTransformerMethods
public class Transformador
{
	@Transformer  
	public eventoMarea JSONToEventoMarea(JsonData obj) throws Exception 
	{	  	  
		eventoMarea evento = null;
		String nombreDispositivo = obj.getAsString("channel/name");
		
		if(nombreDispositivo.equalsIgnoreCase("Ockway Bay Tide Level")) {
			evento = new eventoMarea(
					nombreDispositivo, 
					obj.getAsString("channel/description"),
					"LOC",
					Float.parseFloat(obj.getAsString("channel/latitude")),
					Float.parseFloat(obj.getAsString("channel/longitude")),
					Float.parseFloat(obj.getAsString("feeds[1]/field1")),
					sube(obj),
					obj.getAsString("channel/created_at"));
			System.out.println("Evento transformado: " + evento);
		}
		else 
			System.out.println("No es posible realizar la conversión");
		return evento; 
	}
	
	boolean sube(JsonData obj){
		// Comparamos el valor actual con el de las últimas 2 mediciones
		boolean sol = false;
		if(Float.parseFloat(obj.getAsString("feeds[1]/field1")) > Float.parseFloat(obj.getAsString("feeds[1]/field1")))
			sol = true;
		return  sol;
	}
}