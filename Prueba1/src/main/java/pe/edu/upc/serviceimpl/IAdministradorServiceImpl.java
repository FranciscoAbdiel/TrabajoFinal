package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entity.Administrador;
import pe.edu.upc.repository.AdministradorRepository;
import pe.edu.upc.service.IAdministradorService;

@Service
public class IAdministradorServiceImpl implements IAdministradorService{

	@Autowired
	private AdministradorRepository aR;
	
	@Override
	@Transactional
	public void insertar(Administrador administrador) {
		// TODO Auto-generated method stub
		aR.save(administrador);
	}

	@Override
	@Transactional
	public void modificar(Administrador administrador) {
		// TODO Auto-generated method stub
		aR.save(administrador);
	}

	@Override
	@Transactional
	public void eliminar(int idAdministrador) {
		// TODO Auto-generated method stub
		aR.deleteById(idAdministrador);
	}


	@Override
	@Transactional(readOnly = true)
	public Optional<Administrador> listarId(int idAdministrador) {
		// TODO Auto-generated method stub
		return aR.findById(idAdministrador);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Administrador> listar() {
		// TODO Auto-generated method stub
		return aR.findAll(Sort.by(Sort.Direction.DESC, "datosCliente"));
	}
}