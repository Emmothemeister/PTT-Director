package Model;

import java.util.ArrayList;

import Model.TeachingFinished;

public class FinanceModel {
	private ArrayList<TeachingFinished> listOfClaims = new ArrayList<>();
	
	public FinanceModel() {
		
	}
	
	public ArrayList<TeachingFinished> getListOfClaims(){
		return listOfClaims;
	}

}
