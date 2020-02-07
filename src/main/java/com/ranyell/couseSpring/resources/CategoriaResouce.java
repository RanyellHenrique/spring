package com.ranyell.couseSpring.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ranyell.couseSpring.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResouce {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar() {
	
		List<Categoria> lista = new ArrayList<>();
		
		Categoria c1 = new Categoria(1, "Anna");
		Categoria c2 = new Categoria(2, "Lucas");
		
		lista.add(c1);
		lista.add(c2);
		
		return lista;
	}

}
