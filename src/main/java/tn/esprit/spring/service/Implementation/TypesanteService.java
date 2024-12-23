package tn.esprit.spring.service.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.ContractRequest;
import tn.esprit.spring.entity.Typesante;
import tn.esprit.spring.repository.ContractRequestRepository;
import tn.esprit.spring.repository.TypesanteRepo;



			@Service
			public class TypesanteService {
				@Autowired
				TypesanteRepo type_santeRepo ;
			
				@Autowired
				ContractRequestRepository demandeContrat;
				
			
//				public void addType(Long id , Typesante t ){
//					ContractRequest d = demandeContrat.findById(id).get();
//					System.out.println(d);
//					t.setDemandeContrat(d);
//					
//					type_santeRepo.save(t);
//				
//				}
			
				public void addType(Long id , Typesante t ){
					ContractRequest d = demandeContrat.findById(id).get();
					System.out.println(d);
					t.setDemandeContrat(d);
					
					type_santeRepo.save(t);
					String s = aprioriText2(t);
					System.out.println("yalllaaaaa wariniiii ");
					 try (FileWriter f = new FileWriter("apriori.txt", true);
							 //
				                BufferedWriter b = new BufferedWriter(f);
//							 //imprimer
				                PrintWriter p = new PrintWriter(b);) {
		
				            p.println(s);
			
				        } catch (IOException i) {
				            i.printStackTrace();
				        }	
				}
				
			
				
				
			public String aprioriText(Typesante t ){
				String res=""  ;
				String analyse ="";
				String actes_medicaux_courants="";
				String autres="";
				String consultations_visites="";
				String 	dentaires="";
				String frais_chirurgicaux="" ;
				String 	frais_pharmaceutiques="" ;
				String hospitalisation="";
				String maternite ="";
				String optique =""; 
				String radio_physio ="";
				String ajouconjoint ="";
				String ajoutEnf ="";
			
				if (t.isAnalyse() == true){
					analyse = "Analyse " ;
				}
				if(t.isActes_Medicaux_Courants()){
					actes_medicaux_courants ="actes_medicaux_courants " ;
				}
				if(t.isAutres() == true){
					autres ="autres ";
				}
				if(t.isConsultations_Visites() == true){
					consultations_visites ="consultations_visites ";
				}
				if(t.isDentaires() == true){
					dentaires ="dentaires ";
				}
				if(t.isFrais_Chirurgicaux() == true){
					frais_chirurgicaux ="frais_chirurgicaux ";
				}
				if(t.isFrais_Pharmaceutiques() == true){
					frais_pharmaceutiques ="frais_pharmaceutiques ";
				}
				if(t.isHospitalisation() == true){
					hospitalisation ="hospitalisation ";
				}
				if(t.isMaternite() == true){
					maternite ="maternite ";
				}
				if(t.isOptique() == true){
					optique ="optique ";
				}
				if(t.isRadio_Physio() == true){
					radio_physio ="radio_physio ";
				}
				if(t.isAjouconjoint() == true){
					ajouconjoint ="ajouconjoint ";
				}
				if(t.isAjoutEnf() == true){
					ajoutEnf ="Ajout enfant ";
				}
				res = actes_medicaux_courants +consultations_visites+ dentaires+frais_pharmaceutiques+frais_chirurgicaux +hospitalisation+optique+radio_physio+ analyse+maternite+autres+ajouconjoint+ajoutEnf;
				return res ;
				
			}
			
			
			public String aprioriText2(Typesante t ){
			String res=""  ;
			String analyse ="";
			String actes_medicaux_courants="";
			String autres="";
			String consultations_visites="";
			String 	dentaires="";
			String frais_chirurgicaux="" ;
			String 	frais_pharmaceutiques="" ;
			String hospitalisation="";
			String maternite ="";
			String optique =""; 
			String radio_physio ="";
			String ajouconjoint ="";
			String ajoutEnf ="";
			if (t.isAnalyse() == true){
				analyse = "Analyse " ;
			}
			if(t.isActes_Medicaux_Courants()){
				actes_medicaux_courants ="actes_medicaux_courants " ;
			}
			if(t.isAutres() == true){
				autres ="autres ";
			}
			if(t.isConsultations_Visites() == true){
				consultations_visites ="consultations_visites ";
			}
			if(t.isDentaires() == true){
				dentaires ="dentaires ";
			}
			if(t.isFrais_Chirurgicaux() == true){
				frais_chirurgicaux ="frais_chirurgicaux ";
			}
			if(t.isFrais_Pharmaceutiques() == true){
				frais_pharmaceutiques ="frais_pharmaceutiques ";
			}
			if(t.isHospitalisation() == true){
				hospitalisation ="hospitalisation ";
			}
			if(t.isMaternite() == true){
				maternite ="maternite ";
			}
			if(t.isOptique() == true){
				optique ="optique ";
			}
			if(t.isRadio_Physio() == true){
				radio_physio ="radio_physio ";
			}
			if(t.isAjouconjoint() == true){
				ajouconjoint ="ajouconjoint ";
			}
			if(t.isAjoutEnf() == true){
				ajoutEnf ="Ajout enfant ";
			}
			res = actes_medicaux_courants + dentaires+frais_chirurgicaux +optique+radio_physio+ analyse+maternite+autres+ajouconjoint+ajoutEnf;
			return res ;
			
			}
			
			
			public String aprioriText3(Typesante t ){
			String res=""  ;
			String analyse ="";
			String actes_medicaux_courants="";
			String autres="";
			String consultations_visites="";
			String 	dentaires="";
			String frais_chirurgicaux="" ;
			String 	frais_pharmaceutiques="" ;
			String hospitalisation="";
			String maternite ="";
			String optique =""; 
			String radio_physio ="";
			String ajouconjoint ="";
			String ajoutEnf ="";
			if (t.isAnalyse() == true){
				analyse = "-Analyse " ;
			}
			if(t.isActes_Medicaux_Courants()){
				actes_medicaux_courants ="-Actes medicaux courants \n" ;
			}
			if(t.isAutres() == true){
				autres ="-Autres ";
			}
			if(t.isConsultations_Visites() == true){
				consultations_visites ="-Consultations visites ";
			}
			if(t.isDentaires() == true){
				dentaires ="-Dentaires ";
			}
			if(t.isFrais_Chirurgicaux() == true){
				frais_chirurgicaux ="-Frais chirurgicaux ";
			}
			if(t.isFrais_Pharmaceutiques() == true){
				frais_pharmaceutiques ="-Frais pharmaceutiques ";
			}
			if(t.isHospitalisation() == true){
				hospitalisation ="-Hospitalisation ";
			}
			if(t.isMaternite() == true){
				maternite ="-Maternite ";
			}
			if(t.isOptique() == true){
				optique ="-Optique ";
			}
			if(t.isRadio_Physio() == true){
				radio_physio ="-Radio physio ";
			}
			if(t.isAjouconjoint() == true){
				ajouconjoint ="-Ajout conjoint ";
			}
			if(t.isAjoutEnf() == true){
				ajoutEnf ="-Ajout enfant ";
			}
			
			res = actes_medicaux_courants + dentaires+frais_chirurgicaux +optique+radio_physio+ analyse+maternite+autres+ajouconjoint+ajoutEnf;
			return res ;
			
			}
			
			
			public Typesante affichetypesanteparDemande(Long id  ){
					ContractRequest d = demandeContrat.findById(id).get();
					
					return type_santeRepo.findByContractRequest(d);	
				}
				
			
			}
