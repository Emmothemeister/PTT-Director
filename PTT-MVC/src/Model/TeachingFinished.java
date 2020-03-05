package Model;

public class TeachingFinished{
	private double claimAmount;
	private TeachingRequest tr;

	public TeachingFinished(TeachingRequest tr, Double claimAmount) {
		this.tr = tr;
		this.claimAmount = claimAmount;
	}
	
	public TeachingRequest getTeachingRequest() {
		return tr;
	}
	
	public double getClaimAmount() {
		return claimAmount;
	}
	

}
