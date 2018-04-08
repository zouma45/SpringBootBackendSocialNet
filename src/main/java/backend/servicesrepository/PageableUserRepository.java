package backend.servicesrepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import backend.entity.User;

public interface PageableUserRepository extends PagingAndSortingRepository<User, String> {

	Page<User> findAllById(String id, Pageable pageable);
}
