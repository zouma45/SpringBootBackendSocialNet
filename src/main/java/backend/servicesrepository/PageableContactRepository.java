package backend.servicesrepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import backend.entity.Contact;

public interface PageableContactRepository extends PagingAndSortingRepository<Contact, Long> {

	Page<Contact> findAllById(long id, Pageable pageable);
}
