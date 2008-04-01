package dt.memory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BooleanDomain implements Domain<Boolean> {

	private String fName;
	private ArrayList<Boolean> fValues;
	private boolean constant;
	private int readingSeq;


	public BooleanDomain(String _name) {
		fName = _name.trim();
		fValues = new ArrayList<Boolean>();
		fValues.add(Boolean.TRUE);
		fValues.add(Boolean.FALSE);
		readingSeq = -1;
	}

	public Domain<Boolean> clone() {
		BooleanDomain dom = new BooleanDomain(fName);
		dom.constant = constant;
		dom.readingSeq = readingSeq;
		return dom;
	}
	
	public boolean isDiscrete() {
		return true;
	}

	public String getName() {
		return fName;
	}

	public boolean contains(Boolean value) {
		return true;
	}

	public void addValue(Boolean value) {
		return;	
	}
	public void addPseudoValue(Boolean value) {
		return;
	}

	public List<Boolean> getValues() {
		return fValues;
	}
	
	public int hashCode() {
		return fName.hashCode();
	}

	public boolean isConstant() {
		return this.constant;
	}

	public void setConstant() {
		this.constant = true;	
	}
	
	public Object readString(String data) {
		System.out.print("What is the data : "+ data);
		if (isValid(data)) {
			if (data.trim().equalsIgnoreCase("true"))
				return Boolean.TRUE;
			else if ((data.trim().equalsIgnoreCase("false")))
				return Boolean.FALSE;
			else
				return Boolean.parseBoolean(data);
		}else 
			return null;
	}
	
	public boolean isValid(String string) {
		try{
			Boolean.parseBoolean(string);
			//System.out.println("parse the boolean ");
			return true;
		}
		catch (Exception e){
			System.out.println("Can not parse the boolean "+e);
			System.exit(0);
			return false;
		}
	}
	
	public boolean isPossible(Object value) {
		//if (isDiscrete() && constant)
		if (value instanceof Boolean && fValues.contains(value))
			return true;
		return false;
	}
	
	public String toString() {
		String out = fName;
		return out;
	}

	public void setReadingSeq(int readingSeq) {
		this.readingSeq = readingSeq;
		
	}
	
	public int getReadingSeq() {
		return this.readingSeq;
		
	}

	public void setDiscrete(boolean disc) {
		// TODO Auto-generated method stub
		
	}

	public Comparator<Fact> factComparator() {
		// TODO Auto-generated method stub
		System.out.println("BooleanDomain.factComparator() can not be continuous what is going on? ");
		return null;
	}

	public void setIndices(List<Integer> split_indices) {
		// TODO Auto-generated method stub	
	}
	
	public List<Integer> getIndices() {
		return null; //indices;
	}

}