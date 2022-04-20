package tn.esprit.spring.service.Implementation;

import java.awt.Color;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import tn.esprit.spring.entity.ContractOffer;
import tn.esprit.spring.entity.Offer;
import tn.esprit.spring.entity.State_Offer;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.ContractOfferRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.repository.OfferRepository;
import tn.esprit.spring.repository.TableMortaliteRepository;
import tn.esprit.spring.service.Interface.ContractOfferService;

@Service
public class ContractOfferServiceImpl implements ContractOfferService{
	@Autowired 
	private UserRepository userRepository;
	@Autowired 
	ContractOfferRepository contractOfferRepository;
	@Autowired
	OfferRepository offerRepository;
	@Autowired
	TableMortaliteRepository tr ;

	
	
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
	public ContractOffer Contract_OffersByUser(Long IdUser) {
		System.out.println("UserContractoffer id =" + IdUser);
		ContractOffer cf = contractOfferRepository.findByUser_idUser(IdUser);
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
		return(PrimeComercial);
	   	
	    }

	@Override
	public ContractOffer AddContractMixte(ContractOffer contract ,Long userid , Long offerId) {
		Offer o = offerRepository.findById(offerId).get();
    	User user = userRepository.findById(userid).get();
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		LocalDate dateTime = new LocalDate();
		String newDateTime = dateTime.plusYears(contract.getDuree()).toString();
		contract.setState_offers(State_Offer.Accepted);
		contract.setUser(user);
		contract.setTarification(Tarification_Mixte_PrimePeriodique(contract.getVie_mixte(),contract.getDeces_mixte(),contract.getDuree(),25));
		contract.setDate_debut(dateFormat.format(date));
		contract.setDate_fin(newDateTime);
		contract.setOffer(o);
		contractOfferRepository.save(contract);
		return contract;
	}
	@Override
	public void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Ref", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("date debut", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("date fin", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("State Offer", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Tarif", font));
        table.addCell(cell);       
    }
    @Override
   public void writeTableData(PdfPTable table, ContractOffer user) {
   	PdfPCell cell = new PdfPCell();
      
           
       	cell.setPhrase(new Phrase(String.valueOf(user.getIdContractOffer())));
       	table.addCell(cell);
          
           
           cell.setPhrase(new Phrase(user.getDate_debut().toString()));
           table.addCell(cell);
          
          
           cell.setPhrase(new Phrase(user.getDate_fin().toString()));
           table.addCell(cell);
           
           cell.setPhrase(new Phrase(user.getState_offers().toString()));
          
           table.addCell(cell);
           
           cell.setPhrase(new Phrase(String.valueOf(user.getTarification())+"  Dinar"));
           
            table.addCell(cell);
           
           
       }
    @Override
   public void export(ContractOffer data,HttpServletResponse response) throws DocumentException, IOException {
       Document document = new Document(PageSize.A4);
       
       PdfWriter.getInstance(document, response.getOutputStream());
       
        
       document.open();
       document.addTitle("MicroLeftContract");
     
       Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
       font.setSize(25);
       font.setColor(Color.BLUE);
       
       //document.add(image);
       Paragraph p = new Paragraph("Offer Mixte Contract ", font);
       p.setSpacingBefore(30);
       p.setAlignment(Paragraph.ALIGN_CENTER);
       
       document.add(p);
        
       PdfPTable table = new PdfPTable(5);
       table.setWidthPercentage(100f);
       table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
       table.setSpacingBefore(50);
        
       writeTableHeader(table);
       writeTableData(table,data);
        
       document.add(table);
       Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
       font1.setSize(15);
       font1.setColor(Color.RED);
       Paragraph p1 = new Paragraph("Offer Mixte Contract clause", font1);
       p1.setSpacingBefore(30);
       Paragraph p2 = new Paragraph("In Case Of Death after the end of contract, The relative of the client will get : "+data.getDeces_mixte() + " Dinar");
       p1.setSpacingBefore(20);
       Paragraph p3 = new Paragraph(" * In Case Of Survival after the end of contract, The client will get : "+data.getVie_mixte()+ " Dinar");
       Paragraph p4 = new Paragraph("* The Duration of the Contract is determined to be for : "+data.getDuree()+ " Years");
       Paragraph p6 = new Paragraph("* In case of termination the offer is not refundable");
       p2.setSpacingBefore(20);
       p3.setSpacingBefore(20);
       p4.setSpacingBefore(20);
       p6.setSpacingBefore(20);
       document.add(p1);
       document.add(p2);
       document.add(p3);
       document.add(p4);
       document.add(p6);


       document.close();
        
   }

	@Override
	public int nbre_tranches_restantes(String final_date) {
		LocalDate dt_final = new LocalDate(final_date);
    	LocalDate now = new LocalDate(); 
    	int monthsBetween = Years.yearsBetween(now, dt_final).getYears();
    	
    	return monthsBetween;
	}

}
