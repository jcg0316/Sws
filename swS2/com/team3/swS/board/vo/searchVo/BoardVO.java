package team3.swS.board.vo.searchVo;

public class BoardVO {
	private String board_apticle_no;		// 게시글 번호
	private String board_mem_no;			// 회원번호
	private String board_contents;			// 글 내용
	private String board_date;				// 작성일
	private String board_del;				// 삭제여부
	private String board_parent_apticle_id; // 계층형 부모글 아이디
	private String board_category;			// 게시판 분류 번호(ex: 공지사항 A, Q&A B, 도움말 C)
	private String board_title;				// 글 제목
	private String board_mem_nick;			// 회원닉네임

	public BoardVO() {
	}

	public String getBoard_apticle_no() {
		return board_apticle_no;
	}

	public void setBoard_apticle_no(String board_apticle_no) {
		this.board_apticle_no = board_apticle_no;
	}

	public String getBoard_mem_no() {
		return board_mem_no;
	}

	public void setBoard_mem_no(String board_mem_no) {
		this.board_mem_no = board_mem_no;
	}

	public String getBoard_contents() {
		return board_contents;
	}

	public void setBoard_contents(String board_contents) {
		this.board_contents = board_contents;
	}

	public String getBoard_date() {
		return board_date;
	}

	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}

	public String getBoard_del() {
		return board_del;
	}

	public void setBoard_del(String board_del) {
		this.board_del = board_del;
	}

	public String getBoard_parent_apticle_id() {
		return board_parent_apticle_id;
	}

	public void setBoard_parent_apticle_id(String board_parent_apticle_id) {
		this.board_parent_apticle_id = board_parent_apticle_id;
	}

	public String getBoard_category() {
		return board_category;
	}

	public void setBoard_category(String board_category) {
		this.board_category = board_category;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_mem_nick() {
		return board_mem_nick;
	}

	public void setBoard_mem_nick(String board_mem_nick) {
		this.board_mem_nick = board_mem_nick;
	}
	
	

}
