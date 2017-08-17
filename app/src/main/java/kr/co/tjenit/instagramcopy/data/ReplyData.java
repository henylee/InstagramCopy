package kr.co.tjenit.instagramcopy.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by the on 2017-08-17.
 */

public class ReplyData implements Serializable {

    private int replyId; // DB와의 연동을 고려한 id
    private String content; // 댓글의 내용.
    private Calendar createdAt; // 댓글이 쓰여진 시간.

    // 댓글과 다른 객체들간의 관계.
    // 댓글 -> 작성자(1)
    private UserData writerData;
    // 댓글 -> 좋아하는 사람들
    private List<UserData> likeUsers = new ArrayList<>();

    // 댓글 <- 부모댓글.
    // 부모댓글의 id값을 저장함으로써, 대댓글임을 명시.
    private int parentReplyId;

}
