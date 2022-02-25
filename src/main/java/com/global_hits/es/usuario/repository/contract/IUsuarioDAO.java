package com.global_hits.es.usuario.repository.contract;

import java.sql.SQLException;
import java.util.List;

import com.global_hits.es.usuario.model.User;



public interface IUsuarioDAO {


public User adduser( User body) throws SQLException ;
	
	public void deleteUser(String userId) throws SQLException ;

	
	public List<User> getUser() throws SQLException ;
	
	
	public User getUserById(String userId) throws SQLException;

	
	public User updateUser( User body) throws SQLException ;

}
