package erp.controle.estoque.model.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import erp.controle.estoque.model.domain.Produto;
import erp.controle.estoque.model.domain.Usuario;
/*
 * import erp.controle.estoque.model.repository.ProdutoRepository;
 * 
 * @Service public class ProdutoService {
 * 
 * @Autowired private ProdutoRepository protudoRepository; //public Produto
 * produto;
 * 
 * public Collection<Produto> obterLista(Usuario usuario){ return
 * (Collection<Produto>) protudoRepository.obterLista(usuario.getId()); }
 * 
 * public Collection<Produto> obterLista(){ return (Collection<Produto>)
 * protudoRepository.findAll(); }
 * 
 * public Produto incluir(Produto produto){ return
 * produtoRepository.save(produto); }
 * 
 * public void excluir(Integer id) { protudoRepository.deleteById(id); }
 * 
 * public Produto obterPorId(Integer id) { return
 * protudoRepository.findById(id).orElse(null); } }
 */

@Service
public class ProdutoService{
	
	private static Map<Integer, Produto> mapaProdutos = new HashMap<Integer, Produto>();
	
	private static Integer id = 0;
	
	private static List<Produto> produtos = new ArrayList<Produto>();
	
	public Collection<Produto> obterLista(){
		
		return mapaProdutos.values();
	}
	
	public void incluir (Produto produto){
		
		mapaProdutos.put(++id, produto);
		//produtos.add(produto);
	}
}
 