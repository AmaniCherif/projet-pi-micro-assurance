package tn.esprit.spring.service.Implementation;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;

import tn.esprit.spring.entity.Contract;
import tn.esprit.spring.entity.Transaction;
import tn.esprit.spring.repository.ContractRepository;
import tn.esprit.spring.repository.TransactionRepository;
import tn.esprit.spring.service.Interface.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	ContractRepository contractRepository;
	@Override
	public Transaction addTransaction(Transaction t) {
		transactionRepository.save(t);
		
		return t;
	}

	@Override
	public void deleteTransaction(int id) {
		transactionRepository.deleteById(id);		
	}

	@Override
	public List<Transaction> retrieveAllTransactions() {
		
		
		List<Transaction> listTransaction =(List<Transaction>) transactionRepository.findAll();
				return listTransaction;
		 
	}

	@Override
	public List<Transaction> listAllAsd() {
		return transactionRepository.findAll(Sort.by("transactionDate").ascending());
	}
	
	@Override
	public Transaction retrieveTransactions(int id) {
		Optional<Transaction> TransOptional = transactionRepository.findById(id);
		Transaction t = TransOptional.get();
		return t;
	}
	@Override
	public int addOrUpdateTransaction(Transaction t) {
		
		transactionRepository.save(t);
		return t.getTransactionid();
	}

	

	@Override
	public List<Transaction> listTransactionByContractId(long id) {
		List<Transaction> L = transactionRepository.findAll(Sort.by("transactionDate").ascending());
		List<Transaction> ListContract = new ArrayList<Transaction>();
		for (int i = 0; i < L.size(); i++) {
			if (L.get(i).getContract().getId() == id) {
				ListContract.add(L.get(i));
			//System.out.print(L.get(i).toString());
			}
		}
		return ListContract;
	}
	


	@Override
	public List<Transaction> getAllTransById() {
		return null;
	}

	

	@Override
	public Transaction updateTransaction(Transaction t, int id) {
		Transaction transactionUptaded =transactionRepository.findById(id).get();
		transactionUptaded.setTransactionAmount(t.getTransactionAmount());
		transactionUptaded.setTransactionDate(t.getTransactionDate());
		//transactionUptaded.setTypeTransaction(t.getTypeTransaction());
		transactionRepository.save(transactionUptaded);
		return transactionUptaded;
	}
	//@SuppressWarnings({ "null", "deprecation" })
	@Override
	public List<Transaction> listTransactionByDate(int annee) {

		List<Transaction> L = transactionRepository.findAll(Sort.by("transactionDate").ascending());
		List<Transaction> ListY = new ArrayList<Transaction>();
		for (int i = 0; i < L.size(); i++) {
			System.out.print("YEAR "
					+ Integer.parseInt(new SimpleDateFormat("yyyy").format(L.get(i).getTransactionDate())) + "\n");

			if (Integer.parseInt(new SimpleDateFormat("yyyy").format(L.get(i).getTransactionDate())) == annee) {

				@SuppressWarnings("unused")
				String dateToStr = String.format("%1$tY-%1$tm-%1$td", L.get(i).getTransactionDate());

				ListY.add(L.get(i));

				System.out.print("Ajout year  +++++ "
						+ Integer.parseInt(new SimpleDateFormat("yyyy").format(L.get(i).getTransactionDate())));

			}
		}
		return ListY;
	}

	public Map<Double, Double> StatisticMonthbyAmount(int year)
	{
	Map<Double, Double> MA = new HashMap<Double, Double>();
	double sum1 = 0;
	double sum2 = 0;
	double sum3 = 0;
	double sum4 = 0;
	double sum5 = 0;
	double sum6 = 0;
	double sum7 = 0;
	double sum8 = 0;
	double sum9 = 0;
	double sum10 = 0;
	double sum11 = 0;
	double sum12 = 0;
	List<Transaction> L = listTransactionByDate(year);
	for (int i = 0; i < L.size(); i++) {
		String dateToStr = String.format("%1$tY-%1$tm-%1$td", L.get(i).getTransactionDate());
		String[] dateParts = dateToStr.split("-");
		String month = dateParts[1];
		if (month.equals("01"))

		{
			System.out.print(L.get(i).getTransactionAmount());
			sum1 += L.get(i).getTransactionAmount();
			System.out.print(L.get(i).getTransactionAmount());
			MA.put((double) 1, sum1);
		}

		else if (month.equals("02")) {
			sum2 += L.get(i).getTransactionAmount();
			MA.put((double) 2, sum2);
		}

		else if (month.equals("03")) {
			sum3 += L.get(i).getTransactionAmount();
			MA.put((double) 3, sum3);
		}

		else if (month.equals("04")) {
			sum4 += L.get(i).getTransactionAmount();
			MA.put((double) 4, sum4);
		}

		else if (month.equals("05")) {
			sum5 += L.get(i).getTransactionAmount();
			MA.put((double) 5, sum5);
		}

		else if (month.equals("06")) {
			sum6 += L.get(i).getTransactionAmount();
			MA.put((double) 6, sum6);
		}

		else if (month.equals("07")) {
			sum7 += L.get(i).getTransactionAmount();
			MA.put((double) 7, sum7);
		}

		else if (month.equals("08")) {
			sum8 += L.get(i).getTransactionAmount();
			MA.put((double) 8, sum8);
		}

		else if (month.equals("09")) {
			sum9 += L.get(i).getTransactionAmount();
			MA.put((double) 9, sum9);
		}

		else if (month.equals("10")) {
			sum10 += L.get(i).getTransactionAmount();
			MA.put((double) 10, sum10);
		}

		else if (month.equals("11")) {
			sum11 += L.get(i).getTransactionAmount();
			MA.put((double) 11, sum11);
		}

		else if (month.equals("12")) {
			sum12 += L.get(i).getTransactionAmount();
			MA.put((double) 12, sum12);
		}

	}

	return MA;
}
	@Override
	public void affecterPaymentToContract(int idt, long id) {
		Transaction transaction = transactionRepository.findById(idt).get();
		Contract contract = contractRepository.findById(id).get();
	if (!ObjectUtils.isEmpty(transaction) && !ObjectUtils.isEmpty(contract))
		transaction.setContract(contract);
	contractRepository.save(contract);
	}
}
