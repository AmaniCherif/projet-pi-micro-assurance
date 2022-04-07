package tn.esprit.spring.repository; //YosserBenameur_actiffinancier

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.ActifFinancier;
import tn.esprit.spring.entity.Fond;
import tn.esprit.spring.entity.User;

@Repository
public interface IActifFinancier extends JpaRepository<ActifFinancier, Long>{
	
List<ActifFinancier> findByNomFond(Fond nom_fond) ;
	
	@Query(value = "SELECT count(*) FROM actif_financier WHERE nom_fond='Fond_Euro' ",nativeQuery = true)
	public int listFond_Euro( );

	@Query(value = "SELECT count(*) FROM actif_financier WHERE nom_fond='Euro_Croissance' ",nativeQuery = true)
	public int listEuro_Croissance( );

	@Query(value = "SELECT * FROM actif_financier WHERE nom_fond='Euro_Croissance' and  etat='En cours' and user_actif_user_id=:w ",nativeQuery = true)
	 List<ActifFinancier> listemontant_actuelEuroCroissanceparUser( @Param("w") Long w );

	@Query(value = "SELECT * FROM actif_financier WHERE nom_fond='Fond_Euro' and  etat='En cours' and user_actif_user_id=:w ",nativeQuery = true)
	 List<ActifFinancier> listemontant_actuelFondEuroparUser( @Param("w") Long w );
	
	
	List<ActifFinancier> findByUserActif( User user);

}
