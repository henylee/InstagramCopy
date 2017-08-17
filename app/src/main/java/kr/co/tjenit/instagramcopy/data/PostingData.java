package kr.co.tjenit.instagramcopy.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by the on 2017-08-17.
 */

public class PostingData implements Serializable {
    // 게시하는 사진/동영상

    // 포스팅 데이터가 깆는 기본 속성
    private int postingId; // DB와 연동을 고려한 변수.
    private String ImageURL; // 게시판 포스팅의 사진이 있는 경로.
    private String content; //  사용자가 사진을 포스팅할때 첨부한 글.

    // 포스팅 데이터 갖는 관계.

    // 게시글 -> 작성자.
    private UserData writerData;
    // 게시글 -> 좋아한 사람들
    private List<UserData> likeUsers = new ArrayList<>();
    // 게시글 -> 댓글()
    // // TODO: 댓글 데이터가 정리되면 추가해야함.
    // 게시글 -> 해시태그 ()()
    private List<String> hashTags = new ArrayList<>();



}
