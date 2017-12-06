package metro.biz;

import java.util.List;
import metro.dto.mDto;

public interface mBizInterface {
	
	public List<mDto> getuSellectEnabled(String id);       // 가입된 (Y)정보조회		
	public int getuUpdate(mDto mDto);            // 회원정보 수정	
	public int getuDelUser(String id);            // 회원 탈퇴	
	public int getwInsert(mDto mDto);             // 글쓰기	
	public int getwUpdate(mDto mDto);             // 글수정	
	public int getwDelete(int writeNo);           // 글삭제
	public int getcInsert(mDto mDto);             // 덧글쓰기
	public int getcUpdate(String content, int writeNo, int contentNo);   // 덧글수정
	public int getcDelete(int writeNo, int contentNo);   //덧글삭제
	
	public int getInsertUser(mDto dto);
	public String getIdChk(String id);
	public List<mDto> getboard(String role, int rowNo);
	public int getallRow(String role);
	public List<mDto> getsearch(String role, String where, String search);
	public mDto getwriteDetail(int writeNo);
	public List<mDto> getcommentDetail(int writeNo);
	
}