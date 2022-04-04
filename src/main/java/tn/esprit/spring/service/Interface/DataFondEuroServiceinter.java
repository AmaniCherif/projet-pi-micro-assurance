package tn.esprit.spring.service.Interface;

import java.util.List;

import tn.esprit.spring.entity.DataFondEURO;
import tn.esprit.spring.entity.Rendement;

public interface DataFondEuroServiceinter {
	public void addDataEuro(DataFondEURO d);
	public List<DataFondEURO> listeBTA();
	public List<DataFondEURO> listeAll();
	public void deleteFondEURO( int id);
	public List<Rendement> listeRendementPortefeuille();
	public void calculeprofitUnique();
	public void calculeprofitPeriodique();
	public float rendementPortefeuilleEUROcroissance();
	public void liste();
	public void calculerendementTotal();
	public static double puissance(double a, double p) {
		return 0;
	} 
}
