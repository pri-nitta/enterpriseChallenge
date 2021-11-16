package br.com.fiap;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.fiap.pratos.jdbc.PratosDbManager;

public class TestView {

	public static void main(String[] args) {

		try {
			Connection conexao = PratosDbManager.obterConexao();
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

//			pstmt = conexao.prepareStatement("UPDATE T_PRATO SET VL_PRATO = ? WHERE CD_ESTILO_COZINHA = ?");
//			pstmt.setFloat(1, 8);
//			pstmt.setInt(2, 8);
//			pstmt.executeUpdate();
//
//			pstmt = conexao.prepareStatement("DELETE FROM T_PRATO WHERE CD_PRATO = ?");
//			pstmt.setInt(1, 2);
//			pstmt.executeUpdate();
//					

//			Statement stmt = conexao.createStatement();
//			stmt.executeUpdate("INSERT INTO T_RESTAURANTE (  cd_restaurante, nm_restaurante, nr_cnpj, vl_pedido_min)"
//					+ " VALUES (seq_rest.NEXTVAL, 'San do it', 85296374169, 15)");

//			ResultSet result = pstmt
//					.executeQuery("SELECT * FROM T_PRATO INNER JOIN T_ESTILO_COZINHA USING (CD_COZINHA = 3)");
//			while (result.next()) {
//				System.out.println(result.getInt("cd_prato") + " " + result.getString("nm_prato") + " "
//						+ result.getInt("vl_prato") + " " + result.getInt("cd_restaurante") + " "
//						+ result.getString("nm_tipo") + " " + result.getString("NM_cozinha"));
//			}
//			
//			CallableStatement cs = conexao.prepareCall("{call SP_INSERT_RESTAURANTE(?, ?, ?)}");
//			cs.setString(1, "Applebees");
//			cs.setString(2, "74196385272");
//			cs.setInt(3, 15);
//			cs.executeUpdate();

			conexao.close();

		} catch (SQLException e) {
			System.err.println("Não foi possível conectar com Oracle FIAP");
			e.printStackTrace();
		}

	}
}
