package tn.esprit.spring.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Offer;
@Repository
public interface OfferRepository extends CrudRepository<Offer, Long> {
}
