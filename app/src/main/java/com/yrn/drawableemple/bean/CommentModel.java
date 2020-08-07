package com.yrn.drawableemple.bean;

import java.io.Serializable;

/**
 * Cod
 * <p>
 * Created by Xinhoo on 2020/5/18
 * Describe: 评论的实体Bean
 *
 */
public class CommentModel implements Serializable {

    //朋友圈ID
    private  String momentsId;
    //评论id
    private String commentId;
    //评论用户ID
    private String reviewUid;
    //评论用户名字
    private String reviewUName;
    //被回复用户ID 如果是0  就不是回复
    private String replyUid;
    //被回复用户名字
    private String replyUName;
    //评论内容
    private String reviewContent;
    //评论状态 状态1：正常 2：删除 3:失败
    private int commentStatus;

    //标记 “点击的是否 被回复者”；（false：点击回复者；true：点击的被回复者）
    private boolean isClickReplay;

    public CommentModel(String momentsId, String commentId) {
        this.momentsId = momentsId;
        this.commentId = commentId;
    }

    public String getReviewUid() {
        return reviewUid;
    }

    public void setReviewUid(String reviewUid) {
        this.reviewUid = reviewUid;
    }

    public String getReviewUName() {
        return reviewUName;
    }

    public void setReviewUName(String reviewUName) {
        this.reviewUName = reviewUName;
    }

    public String getReplyUid() {
        return replyUid;
    }

    public void setReplyUid(String replyUid) {
        this.replyUid = replyUid;
    }

    public String getReplyUName() {
        return replyUName;
    }

    public void setReplyUName(String replyUName) {
        this.replyUName = replyUName;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public int getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(int commentStatus) {
        this.commentStatus = commentStatus;
    }

    public boolean isClickReplay() {
        return isClickReplay;
    }

    public void setClickReplay(boolean clickReplay) {
        isClickReplay = clickReplay;
    }

    public String getMomentsId() {
        return momentsId;
    }

    public void setMomentsId(String momentsId) {
        this.momentsId = momentsId;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
}
