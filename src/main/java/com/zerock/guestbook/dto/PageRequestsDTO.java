package com.zerock.guestbook.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * packageName : com.zerock.guestbook.dto
 * className : PageRequestsDTO
 * user : jwlee
 * date : 2022/09/24
 */
@Data
public class PageRequestsDTO {

    private int page;
    private int size;

    @Builder
    public PageRequestsDTO(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public PageRequestsDTO() {
        this.page = 1;
        this.size = 10;
    }

    public Pageable getPageable(Sort sort) {
        return PageRequest.of(page-1, size, sort);
    }
}
