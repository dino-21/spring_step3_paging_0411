package org.zerock.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Autowired
	private BoardService service;


	
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 시작하는 글");
		board.setContent("새로 시작하는 내용");
		board.setWriter("newbie");
		service.register(board);
		log.info("생성된 게시물의 번호: " + board.getBno());
	}
	
	@Test
	public void testGetList() {
		//service.getList().forEach(board->log.info(board));
		List<BoardVO> list = service.getList(new Criteria(2,10));  //2페이지 10개
		list.forEach(board->log.info(board));
	}
	
	
	@Test
	public void testGet() {
		log.info(service.get(8L));
	}

	@Test
	public void testDelete() {
		log.info("remove num:" + service.remove(5L));
	}
	
	
	@Test
	public void testUpdate() {
		BoardVO board = service.get(4L);
		
		if(board == null) {return;}

		board.setTitle("제목 수정합니다.");
		log.info("modify: " + service.modify(board));
	}
	
	
}














