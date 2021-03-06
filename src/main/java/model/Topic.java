package model;


import lombok.Data;
import util.TopicUtil;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
public class Topic {
    private int id;
    private String title;
    private String desc;

    private LocalDateTime shareDate;
    private int viewCount;
    private User user;
    private List<Comment> commentList;
    private int commentCount;
    private int status;

    public Topic(){
        commentList = new ArrayList<>();
    }

    public void addComment(Comment comment){
        commentList.add(comment);
    }


}
