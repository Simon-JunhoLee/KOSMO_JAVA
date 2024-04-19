package am;

public class Score {
	String name;
	int kor;
	int eng;
	int mat;
	
	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Score(String name, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public int total() {
		int tot = kor + eng + mat;
		return tot;
	}
	
	public double avg() {
		return (double)(kor + eng + mat)/3;
	}
	
	public String grade() {
		String grade = "";
		if(avg() >= 90) {
			if(avg() >= 95) {
				grade = "A+";
			}else {
				grade = "A";
			}
		}else if(avg() >= 80) {
			if(avg() >= 85) {
				grade = "B+";
			}else {
				grade = "B";
			}
		}else if(avg() >= 70) {
			if(avg() >= 75) {
				grade = "C+";
			}else {
				grade = "C";
			}
		}else if(avg() >= 60) {
			if(avg() >= 65) {
				grade = "D+";
			}else {
				grade = "D";
			}
		}else {
			grade = "F";
		}
		return grade;
	}
	
	public void print() {
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n", name, kor, eng, mat, total(), avg(), grade());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
}
