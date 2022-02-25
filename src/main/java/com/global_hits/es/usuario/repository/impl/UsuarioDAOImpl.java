package com.global_hits.es.usuario.repository.impl;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.text.html.HTMLEditorKit.Parser;

import org.apache.velocity.runtime.directive.Parse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.global_hits.es.usuario.constants.UsuarioConstants;
import com.global_hits.es.usuario.model.User;
import com.global_hits.es.usuario.repository.contract.IUsuarioDAO;

import com.global_hits.es.usuario.utils.Conexion;




@Repository
public class UsuarioDAOImpl implements IUsuarioDAO {
	private static final String SP = "{call globalhits.dbo.SP_GESTION_USUARIO(?,?,?,?,?,?,?)}";
	@Autowired
	Conexion conexionBean;
	@Override
	public User adduser(User body) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection connection = this.conexionBean.getConnection();
		CallableStatement cs = connection.prepareCall(SP);
		cs.setInt("@id",0 );
		cs.setString("@Opt","INSERT" );
		cs.setString("@email",body.getEmail() );
		cs.setString("@firstName",body.getFirstName() );
		cs.setString("@lastName",body.getLastName() );
		cs.setString("@phone",body.getPhone());
		cs.setString("@userName",body.getUserName() );
		cs.execute();
		ResultSet rs = cs.getResultSet();
		
		while (rs!=null && rs.next()) {
			return new User().email(rs.getString("email")).firstName(rs.getString("firstName"))
					.lastName(rs.getString("lastName")).phone(rs.getString("phone"))
					.userName(rs.getString("userName")).id((long) Integer.parseInt(rs.getString("id")));
		}
		
		return body;
		
	}

	@Override
	public void deleteUser(String userId) throws SQLException {
		Connection connection = this.conexionBean.getConnection();
				CallableStatement cs = connection.prepareCall(SP);

			cs.setInt("@id",Integer.parseInt(userId) );
			cs.setString("@Opt","DELETE" );
			cs.setString("@email","" );
			cs.setString("@firstName","" );
			cs.setString("@lastName","" );
			cs.setString("@phone","");
			cs.setString("@userName","" );
	        
			cs.execute();

								

	}

	@Override	
	public List<User> getUser() throws SQLException {
		List<User> lst= new  ArrayList<User>();
		Connection connection = this.conexionBean.getConnection();
		CallableStatement cs = connection.prepareCall(SP);
		cs.setString("@Opt","SELECT" );
		cs.setString("@email","" );
		cs.setString("@firstName","" );
		cs.setString("@lastName","" );
		cs.setString("@phone","");
		cs.setString("@userName","" );
        cs.setInt("@id",0 );
		cs.execute();
		 
		ResultSet rs = cs.getResultSet();
		while (rs!=null && rs.next()) {
			lst.add(new User().email(rs.getString("email")).firstName(rs.getString("firstName"))
					.lastName(rs.getString("lastName")).phone(rs.getString("phone"))
					.userName(rs.getString("userName")).id((long) Integer.parseInt(rs.getString("id"))));
			
			
		}
		

		return lst;
	}

	@Override
	public User getUserById(String userId) throws SQLException {
		Connection connection = this.conexionBean.getConnection();
		CallableStatement cs = connection.prepareCall(SP);
		cs.setInt("@id",Integer.parseInt(userId) );
		cs.setString("@Opt","SELECTBYID" );
		cs.setString("@email","" );
		cs.setString("@firstName","" );
		cs.setString("@lastName","" );
		cs.setString("@phone","");
		cs.setString("@userName","" );
        
		cs.execute();
		ResultSet rs = cs.getResultSet();
		while (rs!=null && rs.next()) {
			return new User().email(rs.getString("email")).firstName(rs.getString("firstName"))
					.lastName(rs.getString("lastName")).phone(rs.getString("phone"))
					.userName(rs.getString("userName")).id((long) Integer.parseInt(rs.getString("id")));
			
		}
		
		return null;
	}

	@Override
	public User updateUser(User body) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection connection = this.conexionBean.getConnection();
		CallableStatement cs = connection.prepareCall(SP);
		cs.setInt("@id",Integer.parseInt(body.getId().toString()) );
		cs.setString("@Opt","UPDATE" );
		cs.setString("@email",body.getEmail() );
		cs.setString("@firstName",body.getFirstName() );
		cs.setString("@lastName",body.getLastName() );
		cs.setString("@phone",body.getPhone());
		cs.setString("@userName",body.getUserName() );
		

		cs.execute();

			return body;
	
	}

	
}
