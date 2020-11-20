package com.backend.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.backend.db.dto.Alumno;

public class AlumnoDAO implements IAlumnoDAO{

	private final String db = "jdbc:mysql://localhost:3306/backend";
	private final String user = "user";
	private final String pass = "pass";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	private void crearConexion() throws SQLException {

		con = DriverManager.getConnection(db, user, pass);
	}

	private void cerrarConexion() throws SQLException {

		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		if (con != null) {
			con.close();
		}
	}

	@Override
	public List<Alumno> selectAll() throws SQLException {
		List<Alumno> alumnos = new ArrayList<>();

		crearConexion();
		String query = "select * from Alumno";
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
			Alumno nuevo = new Alumno();
			nuevo.setApellido(rs.getString("apellido"));
			nuevo.setNombre(rs.getString("nombre"));
			nuevo.setId(rs.getInt("id"));
			alumnos.add(nuevo);
		}

		cerrarConexion();

		return alumnos;

	}

	@Override
	public void insert(Alumno dto) throws SQLException  {
			String query = "insert into Alumno (nombre, apellido) values(?,?)";
			crearConexion();
			ps = con.prepareStatement(query);
			ps.setString(1, dto.getNombre());
			ps.setString(2, dto.getApellido());
			ps.executeUpdate();
			cerrarConexion();
	}

	@Override
	public Alumno select(Integer id) throws SQLException{
		String query = "select id, nombre, apellido from Alumno where id = ?";
		crearConexion();
		ps = con.prepareStatement(query);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		Alumno nuevo = new Alumno();
		rs.next();
		nuevo.setApellido(rs.getString("apellido"));
		nuevo.setNombre(rs.getString("nombre"));
		nuevo.setId(rs.getInt("id"));
		cerrarConexion();
		return nuevo;
	}

	@Override
	public void update(Alumno dto) throws SQLException{
		String query = "update Alumnos set nombre = ? , apellido = ? where id = ?";
		crearConexion();
		ps = con.prepareStatement(query);
		ps.setString(1, dto.getNombre());
		ps.setString(2, dto.getApellido());
		ps.setInt(3, dto.getId());
		ps.executeUpdate();
		cerrarConexion();
	}

	@Override
	public void delete(Integer id) throws SQLException{
		String query = "delete from Alumno where id = ?";
		crearConexion();
		ps = con.prepareStatement(query);
		ps.setInt(1, id);
		ps.executeUpdate();
		cerrarConexion();
	}

}
