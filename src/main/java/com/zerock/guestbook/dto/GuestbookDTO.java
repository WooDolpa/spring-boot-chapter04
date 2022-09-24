package com.zerock.guestbook.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * packageName : com.zerock.guestbook.dto
 * className : GuestbookDTO
 * user : jwlee
 * date : 2022/09/24
 */
@NoArgsConstructor
@Data
public class GuestbookDTO {

    private Long gno;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate, modDate;

    @Builder
    public GuestbookDTO(Long gno, String title, String content, String writer, LocalDateTime regDate, LocalDateTime modDate) {
        this.gno = gno;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.regDate = regDate;
        this.modDate = modDate;
    }
}
