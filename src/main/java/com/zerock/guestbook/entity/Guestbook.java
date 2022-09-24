package com.zerock.guestbook.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * packageName : com.zerock.guestbook.entity
 * className : Guestbook
 * user : jwlee
 * date : 2022/09/23
 */
@Entity
@Getter
@NoArgsConstructor
public class Guestbook extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gno;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 1500, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;

    @Builder
    public Guestbook(Long gno, String title, String content, String writer) {
        this.gno = gno;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    /**
     * 제목 변경
     * @param title
     */
    public void changeTitle(String title) {
        this.title = title;
    }

    /**
     * 냐용 변경
     * @param content
     */
    public void changeContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "{" +
                "gno=" + gno +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
}
