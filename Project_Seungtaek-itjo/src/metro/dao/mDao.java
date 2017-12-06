package metro.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.ibatis.session.SqlSession;
import metro.dto.mDto;

public class mDao extends SqlMapConfig implements mDaoInterface {
	
	SqlSession session;
	
	public mDao() {
		session = null;
	}
	
	/*public static void main(String[] args) {
		mDao dao = new mDao();
		Map<String, String> map = new HashMap<String, String>();
		map.put("search", "햄");
		map.put("where", "NICKNAME");
		map.put("role", "USER");
		
		if(dao.search(map).isEmpty()) {
			System.out.println("검색결과 없음");
		} else {
			System.out.println("??");
		}
		
	}*/
	
	@Override //가입된(Y)정보조회
	public List<mDto> uSellectEnabled(String id) {
		List<mDto> res=new ArrayList<mDto>();
		
		session=getSqlSessionFactory().openSession(true);
		res=session.selectList(nameSpace+"uSellectEnabled",id);
		System.out.println("uSellectEnabled 조회");
		
		session.close();
		System.out.println("session 닫기");
		
		return res;
	}

	@Override //회원정보 수정
	public int uUpdate(mDto mDto) {
		int res=0;
		
		try {
			session=getSqlSessionFactory().openSession(false);
			res=session.update(nameSpace+"uUpdate",mDto);
			
			if(res>0) {
				session.commit();
				System.out.println("uUpdate 성공");
			}
		} catch (Exception e) {
			System.out.println("uUpdate 실패");
			session.rollback();
			e.printStackTrace();
		} finally {
			System.out.println("session 종료");
			session.close();
		}
		
		return res;
	}

	@Override //회원 탈퇴
	public int uDelUser(String id) {
		
		int res=0;
		
		try {
			session=getSqlSessionFactory().openSession(false);
			res=session.update(nameSpace+"uDelUser",id);
			
			if(res>0) {
				session.commit();
				System.out.println("uDelUser 성공");
			}
			
		} catch (Exception e) {
			System.out.println("uDelUser 실패");
			session.rollback();			
			e.printStackTrace();
		} finally {
			System.out.println("session 종료");
			session.close();
		}
		
		return res;
	}

	@Override //회원 글쓰기
	public int wInsert(mDto mDto) {
		
		int res=0;
		
		try {
			session=getSqlSessionFactory().openSession(false);
			res=session.insert(nameSpace+"wInsert",mDto);
			
			if(res>0) {
				session.commit();
				System.out.println("wInsert 성공");
			}
			
		} catch (Exception e) {
			System.out.println("wInsert 실패");
			session.rollback();			
			e.printStackTrace();
		} finally {
			System.out.println("session 종료");
			session.close();
		}
		
		return res;
	}

	@Override //회원 글수정
	public int wUpdate(mDto mDto) {
	
		int res=0;
		
		try {
			session=getSqlSessionFactory().openSession(false);
			res=session.update(nameSpace+"wUpdate",mDto);
			
			if(res>0) {
				session.commit();
				System.out.println("wUpdate 성공");
			}
			
		} catch (Exception e) {
			System.out.println("wUpdate 실패");
			session.rollback();			
			e.printStackTrace();
		} finally {
			System.out.println("session 종료");
			session.close();
		}		
		
		return res;
	}

	@Override //회원 글 삭제
	public int wDelete(int writeNo) {

		int res=0;
		
		try {
			session=getSqlSessionFactory().openSession(false);
			res=session.update(nameSpace+"wDelete",writeNo);
			
			if(res>0) {
				session.commit();
				System.out.println("wDelete 성공");
			}
			
		} catch (Exception e) {
			System.out.println("wDelete 실패");
			session.rollback();			
			e.printStackTrace();
		} finally {
			System.out.println("session 종료");
			session.close();
		}
		
		return res;
	}

	@Override  //덧글 쓰기
	public int cInsert(mDto mDto) {
		SqlSession session=null;
		int res=0;
		
		try {
			session=getSqlSessionFactory().openSession(false);
			res=session.insert(nameSpace+"cInsert",mDto);
			
			if(res>0) {
				session.commit();
				System.out.println("cInsert 성공");
			}
			
		} catch (Exception e) {
			System.out.println("cInsert 실패");
			session.rollback();			
			e.printStackTrace();
		} finally {
			System.out.println("session 종료");
			session.close();
		}
		return res;
	}

	@Override  //덧글 수정
	public int cUpdate(Map<String,Object> map) {
	
		int res=0;
		
		try {
			session=getSqlSessionFactory().openSession(false);
			res=session.update(nameSpace+"cUpdate",map);
			
			if(res>0) {
				session.commit();
				System.out.println("cUpdate 성공");
			}
			
		} catch (Exception e) {
			System.out.println("cUpdate 실패");
			session.rollback();			
			e.printStackTrace();
		} finally {
			System.out.println("session 종료");
			session.close();
		}
		
		
		return res;
	
	}

	@Override //덧글 삭제
	public int cDelete(Map<String,Integer> map) {
	
		int res=0;
		
		
		try {
			session=getSqlSessionFactory().openSession(false);
			res=session.update(nameSpace+"cDelete",map);
			
			if(res>0) {
				session.commit();
				System.out.println("cDelete 성공");
			}
			
		} catch (Exception e) {
			System.out.println("cDelete 실패");
			session.rollback();			
			e.printStackTrace();
		} finally {
			System.out.println("session 종료");
			session.close();
		}
		return res;
	}

	@Override
	public int insertUser(mDto dto) {
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(nameSpace+"insertUser", dto);
			
			if(res>0) {
				session.commit();
			}
			System.out.println("insertUser 성공");
		} catch (Exception e) {
			System.out.println("insertUser 실패");
			e.printStackTrace();
			session.rollback();
		} finally {
			System.out.println("session close");
			session.close();
		}
		
		return res;
	}

	@Override
	public String idChk(String id) {
		String res = null;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.selectOne(nameSpace+"idChk", id);
		
		session.close();
		
		return res;
	}

	@Override
	public List<mDto> board(Map<String, Object> map) {
		List<mDto> res = new ArrayList<mDto>();
		
		session = getSqlSessionFactory().openSession(true);
		res = session.selectList(nameSpace+"board", map);
		
		session.close();
		
		return res;
	}

	@Override
	public int allRow(String role) {
		int res = 0;
		
		session = getSqlSessionFactory().openSession(true);
		res = session.selectOne(nameSpace+"allRow", role);
		
		session.close();
		
		return res;
	}

	@Override
	public List<mDto> search(Map<String, String> map) {
		List<mDto> res = new ArrayList<mDto>();
		
		session = getSqlSessionFactory().openSession(true);
		res = session.selectList(nameSpace+"search", map);
		
		session.close();
		
		return res;
	}

	@Override
	public mDto writeDetail(int writeNo) {
		mDto res = new mDto();
		
		session = getSqlSessionFactory().openSession(true);
		res = session.selectOne(nameSpace+"writeDetail", writeNo);
		
		session.close();
		
		return res;
	}

	@Override
	public List<mDto> commentDetail(int writeNo) {
		List<mDto> res = new ArrayList<mDto>();
		
		session = getSqlSessionFactory().openSession(true);
		res = session.selectList(nameSpace+"commentDetail", writeNo);
		
		session.close();
		
		return res;
	}

}
