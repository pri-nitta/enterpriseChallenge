package br.com.fiap.pratos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class PratosDbManager {

	public static Connection obterConexao() {
		Connection conexao = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM87840",
					"130990");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conexao;
	}
}