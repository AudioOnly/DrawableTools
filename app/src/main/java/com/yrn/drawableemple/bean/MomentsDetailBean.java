package com.yrn.drawableemple.bean;

import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Cod
 * <p>
 * Created by Xinhoo on 2020/5/21
 * Describe: 朋友圈-详情 实体类
 */
public class MomentsDetailBean implements Serializable {


    /**
     * commentList : [{"comments":"","createTime":0,"messageId":0,"messageStatus":0,"messageType":0,"modifyTime":0,"momentsId":0,"replayUser":"","replayUserNickName":"","userName":"","userNickName":"","userPic":""}]
     * content :
     * createTime : 0
     * fileProperties :
     * forbidCommentPraise : 0
     * modifyTime : 0
     * momentsId : 0
     * momentsStatus : 0
     * momentsType : 0
     * openCommentPraise : 0
     * praiseList : [{"comments":"","createTime":0,"messageId":0,"messageStatus":0,"messageType":0,"modifyTime":0,"momentsId":0,"replayUser":"","replayUserNickName":"","userName":"","userNickName":"","userPic":""}]
     * sharingScope : 0
     * userName :
     * userPic :
     * visibleUserIds :
     */

    private String content;//内容
    private long createTime;//创建时间
    private String fileProperties;
    private int forbidCommentPraise;//禁止评论点赞 1：禁止 2：不禁止
    private long modifyTime;
    private String momentsId;
    private int momentsStatus;
    //1:文本；2：图片；3：视频
    private int momentsType;
    private int openCommentPraise;
    private int sharingScope;
    //发朋友圈的用户的唯一id
    private String userName;
    private String userNickName;
    private String userPic;
    private String visibleUserIds;
    //地址
    private String position;
    //经纬度
    private String lng;
    private String lat;

    private String remindUserIds;
    private String remindUserShowNames;
    private String sendStatus;

    private int pageLayoutType;
    private String year;
    private String day;
    private boolean showYear;
    private boolean showDay;
    //头像缓存Key标志
    private String avatarSign;
    /**
     * 好友头像更新时间
     */
    private String changePicTime;

    public String getChangePicTime() {
        return changePicTime;
    }

    public void setChangePicTime(String changePicTime) {
        this.changePicTime = changePicTime;
    }


    private MomentsDetailBean nextBean1;
    private MomentsDetailBean nextBean2;

    public MomentsDetailBean getNextBean1() {
        return nextBean1;
    }

    public void setNextBean1(MomentsDetailBean nextBean1) {
        this.nextBean1 = nextBean1;
    }

    public MomentsDetailBean getNextBean2() {
        return nextBean2;
    }

    public void setNextBean2(MomentsDetailBean nextBean2) {
        this.nextBean2 = nextBean2;
    }

    /**
     * 当前登陆者的jid
     */
    private String ownerJid;

    public boolean isShowDay() {
        return showDay;
    }

    public void setShowDay(boolean showDay) {
        this.showDay = showDay;
    }

    public boolean isShowYear() {
        return showYear;
    }

    public void setShowYear(boolean showYear) {
        this.showYear = showYear;
    }

