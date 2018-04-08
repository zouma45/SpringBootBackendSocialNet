package backend.converters;

import org.springframework.core.convert.converter.Converter;

import backend.entity.User;
import backend.model.response.UserResponse;

public class UserEntityToUserResponseConverter  implements Converter<User	, UserResponse>{

	@Override
	public UserResponse convert(User source) {
		return new UserResponse(source.getId(), source.getName(), source.getLastName(), source.getPseudo(), source.getEmail(), source.getPassword(), source.getSkills()); 

	}

}
