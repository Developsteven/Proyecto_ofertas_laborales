package com.steven.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.steven.model.Vacante;

@Service
public class VacantesServiceImpl implements IVacantesService {

	private List<Vacante> lista = null;

	public VacantesServiceImpl() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Vacante>();
		try {
			// Creamos la oferta de trabajo 1
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero civil");
			vacante1.setDescripcion("Solicitamos Ing. Civil para diseñar puente peatonal");
			vacante1.setFecha(sdf.parse("08-02-2019"));
			vacante1.setSalario(15000.0);
			vacante1.setDestacado(1);
			vacante1.setImagen("empresa1.png");

			// Creamos la oferta de trabajo 2
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador Publico");
			vacante2.setDescripcion("Empresa importante solicita contador con 5 años de experiencia titulado");
			vacante2.setFecha(sdf.parse("09-02-2019"));
			vacante2.setSalario(12000.0);
			vacante2.setDestacado(0);
			vacante2.setImagen("empresa2.png");

			// Creamos la oferta de trabajo 3
			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingeniero Electrico");
			vacante3.setDescripcion(
					"Empresa internacional solicita ingeniero mecanico para mantenimiento de las instalaciones electricas");
			vacante3.setFecha(sdf.parse("09-03-2019"));
			vacante3.setSalario(15500.0);
			vacante3.setDestacado(0);

			// Creamos la oferta de trabajo 4
			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Diseñador grafico");
			vacante4.setDescripcion("Solicitamos diseñador grafico titulado para diseñar la publicidad de la empresa");
			vacante4.setFecha(sdf.parse("09-03-2019"));
			vacante4.setSalario(7500.0);
			vacante4.setDestacado(1);
			vacante4.setImagen("empresa4.png");

			/*
			 * Agregamos los 4 objetos de tipo vacante a la lista
			 */

			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);

		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}


	@Override
	public List<Vacante> buscarTodas() {
		return lista;
	}


	@Override
	public Vacante buscarPorId(Integer idVacante) {
		for(Vacante v : lista) {
			if (v.getId()==idVacante) {
				return v;
			}
		}
		return null;
	}


	@Override
	public void guardar(Vacante vacante) {
		lista.add(vacante);
		
	}

}