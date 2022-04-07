package tn.esprit.spring.repository; //Youyou_rendement_repository



import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Rendement;

@Repository
public interface IRendement extends CrudRepository<Rendement, Integer>  {
	/*@Query("select * from rendement r where r.annee =:a ")
	Rendement fin(@Param("a") int a); //kol_3am_3andi_rendement_spécifique*/
	Rendement findByAnnee(  int annee);
}
