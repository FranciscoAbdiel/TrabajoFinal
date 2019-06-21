package pe.edu.upc.serviceimpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.entity.Tipotarjeta;
import pe.edu.upc.repository.TipotarjetaRepository;
import pe.edu.upc.service.ITipotarjetaService;
@Service
public class TipotarjetaServiceImpl implements ITipotarjetaService {
	@Autowired
	private TipotarjetaRepository tR;
	@Override
	@Transactional
	public Integer insertar(Tipotarjeta tipotarjeta) {
		int rpta=tR.buscarNombreTipotarjeta(tipotarjeta.getNameTipotarjeta());
		if(rpta==0)
		{
			tR.save(tipotarjeta);
		}
		return rpta;
	}

	@Override
	@Transactional
	public void modificar(Tipotarjeta tipotarjeta) {
		// TODO Auto-generated method stub
		tR.save(tipotarjeta);
	}

	@Override
	@Transactional
	public void eliminar(int idTipotarjeta) {
		// TODO Auto-generated method stub
		tR.deleteById(idTipotarjeta);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Tipotarjeta> listarId(int idTipotarjeta) {
		// TODO Auto-generated method stub
		return tR.findById(idTipotarjeta);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tipotarjeta> listar() {
		// TODO Auto-generated method stub
		return tR.findAll(Sort.by(Sort.Direction.ASC,"nameTipotarjeta"));
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tipotarjeta> buscarNombre(String nameTipoTarjeta) {
		// TODO Auto-generated method stub
		return tR.findbynombreTipotarejta(nameTipoTarjeta);
	}
}
