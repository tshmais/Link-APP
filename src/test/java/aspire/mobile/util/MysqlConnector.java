package aspire.mobile.util;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;

import jo.aspire.generic.EnvirommentManager;

import org.apache.commons.digester.parser.GenericParser;
import org.jbehave.core.annotations.AfterStories;
import org.json.JSONArray;
import org.json.JSONObject;


	public class MysqlConnector {
		GenericParser parser;

		public  String dbUrl = EnvirommentManager.getInstance().getProperty("dbURL");
		// Database Username
		public  String username = EnvirommentManager.getInstance().getProperty("dbUsername");
		// Database Password
		public  String password = EnvirommentManager.getInstance().getProperty("dbPassword");
		

		public  String dbUrlint = EnvirommentManager.getInstance().getProperty("dbURLint");
		// Database Username
		public  String usernameint = EnvirommentManager.getInstance().getProperty("dbUsernameint");
		// Database Password
		public  String passwordint= EnvirommentManager.getInstance().getProperty("dbPasswordint");

		public static java.sql.Connection con;
		String environment;
		
		
		
		

		public  boolean dbOpenConn() throws ClassNotFoundException, SQLException {

			
			try {
				// Create Connection to DB
				Class.forName("com.mysql.jdbc.Driver");
				
					con = DriverManager.getConnection(dbUrl, username, password);
					System.err.println("CONNECT TO DATABASE");
				
				
			}

			catch (Exception e) {
				e.printStackTrace();
				System.err.println("Cannot connect");
				return false;
			}

			return true;
		}
		
		public  boolean dbcloseConn(){
			 try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Cannot close");
				return false;
			}
			 System.err.println("Connection closed");
			 return true;
		}
		 

		/*
		 * public List<String> ExecuteSpecificQuery(String Query) throws
		 * SQLException, ClassNotFoundException{
		 * 
		 * try{ //Create Statement Object Statement stmt = con.createStatement(); //
		 * Execute the SQL Query. Store results in ResultSet ResultSet rs=
		 * stmt.executeQuery(Query);
		 * 
		 * // While Loop to iterate through all data and print results while
		 * (rs.next()){ String Data = rs.getString(1); System. out.print(
		 * "The Data is "+Data+"  "); System. out.print("\n");
		 * 
		 * } }
		 * 
		 * catch(Exception e){ e.printStackTrace(); System.err.println(
		 * "Cannot connect"); } return rowList; }
		 */
		public String GetResultAsJSONObject(String Query) throws SQLException {
			
			try
			{

				// Create Statement Object
				Statement stmt = con.createStatement();
				// Execute the SQL Query. Store results in ResultSet
				ResultSet rs = stmt.executeQuery(Query);
				System.err.println("Executing the query please wait ...");
				ResultSetMetaData rsmd = null;
				rsmd = (ResultSetMetaData) rs.getMetaData();
				int columnsCount = rsmd.getColumnCount();
				JSONArray json = new JSONArray();
			    while(rs.next()) {
			      int numColumns = rsmd.getColumnCount();
			      JSONObject obj = new JSONObject();

			      for (int i=1; i<numColumns+1; i++) {
			        String column_name = rsmd.getColumnName(i);

			        if(rsmd.getColumnType(i)==java.sql.Types.ARRAY){
			         obj.put(column_name, rs.getArray(column_name));
			        }
			        else if(rsmd.getColumnType(i)==java.sql.Types.BIGINT){
			         obj.put(column_name, rs.getInt(column_name));
			        }
			        else if(rsmd.getColumnType(i)==java.sql.Types.BOOLEAN){
			         obj.put(column_name, rs.getBoolean(column_name));
			        }
			        else if(rsmd.getColumnType(i)==java.sql.Types.BLOB){
			         obj.put(column_name, rs.getBlob(column_name));
			        }
			        else if(rsmd.getColumnType(i)==java.sql.Types.DOUBLE){
			         obj.put(column_name, rs.getDouble(column_name)); 
			        }
			        else if(rsmd.getColumnType(i)==java.sql.Types.FLOAT){
			         obj.put(column_name, rs.getFloat(column_name));
			        }
			        else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
			         obj.put(column_name, rs.getInt(column_name));
			        }
			        else if(rsmd.getColumnType(i)==java.sql.Types.NVARCHAR){
			         obj.put(column_name, rs.getNString(column_name));
			        }
			        else if(rsmd.getColumnType(i)==java.sql.Types.VARCHAR){
			         obj.put(column_name, rs.getString(column_name));
			        }
			        else if(rsmd.getColumnType(i)==java.sql.Types.TINYINT){
			         obj.put(column_name, rs.getInt(column_name));
			        }
			        else if(rsmd.getColumnType(i)==java.sql.Types.SMALLINT){
			         obj.put(column_name, rs.getInt(column_name));
			        }
			        else if(rsmd.getColumnType(i)==java.sql.Types.DATE){
			         obj.put(column_name, rs.getDate(column_name));
			        }
			        else if(rsmd.getColumnType(i)==java.sql.Types.TIMESTAMP){
			        obj.put(column_name, rs.getTimestamp(column_name));   
			        }
			        else{
			         obj.put(column_name, rs.getObject(column_name));
			        }
			      }

			      json.put(obj);
			}
			    return null;
			}   

				catch (Exception e) {
					e.printStackTrace();
					System.err.println("Cannot connect");
					return null;
				}
			
			
			
			////////// 
		/*	List<Map<String, Object>> listOfMaps = null;
			
			try {
				QueryRunner queryRunner = new QueryRunner();
				listOfMaps = queryRunner.query(con, Query, new MapListHandler());
				return new Gson().toJson(listOfMaps);*/
				
				/*JSONObject obj = new JSONObject();
				// Create Statement Object
				Statement stmt = con.createStatement();
				// Execute the SQL Query. Store results in ResultSet
				ResultSet rs = stmt.executeQuery(Query);
				System.err.println("Executing the query please wait ...");
				ResultSetMetaData rsmd = null;
				rsmd = (ResultSetMetaData) rs.getMetaData();
				int columnsCount = rsmd.getColumnCount();

				for (int j = 1; j <= columnsCount; j++) {
					System.err.print(rsmd.getColumnName(j) + " || ");
				}

				while (rs.next()) {
					int total_rows = rs.getMetaData().getColumnCount();

					for (int i = 0; i < total_rows; i++) {
						String columnName = rs.getMetaData().getColumnLabel(i + 1).toLowerCase();
						 Object columnValue = rs.getObject(columnName); 
						Object columnValue = rs.getObject(columnName);

						// if value in DB is null, then we set it to default value
						if (columnValue == null) {
							columnValue = "null";
						}
						obj.put(columnName, columnValue);

					}
					System.out.print("\n");
					System.out.print("\n");
					System.out.print("\n");
				}
				System.out.print("\n");
				System.out.print(obj);
				System.out.print("\n");
				System.out.print("\n");

				String replacementString1 = "\"[";
				String replacementString2 = "]\"";
				String jsonActual = obj.toString().replace(replacementString1, "[").replace(replacementString2, "]");
				System.err.println(jsonActual);
				System.out.print("\n");
				System.out.print(jsonActual);
				System.out.print("\n");
				System.out.print("\n");
				return jsonActual;
			}

			catch (Exception e) {
				e.printStackTrace();
				System.err.println("Cannot connect");
				return null;
			}*/
		}

		public  ArrayList<String> ExecuteAPIQuery(String Query) throws SQLException, ClassNotFoundException {
		 ArrayList<String> rowList = new ArrayList<String>();
			try {
				// Create Statement Object
				Statement stmt = con.createStatement();
				// Execute the SQL Query. Store results in ResultSet
				ResultSet rs = stmt.executeQuery(Query);
				System.err.println("Executing the query please wait ...");
				ResultSetMetaData rsmd = null;
				rsmd = (ResultSetMetaData) rs.getMetaData();
				int columnsCount = rsmd.getColumnCount();

				for (int j = 1; j <= columnsCount; j++) {
					System.err.print(rsmd.getColumnName(j) + " || ");
				}
				System.out.print("\n");
				System.out.print("\n");
				System.out.print("\n");
				// While Loop to iterate through all data and print results
				while (rs.next()) {
					for (int i = 1; i <= columnsCount; i++) {
						String Data = rs.getString(i);
						rowList.add(Data);
						System.err.print(Data + " || ");
					}
					System.out.print("\n");
				}
			}

			catch (Exception e) {
				e.printStackTrace();
				System.err.println("ERROR!!! Please check the query statement");
				return null;
			}
			return rowList;
		}
		
		  
		
	}