    public String getYear() {
        if (null == year){
            return "";
        }
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDay() {
        if (null == day){
            return "";
        }
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getPageLayoutType() {
        return pageLayoutType;
    }

    public void setPageLayoutType(int pageLayoutType) {
        this.pageLayoutType = pageLayoutType;
    }

    public String getSendStatus() {
        if (null == sendStatus){
            return "0";
        }
        return sendStatus;
    }

    public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus;
    }

    private List<CommentListBean> commentList;
    private List<PraiseListBean> praiseList;

    private boolean isExpanded;

    private SpannableStringBuilder contentSpan;

    private boolean isShowCheckAll;

    private SpannableStringBuilder praiseSpan;

    private MomentsDetailBean(Builder builder) {
        this.content = builder.content;
        this.createTime = builder.createTime;
        this.fileProperties = builder.fileProperties;
        this.forbidCommentPraise = builder.forbidCommentPraise;
        this.modifyTime = builder.modifyTime;
        this.momentsId = builder.momentsId;
        this.momentsStatus = builder.momentsStatus;
        this.momentsType = builder.momentsType;
        this.openCommentPraise = builder.openCommentPraise;
        this.sharingScope = builder.sharingScope;
        this.userName = builder.userName;
        this.userNickName = builder.userNickName;
        this.userPic = builder.userPic;
        this.visibleUserIds = builder.visibleUserIds;
        this.position = builder.position;
        this.lng = builder.lng;
        this.lat = builder.lat;
        this.remindUserIds = builder.remindPeopleString;
        this.commentList = builder.commentList;
        this.praiseList = builder.praiseList;
        this.isExpanded = builder.isExpanded;
        this.contentSpan = builder.contentSpan;
        this.isShowCheckAll = builder.isShowCheckAll;
        this.praiseSpan = builder.praiseSpan;
        this.ownerJid = builder.ownerJid;
        this.remindUserIds = builder.remindUserIds;
        this.remindUserShowNames = builder.remindUserShowNames;
        this.sendStatus = builder.sendStatus;
        this.pageLayoutType = builder.pageLayoutType;
        this.avatarSign = builder.avatarSign;

    }

    public String getOwnerJid() {
        return ownerJid;
    }

    public void setOwnerJid(String ownerJid) {
        this.ownerJid = ownerJid;
    }

    public MomentsDetailBean() {
    }


    public static Builder newMomentsDetailBean() {
        return new Builder();
    }

    public String getRemindUserIds() {
        return remindUserIds;
    }

    public void setRemindUserIds(String remindUserIds) {
        this.remindUserIds = remindUserIds;
    }

    public String getRemindUserShowNames() {
        if (null == remindUserShowNames){
            return "";
        }
        return remindUserShowNames;
    }

    public void setRemindUserShowNames(String remindUserShowNames) {
        this.remindUserShowNames = remindUserShowNames;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public SpannableStringBuilder getContentSpan() {
        return contentSpan;
    }

    public void setContentSpan(SpannableStringBuilder contentSpan) {
        this.contentSpan = contentSpan;
    }

    public boolean isShowCheckAll() {
        return isShowCheckAll;
    }

    public void setShowCheckAll(boolean showCheckAll) {
        isShowCheckAll = showCheckAll;
    }

    public SpannableStringBuilder getPraiseSpan() {
        return praiseSpan;
    }

    public void setPraiseSpan(SpannableStringBuilder praiseSpan) {
        if (null == praiseSpan){
            return;
        }
        this.praiseSpan = praiseSpan;
    }

    public String getContent() {
        if (null==content){
            return "";
        }
        return content;
    }

    public void setContent(String content) {
        setContentSpan(new SpannableStringBuilder(content));
        this.content = content;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getFileProperties() {
        if (null==fileProperties){
            return "";
        }
        return fileProperties;
    }

    public void setFileProperties(String fileProperties) {
        this.fileProperties = fileProperties;
    }

    public int getForbidCommentPraise() {
        return forbidCommentPraise;
    }

    public void setForbidCommentPraise(int forbidCommentPraise) {
        this.forbidCommentPraise = forbidCommentPraise;
    }

    public long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getMomentsId() {
        if (null==momentsId){
            return "";
        }
        return momentsId;
    }

    public void setMomentsId(String momentsId) {
        this.momentsId = momentsId;
    }

    public int getMomentsStatus() {
        return momentsStatus;
    }

    public void setMomentsStatus(int momentsStatus) {
        this.momentsStatus = momentsStatus;
    }

    public int getMomentsType() {
        return momentsType;
    }

    public void setMomentsType(int momentsType) {
        this.momentsType = momentsType;
    }

    public int getOpenCommentPraise() {
        return openCommentPraise;
    }

    public void setOpenCommentPraise(int openCommentPraise) {
        this.openCommentPraise = openCommentPraise;
    }

    public int getSharingScope() {
        return sharingScope;
    }

    public void setSharingScope(int sharingScope) {
        this.sharingScope = sharingScope;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getVisibleUserIds() {
        return visibleUserIds;
    }

    public void setVisibleUserIds(String visibleUserIds) {
        this.visibleUserIds = visibleUserIds;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public List<CommentListBean> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentListBean> commentList) {
        if (commentList == null) {
            commentList = new ArrayList<>();
        }
        this.commentList = commentList;
    }

    public List<PraiseListBean> getPraiseList() {
        if (praiseList == null) {
            praiseList = new ArrayList<>();
        }
        return praiseList;
    }

    public void setPraiseList(List<PraiseListBean> praiseList) {
        this.praiseList = praiseList;
    }

    public String getAvatarSign() {
        if (null == avatarSign || TextUtils.isEmpty(avatarSign)){
            return "";
        }
        return avatarSign;
    }

    public void setAvatarSign(String avatarSign) {
        this.avatarSign = avatarSign;
    }

    public static class CommentListBean implements Serializable{
        /**
         * comments :
         * createTime : 0
         * messageId : 0
         * messageStatus : 0
         * messageType : 0
         * modifyTime : 0
         * momentsId : 0
         * replayUser :
         * replayUserNickName :
         * userName :
         * userNickName :
         * userPic :
         */

        private String comments;
        private long createTime;
        private String messageId;
        //状态1：正常 2：删除
        private int messageStatus;
        private int messageType;
        private long modifyTime;
        private String momentsId;
        private String replayUser;
        private String replayUserNickName;
        private String userName;
        private String userNickName;
        private String userPic;
        private int sendStatus;
        /**
         * 好友头像更新时间
         */
        private String changePicTime;

        public String getChangePicTime() {
            return changePicTime;
        }

        public void setChangePicTime(String changePicTime) {
            this.changePicTime = changePicTime;
        }
        public CommentListBean() {
        }

        private CommentListBean(Builder builder) {
            this.comments = builder.comments;
            this.createTime = builder.createTime;
            this.messageId = builder.messageId;
            this.messageStatus = builder.messageStatus;
            this.messageType = builder.messageType;
            this.modifyTime = builder.modifyTime;
            this.momentsId = builder.momentsId;
            this.replayUser = builder.replayUser;
            this.replayUserNickName = builder.replayUserNickName;
            this.userName = builder.userName;
            this.userNickName = builder.userNickName;
            this.userPic = builder.userPic;
            this.sendStatus = builder.snedStatus;
            this.commentContentSpan = builder.commentContentSpan;
        }

        public static Builder newCommentListBean() {
            return new Builder();
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getMessageId() {
            return messageId;
        }

        public void setMessageId(String messageId) {
            this.messageId = messageId;
        }

        public int getMessageStatus() {
            return messageStatus;
        }

        public void setMessageStatus(int messageStatus) {
            this.messageStatus = messageStatus;
        }

        public int getMessageType() {
            return messageType;
        }

        public void setMessageType(int messageType) {
            this.messageType = messageType;
        }

        public long getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(long modifyTime) {
            this.modifyTime = modifyTime;
        }

        public String getMomentsId() {
            return momentsId;
        }

        public void setMomentsId(String momentsId) {
            this.momentsId = momentsId;
        }

        public String getReplayUser() {
            return replayUser;
        }

        public void setReplayUser(String replayUser) {
            this.replayUser = replayUser;
        }

        public String getReplayUserNickName() {
            return replayUserNickName;
        }

        public void setReplayUserNickName(String replayUserNickName) {
            this.replayUserNickName = replayUserNickName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserNickName() {
            return userNickName;
        }

        public void setUserNickName(String userNickName) {
            this.userNickName = userNickName;
        }

        public String getUserPic() {
            return userPic;
        }

        public void setUserPic(String userPic) {
            this.userPic = userPic;
        }

        public int getSendStatus() {
            return sendStatus;
        }

        public void setSendStatus(int sendStatus) {
            this.sendStatus = sendStatus;
        }

        /**
         * 富文本内容
         */
        private SpannableStringBuilder commentContentSpan;

        public SpannableStringBuilder getCommentContentSpan() {
            return commentContentSpan;
        }

//        public void buildCommentContentSpan(Context context) {
////            if (commentType == Constants.CommentType.COMMENT_TYPE_SINGLE) {
////                commentContentSpan = SpanUtils.makeSingleCommentSpan(context, childUserName, commentContent);
////            } else {
////                commentContentSpan = SpanUtils.makeReplyCommentSpan(context, parentUserName, childUserName, commentContent);
////            }
//
//            if (null != replayUserNickName && !replayUserNickName.equals(userNickName) && !TextUtils.isEmpty(replayUserNickName)){
//                commentContentSpan = SpanUtils.makeReplyCommentSpan(context, userNickName, replayUserNickName, comments);
//            }else {
//                commentContentSpan = SpanUtils.makeSingleCommentSpan(context, userNickName, comments);
//            }
//        }

        public static final class Builder {
            private String comments;
            private long createTime;
            private String messageId;
            private int messageStatus;
            private int messageType;
            private long modifyTime;
            private String momentsId;
            private String replayUser;
            private String replayUserNickName;
            private String userName;
            private String userNickName;
            private String userPic;
            private int snedStatus;
            private SpannableStringBuilder commentContentSpan;

            private Builder() {
            }

            public CommentListBean build() {
                return new CommentListBean(this);
            }

            public Builder comments(String comments) {
                this.comments = comments;
                return this;
            }

            public Builder createTime(long createTime) {
                this.createTime = createTime;
                return this;
            }

            public Builder messageId(String messageId) {
                this.messageId = messageId;
                return this;
            }

            public Builder messageStatus(int messageStatus) {
                this.messageStatus = messageStatus;
                return this;
            }

            public Builder messageType(int messageType) {
                this.messageType = messageType;
                return this;
            }

            public Builder modifyTime(long modifyTime) {
                this.modifyTime = modifyTime;
                return this;
            }

            public Builder momentsId(String momentsId) {
                this.momentsId = momentsId;
                return this;
            }

            public Builder replayUser(String replayUser) {
                this.replayUser = replayUser;
                return this;
            }

            public Builder replayUserNickName(String replayUserNickName) {
                this.replayUserNickName = replayUserNickName;
                return this;
            }

            public Builder userName(String userName) {
                this.userName = userName;
                return this;
            }

            public Builder userNickName(String userNickName) {
                this.userNickName = userNickName;
                return this;
            }

            public Builder userPic(String userPic) {
                this.userPic = userPic;
                return this;
            }

            public Builder sendStatus(int sendStatus) {
                this.snedStatus = sendStatus;
                return this;
            }

            public Builder commentContentSpan(SpannableStringBuilder commentContentSpan) {
                this.commentContentSpan = commentContentSpan;
                return this;
            }
        }
    }

    public static class PraiseListBean implements Serializable{
        /**
         * comments :
         * createTime : 0
         * messageId : 0
         * messageStatus : 0
         * messageType : 0
         * modifyTime : 0
         * momentsId : 0
         * replayUser :
         * replayUserNickName :
         * userName :
         * userNickName :
         * userPic :
         */

        private String comments;
        private long createTime;
        private String messageId;
        private int messageStatus;
        private int messageType;
        private long modifyTime;
        private String momentsId;
        private String replayUser;
        private String replayUserNickName;
        private String userName;
        private String userNickName;
        private String userPic;
        /**
         * 好友头像更新时间
         */
        private String changePicTime;

        public String getChangePicTime() {
            return changePicTime;
        }

        public void setChangePicTime(String changePicTime) {
            this.changePicTime = changePicTime;
        }

        public PraiseListBean() {
        }

        private PraiseListBean(Builder builder) {
            this.comments = builder.comments;
            this.createTime = builder.createTime;
            this.messageId = builder.messageId;
            this.messageStatus = builder.messageStatus;
            this.messageType = builder.messageType;
            this.modifyTime = builder.modifyTime;
            this.momentsId = builder.momentsId;
            this.replayUser = builder.replayUser;
            this.replayUserNickName = builder.replayUserNickName;
            this.userName = builder.userName;
            this.userNickName = builder.userNickName;
            this.userPic = builder.userPic;
        }

        public static Builder newPraiseListBean() {
            return new Builder();
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getMessageId() {
            return messageId;
        }

        public void setMessageId(String messageId) {
            this.messageId = messageId;
        }

        public int getMessageStatus() {
            return messageStatus;
        }

        public void setMessageStatus(int messageStatus) {
            this.messageStatus = messageStatus;
        }

        public int getMessageType() {
            return messageType;
        }

        public void setMessageType(int messageType) {
            this.messageType = messageType;
        }

        public long getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(long modifyTime) {
            this.modifyTime = modifyTime;
        }

        public String getMomentsId() {
            return momentsId;
        }

        public void setMomentsId(String momentsId) {
            this.momentsId = momentsId;
        }

        public String getReplayUser() {
            return replayUser;
        }

        public void setReplayUser(String replayUser) {
            this.replayUser = replayUser;
        }

        public String getReplayUserNickName() {
            return replayUserNickName;
        }

        public void setReplayUserNickName(String replayUserNickName) {
            this.replayUserNickName = replayUserNickName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserNickName() {
            if (null == userNickName){
                return "null";
            }
            return userNickName;
        }

        public void setUserNickName(String userNickName) {
            this.userNickName = userNickName;
        }

        public String getUserPic() {
            return userPic;
        }

        public void setUserPic(String userPic) {
            this.userPic = userPic;
        }


        public static final class Builder {
            private String comments;
            private long createTime;
            private String messageId;
            private int messageStatus;
            private int messageType;
            private long modifyTime;
            private String momentsId;
            private String replayUser;
            private String replayUserNickName;
            private String userName;
            private String userNickName;
            private String userPic;

            private Builder() {
            }

            public PraiseListBean build() {
                return new PraiseListBean(this);
            }

            public Builder comments(String comments) {
                this.comments = comments;
                return this;
            }

            public Builder createTime(long createTime) {
                this.createTime = createTime;
                return this;
            }

            public Builder messageId(String messageId) {
                this.messageId = messageId;
                return this;
            }

            public Builder messageStatus(int messageStatus) {
                this.messageStatus = messageStatus;
                return this;
            }

            public Builder messageType(int messageType) {
                this.messageType = messageType;
                return this;
            }

            public Builder modifyTime(long modifyTime) {
                this.modifyTime = modifyTime;
                return this;
            }

            public Builder momentsId(String momentsId) {
                this.momentsId = momentsId;
                return this;
            }

            public Builder replayUser(String replayUser) {
                this.replayUser = replayUser;
                return this;
            }

            public Builder replayUserNickName(String replayUserNickName) {
                this.replayUserNickName = replayUserNickName;
                return this;
            }

            public Builder userName(String userName) {
                this.userName = userName;
                return this;
            }

            public Builder userNickName(String userNickName) {
                this.userNickName = userNickName;
                return this;
            }

            public Builder userPic(String userPic) {
                this.userPic = userPic;
                return this;
            }
        }
    }

    public static class FilePropertiesDetail implements Serializable{

        /**
         * duration : 0
         * filename : IMG_1589427709915.png
         * filepic : 59a0f991d7e64fe191f1fc7a107baaff
         * firstpic :
         * h : 640
         * size : 717344
         * w : 1280
         */

        private String duration;
        private String filename;
        private String filepic;
        private String firstpic;
        private int h;
        private int size;
        private int w;

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getFilename() {
            if (TextUtils.isEmpty(filename)) {
                if (TextUtils.isEmpty(firstpic)) {
                    return filepic + ".jpg";
                } else {
                    return filepic + ".mp4";
                }
            }
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getFilepic() {
            return filepic;
        }

        public void setFilepic(String filepic) {
            this.filepic = filepic;
        }

        public String getFirstpic() {
            return firstpic;
        }

        public void setFirstpic(String firstpic) {
            this.firstpic = firstpic;
        }

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }
    }

    public static final class Builder {
        private String content;
        private long createTime;
        private String fileProperties;
        private int forbidCommentPraise;
        private long modifyTime;
        private String momentsId;
        private int momentsStatus;
        private int momentsType;
        private int openCommentPraise;
        private int sharingScope;
        private String userName;
        private String userNickName;
        private String userPic;
        private String visibleUserIds;
        private String position;
        private String lng;
        private String lat;
        private String remindPeopleString;
        private List<CommentListBean> commentList;
        private List<PraiseListBean> praiseList;
        private boolean isExpanded;
        private SpannableStringBuilder contentSpan;
        private boolean isShowCheckAll;
        private SpannableStringBuilder praiseSpan;
        private String ownerJid;
        private String sendStatus;
        private String remindUserIds;
        private String remindUserShowNames;
        private int pageLayoutType;
        private String avatarSign;

        private Builder() {
        }

        public Builder pageLayoutType(int pageLayoutType) {
            this.pageLayoutType = pageLayoutType;
            return this;
        }

        public MomentsDetailBean build() {
            return new MomentsDetailBean(this);
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder sendStatus(String sendStatus) {
            this.sendStatus = sendStatus;
            return this;
        }

        public Builder ownerJid(String ownerJid) {
            this.ownerJid = ownerJid;
            return this;
        }


        public Builder remindUserIds(String remindUserIds) {
            this.remindUserIds = remindUserIds;
            return this;
        }

        public Builder remindUserShowNames(String remindUserShowNames) {
            this.remindUserShowNames = remindUserShowNames;
            return this;
        }

        public Builder createTime(long createTime) {
            this.createTime = createTime;
            return this;
        }

        public Builder fileProperties(String fileProperties) {
            this.fileProperties = fileProperties;
            return this;
        }

        public Builder forbidCommentPraise(int forbidCommentPraise) {
            this.forbidCommentPraise = forbidCommentPraise;
            return this;
        }

        public Builder modifyTime(long modifyTime) {
            this.modifyTime = modifyTime;
            return this;
        }

        public Builder momentsId(String momentsId) {
            this.momentsId = momentsId;
            return this;
        }

        public Builder momentsStatus(int momentsStatus) {
            this.momentsStatus = momentsStatus;
            return this;
        }

        public Builder momentsType(int momentsType) {
            this.momentsType = momentsType;
            return this;
        }

        public Builder openCommentPraise(int openCommentPraise) {
            this.openCommentPraise = openCommentPraise;
            return this;
        }

        public Builder sharingScope(int sharingScope) {
            this.sharingScope = sharingScope;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder userNickName(String userNickName) {
            this.userNickName = userNickName;
            return this;
        }

        public Builder userPic(String userPic) {
            this.userPic = userPic;
            return this;
        }

        public Builder visibleUserIds(String visibleUserIds) {
            this.visibleUserIds = visibleUserIds;
            return this;
        }

        public Builder position(String position) {
            this.position = position;
            return this;
        }

        public Builder lng(String lng) {
            this.lng = lng;
            return this;
        }

        public Builder lat(String lat) {
            this.lat = lat;
            return this;
        }

        public Builder remindPeopleString(String remindPeopleString) {
            this.remindPeopleString = remindPeopleString;
            return this;
        }

        public Builder commentList(List<CommentListBean> commentList) {
            this.commentList = commentList;
            return this;
        }

        public Builder praiseList(List<PraiseListBean> praiseList) {
            this.praiseList = praiseList;
            return this;
        }

        public Builder isExpanded(boolean isExpanded) {
            this.isExpanded = isExpanded;
            return this;
        }

        public Builder contentSpan(SpannableStringBuilder contentSpan) {
            this.contentSpan = contentSpan;
            return this;
        }

        public Builder isShowCheckAll(boolean isShowCheckAll) {
            this.isShowCheckAll = isShowCheckAll;
            return this;
        }

        public Builder praiseSpan(SpannableStringBuilder praiseSpan) {
            this.praiseSpan = praiseSpan;
            return this;
        }

        public Builder avatarSign(String avatarSign) {
            this.avatarSign = avatarSign;
            return this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MomentsDetailBean that = (MomentsDetailBean) o;
        return momentsId.equals(that.momentsId);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(momentsId);
    }
}
