package kr.co.tjoeun.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import kr.co.tjoeun.bean.ContentBean;

public interface BoardMapper {
  
	// 현재 sequence 값 가져오기
  @SelectKey(statement = "SELECT content_seq.nextval FROM DUAL",
		  	 keyProperty = "content_idx", before = true, resultType = int.class)	
	
  // content_table 에 insert 하기
  @Insert("INSERT INTO content_table(content_idx, content_subject, content_text, " +
  	      "content_file, content_writer_idx, content_board_idx, content_date) " + 
  	      "VALUES(#{content_idx}, #{content_subject}, #{content_text}, " +
  	      "#{content_file, jdbcType=VARCHAR}, #{content_writer_idx}, #{content_board_idx}, sysdate)")
  void addContentInfo(ContentBean writeContentBean);
  
  // 게시판 index 로 게시판 이름 가져오기(조회하기)  <-- SELECT
  @Select("SELECT board_info_name " + 
  	      "FROM board_info_table " + 
  	      "WHERE board_info_idx=#{board_info_idx}")
  String getBoardInfoName(int board_info_idx);
  
  // 게시글 리스트 가져오기
  @Select("SELECT c.content_idx, c.content_subject, u.user_name content_writer_name, " +
  	      "TO_CHAR(c.content_date, 'YYYY-MM-DD') content_date " + 
  	      "FROM content_table c, user_table u " + 
  	      "WHERE c.content_writer_idx = u.user_idx " +
  	      "AND c.content_board_idx = #{c.board_info_idx} " +
  	      "ORDER BY c.content_idx desc")  
  ArrayList<ContentBean> getContentList(int board_info_idx);
  
  // 상세페이지에 출력할 데이터 가져오기
  // 작성자(이름)-user_name(content_writer_name), 
  // 작성날짜-content_date, 제목-content_subject, 
  // 내용-cotent.text, 첨부이미지-content_file
  @Select("SELECT u.user_name content_writer_name, " + 
  	      "TO_CHAR(content_date, 'YYYY-MM-DD') content_date, " + 
  	      "c.content_subject, c.content_text, c.content_file " + 
  	      "FROM content_table c, user_table u " + 
  	      "WHERE c.content_writer_idx = u.user_idx " + 
  	      "AND c.content_idx = ${content_idx}")
  ContentBean getContentInfo(int content_idx);
  
  
  
 
}








