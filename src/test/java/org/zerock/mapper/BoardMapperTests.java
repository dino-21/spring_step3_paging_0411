package org.zerock.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

  @Autowired
  private BoardMapper mapper;
  
  @Test
  public void testGetList() {
	  mapper.getList().forEach(board->log.info(board));
  }
  
  @Test
  public void testInsert() {
	  BoardVO board = new BoardVO();
	  board.setTitle("새로 작성하는 글");
	  board.setContent("새로 작성하는 글");
	  board.setWriter("newbie");
	  
	  mapper.insert(board);
	  log.info(board);
  }
  
  
  @Test
  public void testInsertSelectKey() {
	  BoardVO board = new BoardVO();
	  board.setTitle("새로 작성하는 글 select key");
	  board.setContent("새로 작성하는 내용 select key");
	  board.setWriter("newbie");
	  
	  mapper.insertSelectKey(board);
	  log.info(board);
	  
  }
  
  
  @Test
  public void testRead() {
	  BoardVO board = mapper.read(6L);
	  log.info(board);
  }
  
  @Test
  public void testDelete() {
 	  log.info("delete num :" + mapper.delete(7L));
  }
  
  @Test
  public void testUpdate() {
	  BoardVO board = new BoardVO();
	  
	  board.setBno(6L);
	  board.setTitle("수정된 제목12");
	  board.setContent("수정된 내용12");
	  board.setWriter("user00");
	  
	  int count = mapper.update(board);
	  log.info("update num :" + count);
  }
  
  
  @Test
  public void testPageing() {
	  Criteria cri = new Criteria(2,5);
	  List<BoardVO> list = mapper.getListWithPaging(cri);
	  list.forEach(board->log.info(board));
  }
  
}
