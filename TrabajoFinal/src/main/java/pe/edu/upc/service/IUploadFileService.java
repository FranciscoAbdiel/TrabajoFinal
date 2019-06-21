package pe.edu.upc.service;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {

	public Resource load(String filename) throws MalformedURLException; // Resource: permite cargar un recurso  -
	//---MalformedURLException: Se lanza para indicar que se ha producido una URL con formato incorrecto

	public String copy(MultipartFile file) throws IOException; //mutlipartfile:El almacenamiento temporal se borrará al final del procesamiento de la solicitud.

	public boolean delete(String filename);

}
