package backend.converters;

import org.springframework.core.convert.converter.Converter;

import backend.entity.User;
import backend.model.request.UserRequest;

public class UserRequestToUserEntityConverter implements Converter<UserRequest , User> {

	@Override
	public User convert(UserRequest source) {
		return new User(source.getId(), source.getName(), source.getLastName(), source.getPseudo(), source.getEmail(), source.getPassword(), source.getSkills()); 
}
	

}
