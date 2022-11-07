package com.k2web.board.controller;

import com.k2web.board.model.BoardDTO;
import com.k2web.board.model.UserDTO;
import com.k2web.board.service.BoardService;
import com.k2web.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

  @Autowired
  private BoardService boardService;
  @Autowired
  private UserService userService;

  @RequestMapping("/selectAll")
  private String showFirstPage() {
    return "redirect:/board/showAll/1";
  }

  @RequestMapping("/showAll/{pageNo}")
  private String showAll(Model model, HttpSession session, @PathVariable int pageNo) {
    UserDTO logIn = (UserDTO) session.getAttribute("logIn");

    if( logIn == null) {
      return "redirect:/";
    }

    List<BoardDTO> list = boardService.selectAll(pageNo);
    HashMap<Integer, String> nicknameMap = new HashMap<>();

    for (BoardDTO b : list) {
      nicknameMap.put(b.getWriterId(), userService.selectOne(b.getWriterId()).getNickname());
    }

    model.addAttribute("list", list);
    model.addAttribute("nicknameMap", nicknameMap);
    model.addAttribute("currentPage", pageNo);
    model.addAttribute("lastPageNo", boardService.selectLastPage());
    return "/board/showAll";
  }

  @RequestMapping("/showOne/{boardId}")
  public String selectOne(@PathVariable int boardId, HttpSession session, Model model) {

    if (session.getAttribute("logIn") == null) {
      return "redirect:/";
    }

    BoardDTO b = boardService.selectOne(boardId);

    if (b == null) {
      return "redirect:/board/showAll";
    }

    model.addAttribute("b", b);
    model.addAttribute("nickname", userService.selectOne(b.getWriterId()).getNickname());

    UserDTO logIn = (UserDTO) session.getAttribute("logIn");
    model.addAttribute("logInId", logIn.getUserId());

    return "board/showOne";
  }

  @RequestMapping(value = "/write", method = RequestMethod.GET)
  private String write() {
    return "/board/write";
  }

  @RequestMapping(value = "/write", method = RequestMethod.POST)
  private String writeLogic(BoardDTO b, HttpSession session) {

    UserDTO logIn = (UserDTO) session.getAttribute("logIn");

    if (logIn == null) {
      return "redirect:/";
    }

    b.setWriterId(logIn.getUserId());
    b.setTitle(b.getTitle());
    b.setContent(b.getContent());

    boardService.insert(b);

    return "redirect:/board/selectAll";
  }

  @RequestMapping("/delete/{boardId}")
  private String delete(@PathVariable int boardId) {
    boardService.delete(boardId);
    return "redirect:/board/selectAll";
  }

  @RequestMapping(value = "/update/{boardId}", method = RequestMethod.GET)
  private String update(@PathVariable int boardId, Model model) {
    model.addAttribute("boardId", boardId);
    return "/board/update";
  }

  @RequestMapping(value = "/update/{boardId}", method = RequestMethod.POST)
  private String updateLogic(String title, String content, @PathVariable int boardId ) {
    BoardDTO b = new BoardDTO();
    b.setTitle(title);
    b.setContent(content);
    b.setBoardId(boardId);
    boardService.update(b);

    return "redirect:/board/showOne/" + boardId;
  }



  @RequestMapping("/init")
  public String insertAll() {
    for (int i = 1; i <= 22; i++) {
      BoardDTO b = new BoardDTO();
      // 작성자의 아이디를 설정해주는 코드
      b.setWriterId(2);
      b.setTitle(i + "번째 게시글입니다.");
      b.setContent(i + "번째 게시글의 내용입니다 ! ! 다다다다다다");

      boardService.insert(b);
    }
    return "redirect:/";
  }


}
