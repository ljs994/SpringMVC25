package org.js.mapper;

import org.js.domain.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		
		mapper.getList().forEach(board -> log.info(board));
	} // testGetList메서드 종료
	
	@Test
	public void testInsert() {
		
		BoardVO board = new BoardVO();
		
		board.setTitle("제목");
		board.setContent("내용");
		board.setWriter("이재상");
		
		mapper.insert(board);
		
		log.info(board);
	} // testInsert메서드 종료
	
	@Test
	public void testInsertSelectKey() {
		
		BoardVO board = new BoardVO();
		
		board.setTitle("테스트제목10");
		board.setContent("테스트 내용10");
		board.setWriter("이재상");
		
		mapper.insert(board);
		
		log.info(board);
	} // testInsertSelectKey메서드 종료
	
	@Test
	public void testRead() {
		
		BoardVO board = mapper.read(1L);
		
		log.info(board);
	} // testRead메서드 종료
	
	@Test
	public void testUpdate() {
		
		BoardVO board = new BoardVO();
		
		board.setBno(1L);
		board.setTitle("수정한 제목");
		board.setContent("수정한 내용");
		board.setWriter("수정함");
		
		int count = mapper.update(board);
		log.info("수정된 갯수 : " + count + "건");
		log.info("수정된 게시물 출력 : " + board);
	} // testUpdate메서드 종료
	
	@Test
	public void testDelete() {
		
		int count = mapper.delete(9L);
		log.info("삭제된 갯수 : " + count + "건");
	} // testDelete메서드 종료

}
