package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entity.Tarjeta;
import pe.edu.upc.repository.TarjetaRepository;
import pe.edu.upc.service.ITarjetaService;

@Service
public class TarjetaServiceImpl implements ITarjetaService {
	@Autowired
	private TarjetaRepository tR;

	@Override
	@Transactional
	public Integer insertar(Tarjeta tarjeta) {
		int rpta = tR.buscarNumeroTarjeta(tarjeta.getNumeroTarjeta());
		if (rpta == 0) {
			tR.save(tarjeta);
		}
		return rpta;
	}

	@Override
	@Transactional
	public void modificar(Tarjeta tarjeta) {
		tR.save(tarjeta);
	}

	@Override
	@Transactional
	public void eliminar(int idTarjeta) {
		// TODO Auto-generated method stub
		tR.deleteById(idTarjeta);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Tarjeta> listarId(int idTarjeta) {
		// TODO Auto-generated method stub
		return tR.findById(idTarjeta);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tarjeta> listar() {
		// TODO Auto-generated method stub
		return tR.findAll(Sort.by(Sort.Direction.ASC,"numeroTarjeta"));
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tarjeta> buscar(String numeroTarjeta) {
		// TODO Auto-generated method stub
		return tR.findByNumeroTarjeta(numeroTarjeta);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tarjeta> buscarTipotarjeta(String nameTipotarjeta) {
		// TODO Auto-generated method stub
		return tR.buscarTiptarjeta(nameTipotarjeta);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tarjeta> buscarNumeroTarjeta(String numeroTarjeta) {
		// TODO Auto-generated method stub
		return tR.findByNumeroTarjeta(numeroTarjeta);
	}

	

}
