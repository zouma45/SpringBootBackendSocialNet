package backend.converters;

import org.springframework.core.convert.converter.Converter;

import backend.entity.Contact;
import backend.model.response.ContactResponse;

public class ContactEntityToContactResponseConverter implements Converter<Contact, ContactResponse> {

	@Override
	public ContactResponse convert(Contact source) {

		ContactResponse response = new ContactResponse(source.getId(), source.getName(), source.getLname(),
				source.getAdress(), source.getMail());

		return response;
	}

}
