package com.zerock.guestbook.service;

import com.zerock.guestbook.dto.GuestbookDTO;
import com.zerock.guestbook.dto.PageRequestsDTO;
import com.zerock.guestbook.dto.PageResultDTO;
import com.zerock.guestbook.entity.Guestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * packageName : com.zerock.guestbook.service
 * className : GuestbookServiceTests
 * user : jwlee
 * date : 2022/09/24
 */
@SpringBootTest
public class GuestbookServiceTests {

    @Autowired
    private GuestbookService service;

    @Test
    public void 등록테스트() {
        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .title("Sample Title...")
                .content("Sample Content...")
                .writer("user0")
                .build();

        System.out.println(service.register(guestbookDTO));
    }

    @Test
    public void 목록처리테스트() {

        PageRequestsDTO pageRequestsDTO = PageRequestsDTO.builder().page(1).size(10).build();

        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestsDTO);

        for (GuestbookDTO guestbookDTO : resultDTO.getDoList()) {
            System.out.println(guestbookDTO);
        }
    }

    @Test
    public void 리스트테스트() {

        PageRequestsDTO pageRequestsDTO = PageRequestsDTO.builder()
                .page(1)
                .size(10)
                .build();

        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestsDTO);

        System.out.println("PREV: " + resultDTO.isPrev());
        System.out.println("NEXT: " + resultDTO.isNext());
        System.out.println("TOTAL: " + resultDTO.getTotalPage());
        System.out.println("----------------------------------------");
        for (GuestbookDTO guestbookDTO : resultDTO.getDoList()) {
            System.out.println(guestbookDTO);
        }
        System.out.println("----------------------------------------");
        resultDTO.getPageList().forEach(i -> System.out.println(i));
    }
}
