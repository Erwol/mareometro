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
		//System.out.println("Guarda el valor: " + Float.parseFloat(obj.getAsString("feeds[99]/field1")));
		if(nombreDispositivo.equalsIgnoreCase("Ockway Bay Tide Level")) {
			evento = new eventoMarea(
					nombreDispositivo, 
					obj.getAsString("channel/description"),
					"LOC",
					Float.parseFloat(obj.getAsString("channel/latitude")),
					Float.parseFloat(obj.getAsString("channel/longitude")),
					Float.parseFloat(obj.getAsString("feeds[99]/field1")) ,
					sube(obj),
					obj.getAsString("channel/created_at"));
			System.out.println("Evento transformado: " + evento);
		}
		else 
			System.out.println("No es posible realizar la conversión");
		return evento; 
	}
	
	boolean sube(JsonData obj){
		System.out.println(Float.parseFloat(obj.getAsString("feeds[99]/field1")) + " vs " + Float.parseFloat(obj.getAsString("feeds[98]/field1")));
		// Comparamos el valor actual con el de las últimas 2 mediciones
		return Float.parseFloat(obj.getAsString("feeds[99]/field1")) > Float.parseFloat(obj.getAsString("feeds[98]/field1"));
	}
	
	@Transformer  
	public eventoTemperatura JSONToEventoTemperatura(JsonData obj) throws Exception 
	{
		eventoTemperatura evento = null;
		String nombreDispositivo = obj.getAsString("channel/name");
		if(nombreDispositivo.equalsIgnoreCase("IEEE Weather Station")) {
			evento = new eventoTemperatura(
					nombreDispositivo,
					Float.parseFloat(obj.getAsString("feeds[1]/field1")),
					obj.getAsString("channel/updated_at")
					);
		
		}
		System.out.println(evento.toString());
		return evento;
	
	}
}