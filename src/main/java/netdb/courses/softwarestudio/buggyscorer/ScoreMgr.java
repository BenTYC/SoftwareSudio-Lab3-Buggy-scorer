package netdb.courses.softwarestudio.buggyscorer;

public class ScoreMgr {

	private double scoreList[];

	public ScoreMgr(double[] scoreList) {
		this.scoreList = scoreList;
	}

	public double findMax() {
		double max = scoreList[0];
		for (int i = 0; i < getEnrollStudentNumber() - 1; i++) {
			if (max < scoreList[i + 1])
				max = scoreList[i + 1];
		}
		return max;
	}

	public double findMin() {
		double min = scoreList[0];
		for (int i = 0; i < getEnrollStudentNumber() - 1; i++) {
			if (min > scoreList[i + 1])
				min = scoreList[i + 1];
		}
		return min;
	}

	public double getAvg() {
		double tmp = 0;
		int count = 0;
		while (count < getEnrollStudentNumber()) {
			tmp += scoreList[count];
			count++;
		}
		return tmp / getEnrollStudentNumber();
	}

	public void sortScoreList() {
		for (int i = 0; i < getEnrollStudentNumber(); i++)
			for (int j = i + 1; j < getEnrollStudentNumber(); j++) {
				if (scoreList[i] < scoreList[j]) {
					swap(j, i);
				}
			}
	}

	private void swap(int i, int j) {
		double tmp;
		tmp = scoreList[i];
		scoreList[i] = scoreList[j];
		scoreList[j] = tmp;
	}

	public void printScoreList() {
		for (int i = 0; i < getEnrollStudentNumber(); i++)
			System.out.print(scoreList[i] + " ");
		System.out.println(" ");
	}

	public int getFailedStudentNumber(int passScore) {
		int count = 0;
		for (int l = 0; l < getEnrollStudentNumber(); l++) {
			if (scoreList[l] < passScore)
				count++;
		}
		return count;
	}

	public int getEnrollStudentNumber() {
		return scoreList.length;
	}

	public double getPassRatio(int passScore) {

		return Calculator.div(getEnrollStudentNumber()
				- getFailedStudentNumber(passScore), getEnrollStudentNumber());

	}

}

//1.getAvg()中count一直為0，要成無限loop
//改成：count++; count < getEnrollStudentNumber()
//2.getAvg()中i <= getEnrollStudentNumber()，則scoreList[length](無定義)也會被放進來
//改成：count < getEnrollStudentNumber()
//3.getFailedStudentNumber(int passScore)中count = count + l中把編號l當人數加
//改成：count++;


