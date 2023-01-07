package com.zerock.guestbook.controller;

import com.zerock.guestbook.dto.GuestbookDTO;
import com.zerock.guestbook.dto.PageRequestsDTO;
import com.zerock.guestbook.service.GuestbookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * packageName : com.zerock.guestbook.controller
 * className : GuestbookController
 * user : jwlee
 * date : 2022/09/22
 */
@Controller
@RequestMapping("/guestbook")
@Log4j2
@RequiredArgsConstructor
public class GuestbookController {

    private final GuestbookService guestbookService;

    @GetMapping("/")
    public String index(){
        return "redirect:/guestbook/list";
    }

    @GetMapping("/list")
    public void list(PageRequestsDTO pageRequestsDTO, Model model){
        model.addAttribute("result", guestbookService.getList(pageRequestsDTO));
    }

    @GetMapping("/register")
    public void register(){
        log.info("register get...");
    }

    @PostMapping("/register")
    public String registerPost(GuestbookDTO dto, RedirectAttributes redirectAttributes){
        log.info("dto..." + dto);

        // 새로 추가된 엔티티 번호
        Long gno = guestbookService.register(dto);
        redirectAttributes.addFlashAttribute("msg", gno);
        return "redirect:/guestbook/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(long gno, @ModelAttribute("requestsDTO") PageRequestsDTO requestsDTO, Model model) {
        GuestbookDTO dto = guestbookService.read(gno);
        model.addAttribute("dto", dto);
    }

    @PostMapping("/remove")
    public String remove(long gno, RedirectAttributes redirectAttributes) {
        log.info("gno: " + gno);
        guestbookService.remove(gno);
        redirectAttributes.addFlashAttribute("msg", gno);
        return "redirect:/guestbook/list";
    }

    @PostMapping("/modify")
    public String modify(GuestbookDTO dto, @ModelAttribute("requestDTO") PageRequestsDTO requestsDTO,
                         RedirectAttributes redirectAttributes) {

        guestbookService.modify(dto);

        redirectAttributes.addAttribute("page", requestsDTO.getPage());
        redirectAttributes.addAttribute("gno", dto.getGno());
        redirectAttributes.addAttribute("keyword", requestsDTO.getKeyword());
        redirectAttributes.addAttribute("gno", dto.getGno());

        return "redirect:/guestbook/read";
    }
}
