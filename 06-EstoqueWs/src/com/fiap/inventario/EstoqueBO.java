package com.fiap.inventario;

import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.AxisFault;

import com.fiap.inventario.to.ProdutoTO;

public class EstoqueBO {
	
	public List<ProdutoTO> listar(){
		List<ProdutoTO> lista = new ArrayList<>();
		lista.add(new ProdutoTO(401, "Camiseta Masculina", 
				100, 5));
		lista.add(new ProdutoTO(402, "Camiseta Feminina", 
				150, 1));
		return lista;
		
	}
	
	public ProdutoTO consultarProduto(int codigo) throws AxisFault {
		ProdutoTO to = null;
	
		switch (codigo) {
		case 401:
			to = new ProdutoTO(401,
					"Camiseta Masculina", 50, 10);
			break;
		case 402:
			to = new ProdutoTO(402,
					"Camiseta Feminina", 40, 20);
			break;
		default:
			throw new AxisFault("Produto não encontrado");	
		}
		
		return to;
	}
	
}
