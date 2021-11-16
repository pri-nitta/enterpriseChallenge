package br.fiap.prato.dao;

//abstract não precisa ser instanciada
public abstract class DAOFactory {
	
	public static PratoDAO getPratoDAO() {
		return new PratoDAOImpl();
	}
	
//	//em caso de 2 banco de dados
//	public static final int SQL_SERVER = 1;
//	public static final int ORACLE = 2;
//	
//	private static oracleDAOFactory oracleDAOFactory;
//	private static sqlDAOFactory sqlDAOFactory;
//	
//	public static DAOFactory getDAOFactory(int db) {
//		switch (db) {
//		case SQL_SERVER:
//			if (sqlDAOFactory == null)
//				sqlDAOFactory = new SQLDAOFactory();
//			return sqlDAOFactory;
//			
//		case ORACLE:
//			if(oracleDAOFactory == null)
//				oracleDAOFactory = new OracleDAOFactory();
//			return oracleDAOFactory;
//			defaut:
//				return null;
//		}
//	}
}
