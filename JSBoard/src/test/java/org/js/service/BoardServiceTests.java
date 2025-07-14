package org.js.service;

import org.js.domain.BoardVO;
import org.js.mapper.BoardMapperTests;
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
public class BoardServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@Test
	public void testRegister() {
		
		BoardVO board = new BoardVO();
		
		board.setTitle("서비스 제목 테스트");
		board.setContent("서비스 내용 테스트");
		board.setWriter("이재상");
		
		service.register(board);
		
		log.info("생성된 게시물의 번호 : " + board.getBno());
	} // testRegister메서드 종료
	
	@Test
	public void testGetList() {
		
		service.getList().forEach(board -> log.info(board));
	} // testGetList메서드 종료
	
	@Test
	public void testGetOne() {
		
		log.info(service.get(1L));
	} // testGetOne메서드 종료
	
	@Test
	public void testUpdate() {
		
		BoardVO board = service.get(2L);
		
		if(board == null) {
			log.info("찾는 게시물이 없습니다.");
			return;
		} // if 종료
		
		board.setTitle("서비스로 수정한 제목");
		board.setContent("서비스에서 수정한 내용");
		board.setWriter("이재상");
		log.info("수정된 결과 출력 : " + service.modify(board));
	} // testUpdate메서드 종료
	
	@Test
	public void testDelete() {
		
		log.info("삭제된 결과 : " + service.remove(2L));
	}
	
}
