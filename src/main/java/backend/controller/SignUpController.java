package backend.controller;

import java.util.ArrayList;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import backend.config.ConversionConfig;
import backend.entity.Skills;
import backend.entity.User;
import backend.model.response.UserResponse;
import backend.servicesrepository.PageableUserRepository;
import backend.servicesrepository.UserMongoRepository;

@RestController
@RequestMapping(path = Constants.API_URL_V2)
@CrossOrigin
public class SignUpController {

	@Autowired
	UserMongoRepository userMongoRepository;

	@Autowired
	ConversionConfig ConversionService;

	@Autowired
	PageableUserRepository pageableUserRepository;

	@RequestMapping(path = "/users/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Page<UserResponse> getAllUsers(Pageable pageable) {
		
		Skills skill1 = new Skills("1", "Java", 5);
		Skills skill2 = new Skills("2", "Spring boot", 6); 
		Skills skill3 = new Skills("3", "Python", 7); 
		
		ArrayList<Skills> skills = new ArrayList<>(); 
		skills.add(skill1);
		skills.add(skill2);
		skills.add(skill3);
		
		User Mahdi = new User( "Mahdi", "Zouch", "zouma45", "zouch.mahdi@gmail.com", "123", skills); 
		
		userMongoRepository.save(Mahdi) ;
		
		

		Page<User> usersList = pageableUserRepository.findAll(pageable);

		Page<UserResponse> usersListResp = usersList.map(new Function<User, UserResponse>() {

			@Override
			public UserResponse apply(User source) {

				return new UserResponse(source.getId(), source.getName(), source.getLastName(), source.getPseudo(), source.getEmail(), source.getPassword(), source.getSkills());
			}
		});
		return usersListResp;

	}	
	
	
}
