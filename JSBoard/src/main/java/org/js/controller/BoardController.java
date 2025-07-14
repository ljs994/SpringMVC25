package org.js.controller;

import org.js.domain.BoardVO;
import org.js.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		
		log.info("컨드롤러에서 list메서드 실행");
		
		model.addAttribute("list", service.getList());
	} // list메서드 종료
	
	@GetMapping String register() {
		return "/board/register";
	} // register메서드 종료
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		log.info("컨트롤러에서 register메서드 실행");
		
		service.register(board);
		
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";
	} // register메서드 종료
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Long bno, Model model) {
		
		log.info("컨트롤러에서 get메서드 실행");
		
		model.addAttribute("board", service.get(bno));
	} // get메서드 종료
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		
		log.info("컨트롤러에서 modify메서드 실행");
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		} // if 종료
		return "redirect:/board/list";
	} // modify메서드 종료
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		
		log.info("컨트롤러에서 remove메서드 실행");
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		} // if 종료
		return "redirect:/board/list";
	} // remove메서드 종료
	
} // BoardController 종료
