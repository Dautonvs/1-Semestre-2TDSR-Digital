package com.fiap.inventario;

import org.apache.axis2.AxisFault;

import com.fiap.inventario.to.ProdutoTO;

public class EstoqueBO {
	
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
