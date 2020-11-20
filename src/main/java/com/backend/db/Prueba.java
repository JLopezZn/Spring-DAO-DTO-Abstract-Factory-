package com.backend.db;

import java.sql.SQLException;

import com.backend.db.dao.IAlumnoDAO;
import com.backend.db.dao.factory.AbstractDaoFactory;
import com.backend.db.dao.factory.AbstractDaoFactoryImpl;
import com.backend.db.dao.factory.AlumnoDaoFactory;
import com.backend.db.dao.factory.AlumnoDaoFactoryImpl;
import com.backend.db.dao.factory.ProfesorDaoFactory;
import com.backend.db.dao.factory.ProfesorDaoFactoryImpl;
import com.backend.db.dto.Alumno;
import com.backend.db.dto.Profesor;

public class Prueba {


	
	public static void main(String[] args) {
		
		Alumno a = new Alumno();
		a.setApellido("ramires9");
		a.setNombre("fabian9");
		Profesor p = new Profesor();
		p.setApellido("ramires2");
		p.setNombre("fabian2");
		String query = "insert into Alumno (nombre, apellido) values(?,?)";
		AbstractDaoFactory fabrica = AbstractDaoFactoryImpl.getInstance();
		AlumnoDaoFactory f = fabrica.getAlumoFactory();
		ProfesorDaoFactory fp = fabrica.getProfesorFactory();
		IAlumnoDAO ad = f.objeto();
		IAlumnoDAO ad2 = fabrica.getAlumoFactory().objeto();
		try {
			System.out.println(ad.select(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		/*AbstractDaoFactory fabrica = AbstractDaoFactoryImpl.getInstance();
		IProfesorDAO objeto = fabrica.getProfesorFactory().objeto();
		IAlumnoDAO ad = new AlumnoDAO();
		try {
			System.out.println(ad.selectAll());
			Alumno a = new Alumno();
			a.setApellido("ramires");
			a.setNombre("fabian");
			//ad.insertarAlumno(a);
			//ad.delete(1);
			System.out.println(objeto.selectAll());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	public void algo() {
		AbstractDaoFactoryImpl fabrica = AbstractDaoFactoryImpl.getInstance();
		IAlumnoDAO objeto = fabrica.getAlumoFactory().objeto();
	}
}
