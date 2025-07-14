package org.js.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.js.domain.BoardVO;

public interface BoardMapper {
		
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);
	
	public int update(BoardVO board);
	
	public int delete(Long bno);
	
}
