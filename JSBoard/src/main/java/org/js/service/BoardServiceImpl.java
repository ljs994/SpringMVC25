package org.js.service;

import java.util.List;

import org.js.domain.BoardVO;
import org.js.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class BoardServiceImpl  implements BoardService{
	
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		
		log.info("register메서드 실행");
		mapper.insertSelectKey(board);
		log.info("등록후 리스트 출력");
		mapper.getList();
		
	} // register메서드 종료

	@Override
	public BoardVO get(Long bno) {
		
		log.info("get메서드 실행");
		
		return mapper.read(bno);
	} // get메서드 종료

	@Override
	public boolean modify(BoardVO board) {
		
		log.info("modify 메서드 실행");
		
		return mapper.update(board) == 1;
	} // modify메서드 종료

	@Override
	public boolean remove(Long bno) {
		
		log.info("remove 메서드 실행");
		
		return mapper.delete(bno) == 1;
	} // remove메서드 종료

	@Override
	public List<BoardVO> getList() {
		
		log.info("getList 메서드 실행");
		
		return mapper.getList();
	} // getList메서드 종료
	
	
}
