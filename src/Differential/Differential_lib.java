package Differential;

public class Differential_lib implements Differential_if{
	
	private double a, h;
	
	public Differential_lib(double a, double h) {
		this.a = a;
		this.h = h;
	}
	
	@Override
	public double getRx() {
		// TODO Auto-generated method stub
		return 2*this.a;
	}
	
	@Override
	public double getDx() {
		// TODO Auto-generated method stub
		return (Math.pow(this.a+this.h, 2)-Math.pow(this.a, 2))/h;
	}
	
	public double RelativeError() {
		double answer = 0;
		answer = 100*((this.getRx()-this.getDx())/this.getRx());
		answer = Math.abs(answer);
		return answer;
	}
	
	public double Experiment() {
		double answer = 0;
		double min = this.RelativeError();
		double min_h = this.h;
		for(int i=0;;i++){
			this.h = 0.1*this.h;
			if(this.RelativeError()<min) {
				min = this.RelativeError();
				min_h = this.h;
			}
			else {
				break;
			}

		}
		answer = min_h;
		
		return answer;
	}
	
}
