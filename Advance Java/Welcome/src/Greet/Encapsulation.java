package Greet;

public class Encapsulation {
	
	private int sno;
	private int domain;

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public int getDomain() {
		return domain;
	}

	public void setDomain(int domain) {
		this.domain = domain;
	}

	public static void main(String[] args) {
		Encapsulation e = new Encapsulation();
		e.setDomain(8);
		e.setSno(11);
		
		System.out.println(e.getDomain());
		System.out.println(e.getSno());
	}

}
