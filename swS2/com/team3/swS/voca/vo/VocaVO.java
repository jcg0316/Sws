package team3.swS.voca.vo;

public class VocaVO {
	
	private String voca_no;
	private String voca_mean;
	private String voca_word;
	private int voca_learn_freq;
	private int voca_frequency;
	private String voca_lvoca_no;
	private String voca_name;
	
	
	
	public String getVoca_no() {
		return voca_no;
	}
	public void setVoca_no(String voca_no) {
		this.voca_no = voca_no;
	}
	public String getVoca_mean() {
		return voca_mean;
	}
	public void setVoca_mean(String voca_mean) {
		this.voca_mean = voca_mean;
	}
	public String getVoca_word() {
		return voca_word;
	}
	public void setVoca_word(String voca_word) {
		this.voca_word = voca_word;
	}
	public int getVoca_learn_freq() {
		return voca_learn_freq;
	}
	public void setVoca_learn_freq(int voca_learn_freq) {
		this.voca_learn_freq = voca_learn_freq;
	}
	public int getVoca_frequency() {
		return voca_frequency;
	}
	public void setVoca_frequency(int voca_frequency) {
		this.voca_frequency = voca_frequency;
	}
	public String getVoca_lvoca_no() {
		return voca_lvoca_no;
	}
	public void setVoca_lvoca_no(String voca_lvoca_no) {
		this.voca_lvoca_no = voca_lvoca_no;
	}
	public String getVoca_name() {
		return voca_name;
	}
	public void setVoca_name(String voca_name) {
		this.voca_name = voca_name;
	}
	
	
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("NO : " + voca_no);
		sb.append(" , WORD : " + voca_word);
		sb.append(" , MEAN : " + voca_mean);
		sb.append(" , FREQUENCY : " + voca_frequency);
		sb.append(" , LEARN_FREQ : " + voca_learn_freq);
		sb.append(" , LVOCA_NO : " + voca_lvoca_no);
		sb.append(" , VOCA_NAME : " + voca_name);
		
		return sb.toString();
		
	}
	
	
	public VocaVO(String voca_no, String voca_mean, String voca_word, int voca_learn_freq, int voca_frequency,
			String voca_lvoca_no, String voca_name) {
		super();
		this.voca_no = voca_no;
		this.voca_mean = voca_mean;
		this.voca_word = voca_word;
		this.voca_learn_freq = voca_learn_freq;
		this.voca_frequency = voca_frequency;
		this.voca_lvoca_no = voca_lvoca_no;
		this.voca_name = voca_name;
	}
	
	
	public VocaVO() {
		super();
		this.voca_no = voca_no;
		this.voca_mean = voca_mean;
		this.voca_word = voca_word;
		this.voca_learn_freq = voca_learn_freq;
		this.voca_frequency = voca_frequency;
		this.voca_lvoca_no = voca_lvoca_no;
		this.voca_name = voca_name;
	}
	
	
	
	
	
}
