package com.lec.ch17.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch17.model.Board;
import com.lec.ch17.service.BoardService;
import com.lec.ch17.util.Paging;

@Controller
@RequestMapping("mvcBoard") // 공통 요청경로
public class BoardController {
	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "list", method = { RequestMethod.GET, RequestMethod.POST })
	public String bodList(String pageNum, Model model) {
		model.addAttribute("boardList", boardService.boardList(pageNum));
		model.addAttribute("paging", new Paging(boardService.boardTotCnt(), pageNum, 10, 5));
		return "mvcBoard/list";
	}

	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String writeView() {
		return "mvcBoard/write";
	}

	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(Board board, HttpServletRequest request, Model model) {
		board.setBip(request.getRemoteAddr());
		model.addAttribute("writeResult", boardService.boardWrite(board, request));
		return "forward:list.do";
	}

	@RequestMapping(value = "content", method = { RequestMethod.GET, RequestMethod.POST })
	public String detail(int bid, Model model) {
		model.addAttribute("contentBoard", boardService.boardContent(bid));
		return "mvcBoard/content";
	}

	@RequestMapping(value = "modifyView", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifView(int bid, Model model) {
		model.addAttribute("board", boardService.boardModifyReplyView(bid));
		return "mvcBoard/board";
	}

	@RequestMapping(value = "modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(Board board, HttpServletRequest request, Model model) {
		board.setBip(request.getRemoteAddr());
		model.addAttribute("modifyResult", boardService.boardModify(board));
		return "forward:list.do";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("deleteResult", boardService.boardDelete(bid));
		return "forward:list.do";
	}

	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public String replyView(int bid, Model model) {
		model.addAttribute("board", boardService.boardModifyReplyView(bid));
		return "mvcBoard/reply";
	}

	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public String reply(Board board, HttpServletRequest request, Model model) {
		model.addAttribute("replyResult", boardService.boardReply(board, request));
		return "forward:list.do";
	}
}
