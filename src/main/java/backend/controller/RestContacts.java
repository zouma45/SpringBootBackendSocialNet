package backend.controller;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import backend.config.ConversionConfig;
import backend.entity.Contact;
import backend.model.request.ContactRequest;
import backend.model.response.ContactResponse;
import backend.servicesrepository.ContactMongoRepository;
import backend.servicesrepository.PageableContactRepository;

@RestController
@RequestMapping(path = Constants.API_URL_V2)
@CrossOrigin
public class RestContacts {

	@Autowired
	ContactMongoRepository contactMongoRepository;

	@Autowired
	ConversionConfig ConversionService;

	@Autowired
	PageableContactRepository PageableContactRepository;

	@RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Page<ContactResponse> getAllContacts(Pageable pageable) {

		Page<Contact> contactList = PageableContactRepository.findAll(pageable);

		Page<ContactResponse> contactListResp = contactList.map(new Function<Contact, ContactResponse>() {

			@Override
			public ContactResponse apply(Contact t) {

				return new ContactResponse(t.getId(), t.getName(), t.getLname(), t.getAdress(), t.getAdress());

			}

		});
		return contactListResp;

	}

	@RequestMapping(path = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ContactResponse addContact(

			@RequestBody ContactRequest contact) {

		Contact contactEntity = ConversionService.conversionService().convert(contact, Contact.class);
		contactMongoRepository.insert(contactEntity);
		ContactResponse contactResponse = ConversionService.conversionService().convert(contactEntity,
				ContactResponse.class);

		return contactResponse;
	};

	@RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ContactResponse> updateReservation(

			@RequestBody ContactRequest contactRequest) {

		Contact contact = contactMongoRepository.findById(contactRequest.getId()).get();
		String id = contactRequest.getId();
		Contact c = ConversionService.conversionService().convert(contactRequest, Contact.class);
		contactMongoRepository.delete(contact);
		c.setId(id);
		contactMongoRepository.save(c);

		return new ResponseEntity<>(ConversionService.conversionService().convert(c, ContactResponse.class),
				HttpStatus.OK);
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Contact> getContactById(@PathVariable String id) {
		Optional<Contact> contact = contactMongoRepository.findById(id);
		System.out.println("What the fatafackinfacck");
		return new ResponseEntity<>(contact.get(), HttpStatus.OK);
	}

	//
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteContact(@PathVariable() String id) {
		contactMongoRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	//
}
