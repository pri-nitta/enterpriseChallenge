package br.fiap.prato.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.pratos.jdbc.ConnectionManager;
import br.com.fiap.pratos.jdbc.PratosDbManager;
import br.fiap.prato.entity.Prato;

public class PratoDAOImpl implements PratoDAO {

	private Connection conexao;
	PreparedStatement pstmt = null;

	@Override
	public void gravar(Prato prato) {
		try {
//			Connection conexao = PratosDbManager.obterConexao();
			conexao = ConnectionManager.getInstance().getConnection();
			System.out.println("Conectado!");

			PreparedStatement pstmt = conexao.prepareStatement("INSERT INTO T_PRATO "
					+ "(nm_prato, desc_prato, vl_prato, cd_restaurante, cd_tipo_comida, cd_estilo_cozinha)"
					+ " VALUES (?, ?, ?, ?, ?, ?)");

			pstmt.setString(1, "Wrap de Cogumelo");
			pstmt.setString(2, "Tortilla, recheio de cogumelo, queijo prato, alface e azeite.");
			pstmt.setInt(3, 24);
			pstmt.setInt(4, 8);
			pstmt.setInt(5, 2);
			pstmt.setInt(6, 8);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<Prato> buscarTodos() {
		List<Prato> pratos = new ArrayList<Prato>();
		ResultSet rs = null;
		try {
			conexao = PratosDbManager.obterConexao();
			pstmt = conexao.prepareStatement("SELECT * FROM T_PRATO");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Prato prato = new Prato(rs.getString("NM_PRATO"), rs.getString("DESC_PRATO"), rs.getFloat("VL_PRATO"),
						rs.getInt("CD_REST"), rs.getInt("cd_tipo_comida"), rs.getInt("cd_estilo_cozinha"));
				prato.add(prato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Prato buscarTodosPorCodigo(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(Prato prato) {
		
		try {
			conexao = PratosDbManager.obterConexao();
			pstmt = conexao.prepareStatement("UPDATE T_PRATO SET NM_PRATO =?, DESC_PRATO = ?, VL_PRATO = ?, CD_REST =?, CD_TIPO_COMIDA =?,   WHERE CD_PRATO = ?");
			pstmt.setString(1, prato.getNome());
			pstmt.setString(2, prato.getDescricao());
			pstmt.setFloat(3, prato.getValor());
			pstmt.setInt(4, prato.getCod_rest());
			pstmt.setInt(5, prato.getCod_tipo_comida());
			pstmt.setInt(6, prato.getCd_estilo_cozinha());
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void remover(int codigo) {
		try {
			conexao = PratosDbManager.obterConexao();
			pstmt = conexao.prepareStatement("DELETE FROM T_PRATO WHERE CD_PRATO = ?");
			pstmt.setInt(1, codigo);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
