package net.cibertec.instituto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import net.cibertec.instituto.entity.Docente;
import net.cibertec.instituto.interfaces.DocenteDAO;
import net.cibertec.instituto.utils.MySqlConexion;

public class MySqlDocenteDAO implements DocenteDAO {

	@Override
	public int save(Docente bean) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		
		try {
			//1
			cn = MySqlConexion.getConexion();
			//2
			String sql = "insert into tb_docente values(null,?,?,?,?,?,?)";
			//3
			pstm = cn.prepareStatement(sql);
			//4
			pstm.setString(1, bean.getNombre());
			pstm.setString(2, bean.getPaterno());
			pstm.setString(3, bean.getMaterno());
			pstm.setString(4, bean.getSexo());
			pstm.setInt(5, bean.getHijos());
			pstm.setDouble(6, bean.getSueldo());
			//5
			salida = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) pstm.close();
				if(cn != null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return salida;
	}

	@Override
	public int update(Docente bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(int cod) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Docente buscar(int cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Docente> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
