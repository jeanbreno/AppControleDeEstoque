package erp.controle.estoque.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import erp.controle.estoque.model.domain.Pedido;
import erp.controle.estoque.model.domain.Usuario;
import erp.controle.estoque.model.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Collection<Pedido> obterLista(Usuario usuario){		
		return (Collection<Pedido>) pedidoRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "data"));
	}

	public Collection<Pedido> obterLista(){		
		return (Collection<Pedido>) pedidoRepository.findAll();
	}
	
	public Pedido incluir(Pedido pedido){
		return pedidoRepository.save(pedido);
	}
	
	public void excluir(Integer id) {
		pedidoRepository.deleteById(id);
	}
	
	public Pedido obterPorId(Integer id) {
		return pedidoRepository.findById(id).orElse(null);
	}	

	public Integer obterQtde(){
		return (int) pedidoRepository.count();
	}
}