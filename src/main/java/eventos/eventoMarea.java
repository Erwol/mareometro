package eventos;

public class eventoMarea {	
	
	private String dispositivo; 
	private String sensor;
	private String localizacion; 
	private float latitud; 
	private float longitud;
	private float alturaMarea;
	private boolean subiendo;
	private String fecha;
	
	public eventoMarea(
			String dispositivo, 
			String sensor, 
			String localizacion, 
			float latitud, 
			float longitud, 
			float altura_marea, 
			boolean subiendo,
			String fecha) {
		this.dispositivo = dispositivo;
		this.setSensor(sensor);
		this.setLocalizacion(localizacion);
		this.setLatitud(latitud);
		this.setLongitud(longitud);
		this.alturaMarea = pulgadasCentimetros(altura_marea);
		this.subiendo = subiendo;
		this.setFecha(fecha);
		
	}
	
	// El JSON original devuelve una altura en pulgadas que convertimos a centímetros
	private float pulgadasCentimetros(float pulgadas){
		return (float) (pulgadas * 2.54);
	}
		
	

	@Override
	public String toString() {
		String sube_baja = null;
		if(subiendo)
			sube_baja = "subiendo";
		else
			sube_baja = "bajando";
		return "La profundidad del agua registrada por el dispositivo " + this.dispositivo + " es de "
				+ this.alturaMarea + " centímetros.\nEn estos momentos (" + this.fecha + ") la marea está " + sube_baja + ".";
	}

	public String getSensor() {
		return sensor;
	}

	public void setSensor(String sensor) {
		this.sensor = sensor;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}