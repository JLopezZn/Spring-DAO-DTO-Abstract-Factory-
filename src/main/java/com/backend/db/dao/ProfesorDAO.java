package com.backend.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.backend.db.dto.Profesor;

public class ProfesorDAO implements IProfesorDAO {

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
	public List<Profesor> selectAll() throws SQLException {
		List<Profesor> profesores = new ArrayList<>();

		crearConexion();
		String query = "select * from profesor";
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
			Profesor nuevo = new Profesor();
			nuevo.setApellido(rs.getString("apellido"));
			nuevo.setNombre(rs.getString("nombre"));
			nuevo.setId(rs.getInt("id"));
			profesores.add(nuevo);
		}

		cerrarConexion();

		return profesores;
	}

	@Override
	public Profesor select(Integer id) throws SQLException {
		String query = "select * from profesor where id = ?";
		crearConexion();
		ps = con.prepareStatement(query);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		Profesor nuevo = new Profesor();
		nuevo.setApellido(rs.getString("apellido"));
		nuevo.setNombre(rs.getString("nombre"));
		nuevo.setId(rs.getInt("id"));
		cerrarConexion();
		return nuevo;
	}

	@Override
	public void update(Profesor dto) throws SQLException {
		String query = "update profesor set nombre = ? , apellido = ? where id = ?";
		crearConexion();
		ps = con.prepareStatement(query);
		ps.setString(1, dto.getNombre());
		ps.setString(2, dto.getApellido());
		ps.setInt(3, dto.getId());
		ps.executeUpdate();
		cerrarConexion();

	}

	@Override
	public void insert(Profesor dto) throws SQLException {
		String query = "insert into profesor (nombre, apellido) values(?,?)";
		crearConexion();
		ps = con.prepareStatement(query);
		ps.setString(1, dto.getNombre());
		ps.setString(2, dto.getApellido());
		ps.executeUpdate();
		cerrarConexion();

	}

	@Override
	public void delete(Integer id) throws SQLException {
		String query = "delete from profesor where id = ?";
		crearConexion();
		ps = con.prepareStatement(query);
		ps.setInt(1, id);
		ps.executeUpdate();
		cerrarConexion();

	}

}
