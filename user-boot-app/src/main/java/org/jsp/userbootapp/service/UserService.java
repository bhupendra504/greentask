package org.jsp.userbootapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.userbootapp.dao.UserDao;
import org.jsp.userbootapp.dto.ResponseStructure;
import org.jsp.userbootapp.dto.User;
import org.jsp.userbootapp.exception.IdNotFoundException;
import org.jsp.userbootapp.exception.InvalidCredentialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
public class UserService {
	//Using ResponseEntity
	@Autowired
	private UserDao dao;
	public ResponseEntity<ResponseStructure<User>> saveUser(User user)
	{
		ResponseStructure<User> structure=new ResponseStructure<User>();
		structure.setMessage("user registered succesfully");
		structure.setBody(dao.saveUser(user));
		structure.setCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user)
	{
		ResponseStructure<User> structure=new ResponseStructure<User>();
		structure.setMessage("user Updated succesfully");
		structure.setBody(dao.updateUser(user));
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
		
	}
	
	public ResponseEntity<ResponseStructure<List<User>>> findAll()
	{
		ResponseStructure<List<User>> structure=new ResponseStructure<List<User>>();
		structure.setBody(dao.findAll());
		structure.setMessage("ALL User are Displayed");
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteUser(int id)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		Optional<User> recUser=dao.findUser(id);
		if(recUser.isPresent())
		{
			dao.deleteUser(id);
			structure.setBody("User deleted");
			structure.setMessage("User Found");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	

	public ResponseEntity<ResponseStructure<User>> verifyUser(long phone,String password)
	{
		ResponseStructure<User> structure=new ResponseStructure<>();
		Optional<User> recUser=dao.verifyUser(phone, password);
		if(recUser.isPresent())
		{
			structure.setBody(recUser.get());
			structure.setMessage("User verify succesfully");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialException();
	}
	
	public ResponseEntity<ResponseStructure<User>> findUser(int id)
	{
		ResponseStructure<User> structure=new ResponseStructure<User>();
		Optional<User> recUser=dao.findUser(id);
		if(recUser.isPresent())
		{
			structure.setBody(recUser.get());
			structure.setMessage("user found");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<User>> verifyUser(String email,String password)
	{
		ResponseStructure<User> structure=new ResponseStructure<>();
		Optional<User> recUser=dao.verifyUser(email, password);
		if(recUser.isPresent())
		{
			structure.setBody(recUser.get());
			structure.setMessage("User verify succesfully");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialException();
	}
	
	
	
//	public ResponseEntity<ResponseStructure<User>> findUser(int id)
//	{
//		ResponseStructure<User> structure=new ResponseStructure<User>();
//		Optional<User> recUser=dao.findUser(id);
//		if(recUser.isPresent())
//		{
//			structure.setBody(recUser.get());
//			structure.setMessage("user found");
//			structure.setCode(HttpStatus.OK.value());
//			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
//		}
//		structure.setBody(null);
//		structure.setMessage("User Not Found");
//		structure.setCode(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);
//		
//	}
	

	
	
//	public ResponseEntity<ResponseStructure<String>> deleteUser(int id)
//	{
//		ResponseStructure<String> structure=new ResponseStructure<>();
//		Optional<User> recUser=dao.findUser(id);
//		if(recUser.isPresent())
//		{
//			dao.deleteUser(id);
//			structure.setBody("User deleted");
//			structure.setMessage("User Found");
//			structure.setCode(HttpStatus.OK.value());
//			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
//		}
//		structure.setBody("user Not Delete");
//		structure.setMessage("User Not found");
//		structure.setCode(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
//	}
//	
	
	

	
	
	
//	public ResponseEntity<ResponseStructure<User>> verifyUser(long phone,String password)
//	{
//		ResponseStructure<User> structure=new ResponseStructure<>();
//		Optional<User> recUser=dao.verifyUser(phone, password);
//		if(recUser.isPresent())
//		{
//			structure.setBody(recUser.get());
//			structure.setMessage("User verify succesfully");
//			structure.setCode(HttpStatus.OK.value());
//			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
//		}
//		structure.setBody(null);
//		structure.setMessage("Invaild phone and password");
//		structure.setCode(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
//	}
	
//	public ResponseEntity<ResponseStructure<User>> verifyUser(String email,String password)
//	{
//		ResponseStructure<User> structure=new ResponseStructure<>();
//		Optional<User> recUser=dao.verifyUser(email, password);
//		if(recUser.isPresent())
//		{
//			structure.setBody(recUser.get());
//			structure.setMessage("User verify succesfully");
//			structure.setCode(HttpStatus.OK.value());
//			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
//		}
//		structure.setBody(null);
//		structure.setMessage("Invaild email and password");
//		structure.setCode(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
//	}
	
	
	
	
	
	
//	//Using ResponseStructure
//	@Autowired
//	private UserDao dao;
//	
//	public ResponseEResponseStructure<User> saveUser(User user)
//	{
//		ResponseStructure<User> structure=new ResponseStructure<User>();
//		structure.setMessage("user registered succesfully");
//		structure.setBody(dao.saveUser(user));
//		structure.setCode(HttpStatus.CREATED.value());
//		return structure;
//	}
//	
//	public ResponseStructure<User> updateUser(User user)
//	{
//		ResponseStructure<User> structure=new ResponseStructure<User>();
//		structure.setMessage("user Updated succesfully");
//		structure.setBody(dao.updateUser(user));
//		structure.setCode(HttpStatus.ACCEPTED.value());
//		return structure;
//	}
//	
//	public ResponseStructure<User> findUser(int id)
//	{
//		ResponseStructure<User> structure=new ResponseStructure<User>();
//		Optional<User> recUser=dao.findUser(id);
//		if(recUser.isPresent())
//		{
//			structure.setBody(recUser.get());
//			structure.setMessage("user found");
//			structure.setCode(HttpStatus.OK.value());
//			return structure;
//		}
//		structure.setBody(null);
//		structure.setMessage("User Not Found");
//		structure.setCode(HttpStatus.NOT_FOUND.value());
//		return structure;
//	}
//	
//	public ResponseStructure<List<User>> findAll()
//	{
//		ResponseStructure<List<User>> structure=new ResponseStructure<List<User>>();
//		structure.setBody(dao.findAll());
//		structure.setMessage("ALL User are Displayed");
//		structure.setCode(HttpStatus.OK.value());
//		return structure;
//		
//	}
//	
//	public ResponseStructure<String> deleteUser(int id)
//	{
//		ResponseStructure<String> structure=new ResponseStructure<>();
//		Optional<User> recUser=dao.findUser(id);
//		if(recUser.isPresent())
//		{
//			dao.deleteUser(id);
//			structure.setBody("User deleted");
//			structure.setMessage("User Found");
//			structure.setCode(HttpStatus.OK.value());
//			return structure;
//		}
//		structure.setBody("user Not Delete");
//		structure.setMessage("User Not found");
//		structure.setCode(HttpStatus.NOT_FOUND.value());
//		return structure;
//	}
	
	
	
	
	
	  //using service method
	
//	@Autowired
//	private UserDao dao;
//	
//	public User saveUser(User user)
//	{
//		return dao.saveUser(user);
//	}
//	
//	public User updateUser(User user)
//	{
//		return dao.updateUser(user);
//	}
//	
//	public User findUser(int id)
//	{
//		Optional<User> recUser=dao.findUser(id);
//		if(recUser.isPresent())
//			return recUser.get();
//		return null;
//	}
//	
//	public List<User> findAll()
//	{
//		return dao.findAll();
//	}
//	
//	public String deleteUser(int id)
//	{
//		Optional<User> recUser=dao.findUser(id);
//		if(recUser.isPresent())
//		{
//			dao.deleteUser(id);
//			return"user deleted";
//		}
//		return "Cannot delete user";
//	}

}
