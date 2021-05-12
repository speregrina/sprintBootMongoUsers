package mx.appliedsolutions.users;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceUser {

	@Autowired
	private EntityUserRepository repository;
	//Logger log = Logger.getAnonymousLogger("UserRepository");
	
	@GetMapping("/findByName")
	public ResponseEntity<EntityUser> getFindByName(@RequestParam(value="name") String name){
		EntityUser usr =repository.findByNombre(name);
		if(usr!= null)
			return new ResponseEntity<>(usr, HttpStatus.OK);
		else
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/findByCompany")
	public ResponseEntity<List<EntityUser>> getFindByCompany(@RequestParam(value="company") String company){
		return new ResponseEntity<List<EntityUser>>(repository.findByEmpresaLike(company),HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<EntityUser>> getAll(){
		List<EntityUser> list=repository.findAll();
		if(list!=null && list.size()>0)
				return new ResponseEntity<List<EntityUser>>(list,HttpStatus.OK);
		else
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/newuser")
	public ResponseEntity<EntityUser> newUser(@RequestBody EntityUser user) {
		//System.out.println("I'm registry new user controller method");
		System.out.println("user "+user.toString());
		return new ResponseEntity<EntityUser>(repository.insert(user),HttpStatus.OK);
	}
	
	@PutMapping("/user/{name}")
	public ResponseEntity<EntityUser> replaceEmployee(@RequestBody EntityUser user, @PathVariable String name) {
		EntityUser employee=  repository.findByNombre(name);
		if(employee != null) {
			employee.empresa = user.empresa;
	        employee.correo  = user.correo;
	        employee.telefono=user.telefono;
	        //return repository.save(employee);
	        return new ResponseEntity<EntityUser>(repository.save(employee),HttpStatus.OK);
		}
		else {
			return new  ResponseEntity<EntityUser>(new EntityUser(),HttpStatus.NOT_FOUND);
		}
	  }

	  @DeleteMapping("/user/{name}")
	  public void deleteEmployee(@PathVariable String name) {
		  EntityUser usr = repository.findByNombre(name);
		  if ( usr != null )
			  repository.delete(usr);
	  }
	  
}
