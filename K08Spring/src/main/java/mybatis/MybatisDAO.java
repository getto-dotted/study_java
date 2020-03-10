package mybatis;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MybatisDAO {

	//게시물 수 카운트하기
	public int getTotalCount(Map param);
	
	//리스트 가져오기
	public ArrayList<MyBoardDTO> list();
	
	//리스트 페이지 처리
	public ArrayList<MyBoardDTO> listPage(Map param);
	/*
	글쓰기 처리
	파라미터 처리방법3 : 파라미터 전달시 Mapper에서 바로 사용할
		이름을 지정하고 싶을 때 @Param 어노테이션을 활용한다.
		아래와 같이 저정된 이름은 #{_name}과 같이 사용할 수 있다. _필수는 아님.
	 */
	public int write(
			@Param("_name") String name, 
			@Param("_contents") String contents, 
			@Param("_id") String id);
	
	//기존 게시물 읽어오기
	public MyBoardDTO view(ParameterDTO parameterDTO);
	
	//게시물 수정
	public int modify(String idx, String name, String contents, String id);
	//게시물 삭제
	public int delete(String idx, String id);
	
}
