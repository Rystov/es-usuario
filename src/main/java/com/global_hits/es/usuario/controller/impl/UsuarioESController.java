package com.global_hits.es.usuario.controller.impl;

import java.sql.SQLException;
import java.util.List;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import com.global_hits.es.usuario.constants.TipoIdentificacionEnum;
import com.global_hits.es.usuario.controller.contract.IUsuarioContractES;
import com.global_hits.es.usuario.model.ErrorResponse;
import com.global_hits.es.usuario.model.User;
import com.global_hits.es.usuario.service.contract.IUsuarioService;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", 
date = "2020-07-21T21:48:02.202-05:00[America/Bogota]")


@RestController
@RequestMapping("${openapi.Servicios Entidad Usuario.base-path:/v1/es}")
public class UsuarioESController implements IUsuarioContractES {

	private final NativeWebRequest request;
	private static final Logger LOG = LoggerFactory.getLogger(UsuarioESController.class);
	

	@Autowired
	IUsuarioService svc;

	
	@Autowired
	public UsuarioESController(NativeWebRequest request) {
		this.request = request;
	}

	@Autowired
	public Optional<NativeWebRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	@Override
	public ResponseEntity<?> adduser(@Valid User body) {
		// TODO Auto-generated method stub
		LOG.info("MENSAJE DE adduser");
		 try {
			return ResponseEntity.ok(svc.adduser(body));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("ERROR EN EL SERVICIO {e}",e);
			e.printStackTrace();
			ErrorResponse Error=new ErrorResponse().code("006").message("Error en la capacidad solicitada").type("internal server error");
			return ResponseEntity.badRequest().body(Error);
		}
		
	}
	@Override
	public ResponseEntity<?> deleteUser(String userId) {
		// TODO Auto-generated method stub
		LOG.info("MENSAJE DE deleteUser");
		try {
			User obj=svc.getUserById(userId);
			if(obj==null) {
				ErrorResponse Error=new ErrorResponse().code("005").message("Usuario no existe").type("validacion");
				return ResponseEntity.badRequest().body(Error);	
			}
			svc.deleteUser(userId);
			return  ResponseEntity.ok("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("ERROR EN EL SERVICIO {e}",e);
			e.printStackTrace();
			ErrorResponse Error=new ErrorResponse().code("006").message("Error en la capacidad solicitada").type("internal server error");
			return ResponseEntity.badRequest().body(Error);	
		}
		
		
	}

	@Override
	public ResponseEntity<?> getUser() {
		// TODO Auto-generated method stub
		LOG.info("MENSAJE DE getUser");
		try {
			List<User> Lst=svc.getUser();
			if(Lst==null ) {
				ErrorResponse Error=new ErrorResponse().code("005").message("Usuario no existe").type("validacion");
				return ResponseEntity.badRequest().body(Error);	
			}
			return ResponseEntity.ok(Lst);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("ERROR EN EL SERVICIO {e}",e);
			e.printStackTrace();
			ErrorResponse Error=new ErrorResponse().code("006").message("Error en la capacidad solicitada").type("internal server error");
			return ResponseEntity.badRequest().body(Error);
		}
		
	}
	@Override
	public ResponseEntity<?> getUserById(String userId) {
		// TODO Auto-generated method stub
		LOG.info("MENSAJE DE getUserById");
		try {
			User obj=svc.getUserById(userId);
			if(obj==null) {
				ErrorResponse Error=new ErrorResponse().code("005").message("Usuario no existe").type("validacion");
				return ResponseEntity.badRequest().body(Error);	
			}
			return ResponseEntity.ok(obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("ERROR EN EL SERVICIO {e}",e);
			e.printStackTrace();
			ErrorResponse Error=new ErrorResponse().code("006").message("Error en la capacidad solicitada").type("internal server error");
			return ResponseEntity.badRequest().body(Error);
		}
		
	}

	@Override
	public ResponseEntity<?> updateUser(@Valid User body) {
		// TODO Auto-generated method stub
		LOG.info("MENSAJE DE updateUser");
		try {
			long valu=body.getId();
			User obj=svc.getUserById(body.getId().toString());
			if(obj==null) {
				ErrorResponse Error=new ErrorResponse().code("005").message("Usuario no existe").type("validacion");
				return ResponseEntity.badRequest().body(Error);	
			}
			 obj=svc.updateUser(body);
			 if(obj==null) {
					ErrorResponse Error=new ErrorResponse().code("005").message("inconvenientes para actualizar").type("validacion");
					return ResponseEntity.badRequest().body(Error);	
				}
			 obj.setId(valu);
			return ResponseEntity.ok(obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.error("ERROR EN EL SERVICIO {e}",e);
			e.printStackTrace();
			ErrorResponse Error=new ErrorResponse().code("006").message("Error en la capacidad solicitada").type("internal server error");
			return ResponseEntity.badRequest().body(Error);
		}
		
	}
		
}
