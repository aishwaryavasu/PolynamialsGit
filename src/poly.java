import java.util.ArrayList;

public class poly {

	int[] coeffecients;

	public poly(){
		coeffecients=new int[10];
	}
	public poly(String polynomial){


		ArrayList<Integer> coeffPoly=new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			coeffPoly.add(0);
		}
		polynomial=polynomial.replaceAll("\\-","+-");

		polynomial=polynomial.replaceAll("\\s","");
		if(polynomial.charAt(0)=='+'){
			polynomial=polynomial.substring(1);
		}
		String[] terms=polynomial.split("\\+");
		for(int i=0;i<terms.length;i++){
			int power;int coeff=0;

			String[] exp=terms[i].split("\\^");
			if(exp.length>1){
				power=Integer.parseInt(exp[1]);
			}
			else if(terms[i].indexOf('x')!=-1){
				power=1;
			}
			else {power=0;}

			if(exp[0].equals("x")){
				coeff=1;
			}
			else{

				String[] findCoeff=exp[0].split("x");
				if(findCoeff[0].equals("-"))coeff=-1;
				else {
					coeff=Integer.parseInt(findCoeff[0]);
				}
			}

			coeffPoly.set(power,coeff);
		}
		coeffecients = new int[coeffPoly.size()];
		for(int i =0 ; i<coeffPoly.size();i++){
			coeffecients[i]=coeffPoly.get(i);
		}

	}
	public poly(int[] coeffecient) {
		super();
		this.coeffecients = new int[ coeffecient.length ];
		for( int i = 0; i < coeffecient.length; i++ ){
			this.coeffecients[ i ] = coeffecient[ i ];
		}

	}
	public poly(int coeffecient,int degree) {
		super();
		coeffecients = new int[degree+1];
		coeffecients[degree]=coeffecient;
	}
	public poly( poly p ){
		coeffecients = new int[ p.coeffecients.length ];
		for( int i = 0; i < p.coeffecients.length; i++ ){
			coeffecients[ i ] = p.coeffecients[ i ];
		}

	}
	public int degree(){
		int d = -1;
		for( int i = 0; i < coeffecients.length; i++ )
			if( coeffecients[ i ] != 0 ) d = i;
		return d;
	}

	public void printPoly()
	{
		if(toString().startsWith("+"))
		System.out.println(toString().substring(1));
		else
			System.out.println(toString());

	}

	public String toString() {
		String st = "";
		int degree = degree();
		for (int i = coeffecients.length - 1; i >= 0; i--) {
			if (coeffecients[i] != 0) {
				if (coeffecients[i] < 0)
					st += coeffecients[i];
				else
					st += "+" + coeffecients[i];
				if (i > 0) {
					st += "X";
					if (i > 1) {
						st += "^" + i + " ";
					}

				}
			}
		}	return st;

	}
	public int findHigherDegree(poly b)
	{
		int len = this.degree();
		if(len<b.degree())
			len=this.degree();
		return len;
	}
	public int getCoeff(int n){
		if(n<=degree())
		return coeffecients[n];
		return 0;
	}
	
	public  poly add (poly b)
	{
		int len=this.findHigherDegree(b);
		int temp[] = new int[len+1];


		for(int i=len;i>=0;i--)
		{
			int temp_1 =0;
			temp_1 = this.getCoeff(i) + b.getCoeff(i);
			temp[i]=temp_1;
		}
		return new poly(temp);
		
	}
	
	public poly sub(poly b)
	{
		int len=this.findHigherDegree(b);
		int temp[] = new int[len+1];


		for(int i=len;i>=0;i--)
		{
			int temp_1 =0;
			if(b.degree()>i && this.degree()>i)
				temp_1 = this.getCoeff(i) - b.getCoeff(i);
			else if(b.degree()>i)
				temp_1 = b.getCoeff(i);
			else if(this.degree()>i)
				temp_1=this.getCoeff(i);
			temp[i]=temp_1;
		}

		return new poly(temp);
	}
	
	public poly multiply(poly b)
	{
		int len= this.findHigherDegree(b);
		int temp[] = new int[this.degree()+b.degree()+1];
		
		for(int i=this.degree();i>=0;i--)
		{
			for(int j=b.degree();j>=0;j--)
			{
				temp[i+j]=temp[i+j]+(this.getCoeff(i)*b.getCoeff(j));
			}
		}
		return new poly(temp);

	}
	public poly divide(poly divisor){
		poly quotient = new poly();
		String q ="";
		poly remainder = new poly(this);
		int i=0;
		while(!remainder.isZero() && remainder.degree()>=divisor.degree()){
			int coef = remainder.getCoeff(remainder.degree()) / divisor.getCoeff(divisor.degree());
			int deg = remainder.degree() - divisor.degree();
			poly temp = new poly( coef, deg );
			q+=temp.toString();
			quotient = temp.add( quotient );
			remainder = remainder.sub( temp.multiply( divisor ) );

		}
		System.out.println("quotient " +q);
		return remainder;
	}
	public boolean isZero(){
		for( int i : coeffecients ){
			if( i != 0 ) return false;
		}
		return true;
	}

}
