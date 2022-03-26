package tn.esprit.spring.service.Implementation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.joda.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.ContractOffer;
import tn.esprit.spring.entity.Offer;
import tn.esprit.spring.entity.State_Offer;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.ContractOfferRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.repository.OfferRepository;
import tn.esprit.spring.service.Interface.ContractOfferService;

@Service
public class ContractOfferServiceImpl implements ContractOfferService{
	@Autowired 
	private UserRepository userRepository;
	@Autowired 
	ContractOfferRepository contractOfferRepository;
	@Autowired
	OfferRepository offerRepository;
	
	
	@Override
	public List<ContractOffer> retrieveAll_Contractoffers() {
		List<ContractOffer> Contractoffers =(List<ContractOffer>) contractOfferRepository.findAll();
		for(ContractOffer Contractoffer: Contractoffers){
			System.out.println("Contractoffer +++ : "+ Contractoffer);
		}
		return Contractoffers;
	}

	@Override
	public ContractOffer addContract_Offers(ContractOffer cf) {
		ContractOffer ContratSaved = null;
		ContratSaved =contractOfferRepository.save(cf);
		return ContratSaved;
	}

	@Override
	public void deleteContract_Offers(int id) {
		contractOfferRepository.deleteById(id);
		
	}

	@Override
	public ContractOffer updateContract_Offers(ContractOffer cf) {
		System.out.println(cf);
		ContractOffer Contract_OffersAdded = contractOfferRepository.save(cf);
		return Contract_OffersAdded;
	}

	@Override
	public ContractOffer retrieveContract_Offers(int idContractOffer) {
		System.out.println("Contractoffer id =" + idContractOffer);
		ContractOffer cf = contractOfferRepository.findById(idContractOffer).orElse(null);
		System.out.println("Contractoffre returned "+cf);
		return cf ;
	}
	@Override
	public ContractOffer Contract_OffersByUser(int IdUser) {
		System.out.println("UserContractoffer id =" + IdUser);
		ContractOffer cf = contractOfferRepository.Contract_OffersByUser(IdUser);
		System.out.println("ContractoffreBy User returned "+cf);
		return cf ;
		
	}
	@Override
	public double Tarification_Mixte_PrimePeriodique(double vie_mixte, double deces_mixte, int duree, int age) {
		double vie , deces = 0 , capit = 0,primePure,PrimeComercial ,v,puiss;
    	double [] Lx= {100.000,97.104,96.869,96.727,96.624,96.541,96.471,96.410,96.356,96.306,96.258,96.211,96.163,96.111,96.052
    	    	,95.985,95.908,95.821,95.722,95.614,95.496,95.372,95.242,95.108,94.971,94.834,94.696,94.558,94.420,94.283,94.145
    	    	,94.007,93.867,93.724,93.578,93.426,93.268,93.102,92.926,92.739,92.538,92.323,92.089,91.837,91.562,91.263,90.937
    	    	,90.580,90.190,89.764,89.297,88.786,88.226,87.614,86.944,86211,85410,84536,83582,82542,81409,80178,78.842
    	    	,77.393,75.826,74.134,72.312,70.354,68.257,66.017,63.632,61.103,58.432,55.623,52.686,49.629,46.469,43.222,39.911,36.560
    	    	,33.200,29.861,26.580,23.390,20.328,17.428,14.722,12.238,9.997,8.013,6.292,4.832,3.623,2.647,1.876,1.286,850,539
    	    	,326,187,101,51,24,10,4,1};
    	double Interet=0.01;
    	vie = vie_mixte*(Lx[age+duree]/Lx[age]) * Math.pow(1/(1+Interet), duree);
    	for (int i=0;i<duree;i++){
    		deces+=((Lx[age+i]-Lx[(age+1)+i])/Lx[age]) * Math.pow((1/(1+Interet)),i + 0.5);
    	}
    	deces = deces_mixte * deces;
    	for (int i=0;i<duree;i++){
    		capit+=(Lx[age+i]/Lx[age]) * Math.pow((1/(1+Interet)), i);
    	}
    	primePure=(vie+deces)/capit;
    	PrimeComercial=primePure+( primePure * 0.03);
    	System.out.println("PrimeComercial "+ PrimeComercial);
    	return(Math.round(PrimeComercial));
		
	}

	@Override
	public Double Tarification_Mixte_PrimeUnique(double vie_mixte, double deces_mixte, int duree, int age) {
		 double vie , deces = 0 ,primePure,PrimeComercial ,v,puiss;
		   	double [] Lx= {100.000,97.104,96.869,96.727,96.624,96.541,96.471,96.410,96.356,96.306,96.258,96.211,96.163,96.111,96.052
			    	,95.985,95.908,95.821,95.722,95.614,95.496,95.372,95.242,95.108,94.971,94.834,94.696,94.558,94.420,94.283,94.145
			    	,94.007,93.867,93.724,93.578,93.426,93.268,93.102,92.926,92.739,92.538,92.323,92.089,91.837,91.562,91.263,90.937
			    	,90.580,90.190,89.764,89.297,88.786,88.226,87.614,86.944,86211,85410,84536,83582,82542,81409,80178,78.842
			    	,77.393,75.826,74.134,72.312,70.354,68.257,66.017,63.632,61.103,58.432,55.623,52.686,49.629,46.469,43.222,39.911,36.560
			    	,33.200,29.861,26.580,23.390,20.328,17.428,14.722,12.238,9.997,8.013,6.292,4.832,3.623,2.647,1.876,1.286,850,539
			    	,326,187,101,51,24,10,4,1};
		   	double Interet=0.01;
		   	vie=vie_mixte*(Lx[age+duree]/Lx[age])*Math.pow(1/(1+Interet), duree);
		   	for (int i=0;i<duree;i++){
		   		deces+=((Lx[age+i]-Lx[(age+1)+i])/Lx[age]) * Math.pow((1/(1+Interet)),i + 0.5);
		   	}
		   	deces = deces_mixte * deces;
		   	primePure=(vie+deces);
		   	PrimeComercial=primePure+( primePure * 0.03);
		   	 //System.out.println("PrimeComercial "+ PrimeComercial);
			return(PrimeComercial);
		   	
	}

	@Override
	public ContractOffer AddContractMixte(ContractOffer contract ,int userid) {
		Offer o = offerRepository.findById(1).get();
    	User user = userRepository.findById(23).get();
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		LocalDate dateTime = new LocalDate();
		String newDateTime = dateTime.plusYears(contract.getDuree()).toString();
		contract.setState_offers(State_Offer.Accepted);
		contract.setUsers(user);
		contract.setTarification(Tarification_Mixte_PrimePeriodique(contract.getVie_mixte(),contract.getDeces_mixte(),contract.getDuree(),54));
		contract.setDate_debut(dateFormat.format(date));
		contract.setDate_fin(newDateTime);
		contract.setOffers(o);
		contractOfferRepository.save(contract);
		return contract;
	}

	

}
