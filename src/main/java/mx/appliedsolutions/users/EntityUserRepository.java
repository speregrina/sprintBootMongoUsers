package mx.appliedsolutions.users;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntityUserRepository extends MongoRepository<EntityUser, String> {
	
	public EntityUser findByNombre(String nombre);
	public List<EntityUser> findByEmpresa(String empresa);
	public List<EntityUser> findByEmpresaLike(String empresa);
	public List<EntityUser> findByTelefono(String telefono);
	public List<EntityUser> findByCorreo(String correo);

}
