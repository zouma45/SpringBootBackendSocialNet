package backend.converters;

import org.springframework.core.convert.converter.Converter;

import backend.entity.Contact;
import backend.model.request.ContactRequest;

public class ContactRequestToContactEntityConverter implements Converter<ContactRequest, Contact> {

	@Override
	public Contact convert(ContactRequest source) {
		Contact contact = new Contact(source.getName(), source.getLname(), source.getAdress(), source.getMail()) ;
		return contact;
	}

	
}
