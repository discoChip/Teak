package metro.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import metro.dao.mDao;
import metro.dto.mDto;

public class mBiz implements mBizInterface {
	
	mDao dao = new mDao();
	
	@Override
	public List<mDto> getuSellectEnabled(String id) {
		
		return dao.uSellectEnabled(id);
	}

	@Override
	public int getuUpdate(mDto mDto) {
		
		return dao.uUpdate(mDto);
	}

	@Override
	public int getuDelUser(String id) {
		
		return dao.uDelUser(id);
	}

	@Override
	public int getwInsert(mDto mDto) {
		
		return dao.wInsert(mDto);
	}

	@Override
	public int getwUpdate(mDto mDto) {
		
		return dao.wUpdate(mDto);
	}

	@Override
	public int getwDelete(int writeNo) {
		
		return dao.wDelete(writeNo);
	}

	@Override
	public int getcInsert(mDto mDto) {
		
		return dao.cInsert(mDto);
	}

	@Override
	public int getcUpdate(String content, int writeNo, int contentNo) {
		
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("content", content);
		map.put("writeNo", writeNo);
		map.put("contentNo", contentNo);
		
		return dao.cUpdate(map) ;
	}

	@Override
	public int getcDelete(int writeNo, int contentNo) {
		Map<String, Integer> map= new HashMap<String, Integer>();
		map.put("writeNo", writeNo);
		map.put("contentNo", contentNo);
		
		return dao.cDelete(map);
	}

	@Override
	public int getInsertUser(mDto dto) {
		
		return dao.insertUser(dto);
	}

	@Override
	public String getIdChk(String id) {
		
		return dao.idChk(id);
	}

	@Override
	public List<mDto> getboard(String role, int rowNo) {
		int end = rowNo*10;
		int start = end-9;
		
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("role", role);
		map.put("start", start);
		map.put("end", end);
		
		return dao.board(map);
	}

	@Override
	public int getallRow(String role) {
		
		return dao.allRow(role);
	}

	@Override
	public List<mDto> getsearch(String role, String where, String search) {
		Map<String, String> map= new HashMap<String, String>();
		map.put("role", role);
		map.put("where", where);
		map.put("search", search);
		
		return dao.search(map);
	}

	@Override
	public mDto getwriteDetail(int writeNo) {
		
		return dao.writeDetail(writeNo);
	}

	@Override
	public List<mDto> getcommentDetail(int writeNo) {
		
		return dao.commentDetail(writeNo);
	}

}
