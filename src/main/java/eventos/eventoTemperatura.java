package eventos;

public class eventoTemperatura {
	private String dispositivo; 
	private float temperatura;
	private String fecha;
	
	public eventoTemperatura(String dispositivo, float temperatura, String fecha){
		this.setDispositivo(dispositivo);
		this.setTemperatura(temperatura);
		this.setFecha(fecha);
	}
	
	@Override
	public String toString() {
		return this.temperatura + "º a las " + this.fecha + " en el " + this.dispositivo + ".";
	}
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}

	public String getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}
}








	
