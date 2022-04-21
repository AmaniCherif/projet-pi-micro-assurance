package tn.esprit.spring.service.Interface;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfPTable;

import tn.esprit.spring.entity.ContractOffer;

public interface ContractOfferService {
	 List<ContractOffer> retrieveAll_Contractoffers();
	 ContractOffer addContract_Offers(ContractOffer cf);
	 void deleteContract_Offers(int id);
	 ContractOffer Contract_OffersByUser(Long id);
	 ContractOffer updateContract_Offers(ContractOffer cf);
	 ContractOffer retrieveContract_Offers(int id);
	 public double Tarification_Mixte_PrimePeriodique(double vie_mixte,double dèces_mixte,int duree,int age );
	 public Double Tarification_Mixte_PrimeUnique(double vie_mixte,double dèces_mixte,int duree,int age );
	 ContractOffer AddContractMixte(ContractOffer c ,Long id, Long offerId);
	 void writeTableHeader(PdfPTable table) ;
	 public void writeTableData(PdfPTable table, ContractOffer user);
	 public void export(ContractOffer data,HttpServletResponse response) throws DocumentException, IOException ;
	 public int nbre_tranches_restantes(String final_date);
	

}
