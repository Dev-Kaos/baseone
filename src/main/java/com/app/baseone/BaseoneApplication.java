package com.app.baseone;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.baseone.security.domain.entity.PermissionEntity;
import com.app.baseone.security.domain.entity.RoleEntity;
import com.app.baseone.security.persistence.repository.IPermissionRepository;
import com.app.baseone.security.persistence.repository.IRoleRepository;
import com.app.baseone.security.persistence.repository.IUserBasicAuthRepository;
import com.app.baseone.users.domain.entity.UserEntity;
import com.app.baseone.users.persistence.repository.IUserRepository;
import com.app.baseone.utilities.enums.DocTypeEnum;
import com.app.baseone.utilities.enums.GenderEnum;
import com.app.baseone.utilities.enums.RoleEnum;
import com.app.baseone.utilities.enums.StateEnum;

@SpringBootApplication
public class BaseoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseoneApplication.class, args);
	}

	@Bean
	CommandLineRunner init(IUserRepository userRepository, IPermissionRepository permissionRepository,
			IRoleRepository roleRepository) {

		return args -> {

			// System.out.println("Hello World");

			// TODO: Permisos

			PermissionEntity crearPermission = new PermissionEntity();
			crearPermission.setName("CREAR");
			permissionRepository.save(crearPermission);

			PermissionEntity leerPermission = new PermissionEntity();
			leerPermission.setName("LEER");
			permissionRepository.save(leerPermission);

			PermissionEntity actualizarPermission = new PermissionEntity();
			actualizarPermission.setName("ACTUALIZAR");
			permissionRepository.save(actualizarPermission);

			PermissionEntity borrarPermission = new PermissionEntity();
			borrarPermission.setName("BORRAR");
			permissionRepository.save(borrarPermission);

			PermissionEntity modificarPermission = new PermissionEntity();
			modificarPermission.setName("MODIFICAR");
			permissionRepository.save(modificarPermission);

			PermissionEntity evaluarPermission = new PermissionEntity();
			evaluarPermission.setName("EVALUAR");
			permissionRepository.save(evaluarPermission);

			PermissionEntity administrarPermission = new PermissionEntity();
			administrarPermission.setName("ADMINISTAR");
			permissionRepository.save(administrarPermission);

			PermissionEntity pagarPermission = new PermissionEntity();
			pagarPermission.setName("PAGAR");
			permissionRepository.save(pagarPermission);

			PermissionEntity realizarPermission = new PermissionEntity();
			realizarPermission.setName("REALIZAR");
			permissionRepository.save(realizarPermission);

			PermissionEntity desarrollarPermission = new PermissionEntity();
			desarrollarPermission.setName("DESAROLLAR");
			permissionRepository.save(desarrollarPermission);

			PermissionEntity consultarPermission = new PermissionEntity();
			consultarPermission.setName("CONSULTAR");
			permissionRepository.save(consultarPermission);

			// PermissionEntity crearPermission = PermissionEntity.builder()
			// .name("CREAR")
			// .build();

			// PermissionEntity leerPermission = PermissionEntity.builder()
			// .name("LEER")
			// .build();

			// PermissionEntity actualizarPermission = PermissionEntity.builder()
			// .name("ACTUALIZAR")
			// .build();

			// PermissionEntity borrarPermission = PermissionEntity.builder()
			// .name("BORRAR")
			// .build();

			// PermissionEntity modificarPermission = PermissionEntity.builder()
			// .name("MODIFICAR")
			// .build();
			// PermissionEntity evaluarPermission = PermissionEntity.builder()
			// .name("EVALUAR")
			// .build();
			// PermissionEntity administrarPermission = PermissionEntity.builder()
			// .name("ADMINISTAR")
			// .build();
			// PermissionEntity pagarPermission = PermissionEntity.builder()
			// .name("PAGAR")
			// .build();
			// PermissionEntity realizarPermission = PermissionEntity.builder()
			// .name("REALIZAR")
			// .build();
			// PermissionEntity desarrollarPermission = PermissionEntity.builder()
			// .name("DESAROLLAR")
			// .build();

			// permissionRepository.saveAll(
			// Set.of(leerPermission, crearPermission, actualizarPermission,
			// borrarPermission, modificarPermission,
			// evaluarPermission, administrarPermission, realizarPermission,
			// desarrollarPermission));

			// TODO: Roles

			RoleEntity administradorRole = new RoleEntity();
			administradorRole.setName(RoleEnum.ADMINISTRADOR);
			administradorRole.setPermissionList(Set.of(crearPermission, administrarPermission, leerPermission,
					modificarPermission, actualizarPermission, borrarPermission));
			roleRepository.save(administradorRole);

			RoleEntity profesorRole = new RoleEntity();
			profesorRole.setName(RoleEnum.PROFESOR);
			profesorRole.setPermissionList(Set.of(evaluarPermission, leerPermission, actualizarPermission,
					borrarPermission));
			roleRepository.save(profesorRole);

			RoleEntity alumnoRole = new RoleEntity();
			alumnoRole.setName(RoleEnum.ALUMNO);
			alumnoRole.setPermissionList(Set.of(realizarPermission, leerPermission, actualizarPermission));
			roleRepository.save(alumnoRole);

			RoleEntity acudienteRole = new RoleEntity();
			acudienteRole.setName(RoleEnum.ACUDIENTE);
			acudienteRole.setPermissionList(Set.of(pagarPermission, leerPermission, actualizarPermission));
			roleRepository.save(acudienteRole);

			RoleEntity desarrolladorRole = new RoleEntity();
			desarrolladorRole.setName(RoleEnum.DESARROLLADOR);
			desarrolladorRole.setPermissionList(
					Set.of(crearPermission, desarrollarPermission, administrarPermission,
							evaluarPermission, pagarPermission, leerPermission, modificarPermission,
							actualizarPermission, borrarPermission));
			roleRepository.save(desarrolladorRole);


			// TODO: date formatter
			String strDate = "2024-05-24"; // String representation of date
			DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE; // ISO-8601 date format

			// Parse the String into a LocalDate object
			LocalDate localDate = LocalDate.parse(strDate, formatter);

			// TODO: developer

			UserEntity userManuel = new UserEntity();
			userManuel.setName("manuel");
			userManuel.setSurname("vela");
			userManuel.setDocType(DocTypeEnum.CEDULA_CIUDADANIA);
			userManuel.setDocNumber("12345678");
			userManuel.setBirthDate(localDate);
			userManuel.setEmail("email@gmail.com");
			userManuel.setPhone("3452345235");
			userManuel.setGender(GenderEnum.MASCULINO);
			userManuel.setProfileImage("urldelaImagen");
			userManuel.setNickname("kaos");
			userManuel.setState(StateEnum.ACTIVO);
			userManuel.setUsername("manuel");
			userManuel.setPassword("1234");
			userManuel.setEnabled(true);
			userManuel.setAccountNoExpired(true);
			userManuel.setAccountNoLocked(true);
			userManuel.setCredentialNoExpired(true);
			userManuel.setRoles(Set.of(administradorRole, desarrolladorRole));
			userRepository.save(userManuel);



			// UserEntity userFernando = new UserEntity();
			// userFernando.setName("fernando");
			// userFernando.setSurname("osorio");
			// userFernando.setDocType(DocTypeEnum.TARJETA_IDENTIDAD);
			// userFernando.setDocNumber("34563456");
			// userFernando.setBirthDate(localDate);
			// userFernando.setEmail("email@gmail.com");
			// userFernando.setPhone("3452345235");
			// userFernando.setGender(GenderEnum.MASCULINO);
			// userFernando.setProfileImage("urldelaImagen");
			// userFernando.setNickname("fercho");
			// userFernando.setState(StateEnum.ACTIVO);
			// userFernando.setUsername("fernando");
			// userFernando.setPassword("1234");
			// userFernando.setEnabled(true);
			// userFernando.setAccountNoExpired(true);
			// userFernando.setAccountNoLocked(true);
			// userFernando.setCredentialNoExpired(true);
			// userFernando.setRoles(Set.of(alumnoRole, profesorRole));
			// userRepository.save(userFernando);
			

			
			

			// UserEntity userManuel = UserEntity.builder()
			// 		.name("manuel")
			// 		.surname("vela")
			// 		.docType(DocTypeEnum.CEDULA_CIUDADANIA)
			// 		.docNumber("12345678")
			// 		.birthDate(localDate)
			// 		.email("email@gmail.com")
			// 		.phone("3452345235")
			// 		.gender(GenderEnum.MASCULINO)
			// 		.profileImage("urldelaImagen")
			// 		.nickname("kaos")
			// 		.state(StateEnum.ACTIVO)
			// 		.username("manuel")
			// 		.password("1234")
			// 		.isEnabled(true)
			// 		.accountNoExpired(true)
			// 		.accountNoLocked(true)
			// 		.credentialNoExpired(true)
			// 		.roles(Set.of(rolDesarrollador, rolAdministrador))
			// 		.build();
			// userRepository.save(userManuel);

			// // // TODO: profesor

			// UserEntity userFernando = UserEntity.builder()
			// 		.name("fernando")
			// 		.surname("osorio")
			// 		.docType(DocTypeEnum.TARJETA_IDENTIDAD)
			// 		.docNumber("34563456")
			// 		.birthDate(localDate)
			// 		.email("emailfernando@gmail.com")
			// 		.phone("76856788")
			// 		.gender(GenderEnum.MASCULINO)
			// 		.profileImage("urldelaImagen")
			// 		.nickname("fercho")
			// 		.state(StateEnum.ACTIVO)
			// 		.username("fernando")
			// 		.password("1234")
			// 		.isEnabled(true)
			// 		.accountNoExpired(true)
			// 		.accountNoLocked(true)
			// 		.credentialNoExpired(true)
			// 		.roles(Set.of(rolDesarrollador, rolProfesor))
			// 		.build();
			// userRepository.save(userFernando);

			// // // TODO: Alumno

			// UserEntity userGeraldine = UserEntity.builder()
			// 		.name("geraldine")
			// 		.surname("leyton")
			// 		.docType(DocTypeEnum.PASAPORTE)
			// 		.docNumber("768568789679")
			// 		.birthDate(localDate)
			// 		.email("geraldine@gmail.com")
			// 		.phone("12341244")
			// 		.gender(GenderEnum.FEMENINO)
			// 		.profileImage("urldelaImagen")
			// 		.nickname("geraldine")
			// 		.state(StateEnum.ACTIVO)
			// 		.username("geraldine")
			// 		.password("1234")
			// 		.isEnabled(true)
			// 		.accountNoExpired(true)
			// 		.accountNoLocked(true)
			// 		.credentialNoExpired(true)
			// 		.roles(Set.of(rolDesarrollador, rolAlumno))
			// 		.build();
			// userRepository.save(userGeraldine);

			// // // TODO: Acudiente

			// UserEntity userAlejandra = UserEntity.builder()
			// 		.name("alejandra")
			// 		.surname("rojas")
			// 		.docType(DocTypeEnum.CEDULA_EXTRANJERA)
			// 		.docNumber("12345678")
			// 		.birthDate(localDate)
			// 		.email("aleRojas@gmail.com")
			// 		.phone("3452345235")
			// 		.gender(GenderEnum.FEMENINO)
			// 		.profileImage("urldelaImagen")
			// 		.nickname("ale")
			// 		.state(StateEnum.ACTIVO)
			// 		.username("alejandra")
			// 		.password("1234")
			// 		.isEnabled(true)
			// 		.accountNoExpired(true)
			// 		.accountNoLocked(true)
			// 		.credentialNoExpired(true)
			// 		.roles(Set.of(rolAcudiente, rolAlumno))
			// 		.build();
			// userRepository.save(userAlejandra);

			// // TODO: Anterior

			// UserEntity userEliana = UserEntity.builder()
			// .name("eliana")
			// .surname("perez")
			// .docType(DocTypeEnum.CEDULA_CIUDADANIA)
			// .docNumber("547457")
			// .birthDate(localDate)
			// .email("email@gmail.com")
			// .phone("2435234")
			// .gender(GenderEnum.FEMENINO)
			// .profileImage("urldelaImagen")
			// .nickname("eli")
			// .state(StateEnum.ACTIVO)
			// .build();

			// UserBasicAuthEntity userAuthEliana = UserBasicAuthEntity.builder()
			// .username("eliana")
			// .password("1234")
			// .isEnabled(true)
			// .AccountNoExpired(true)
			// .AccountNoLocked(true)
			// .CredentialNoExpired(true)
			// .roles(Set.of(rolDesarrollador, rolAdministrador))
			// .user(userEliana)
			// .build();

			// userRepository.saveAll(Set.of(userManuel, userFernando, userGeraldine,
			// userAlejandra, userEliana));
			// userBasicAuthRepository.saveAll(Set.of(userAuthManuel, userAuthFernando,
			// userAuthGeraldine,userAuthAlejandra,userAuthEliana));
		};

	}
}