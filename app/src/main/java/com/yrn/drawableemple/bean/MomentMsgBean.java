package com.yrn.drawableemple.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Cod
 * <p>
 * Created by Xinhoo on 2020/5/23
 * Describe: 朋友圈新消息列表 实体类
 */
public class MomentMsgBean implements Serializable {

    /**
     * page : {"size":10,"page":1,"total":4,"pageCount":1,"first":1,"hasPre":false,"nextPage":1,"prePage":1,"hasNext":false}
     * list : [{"spreadUserPic":"208980ff6da8414ebc0dedde94a171b9","messageType":2,"comments":"发广告哈哈😋🤣🤣","spreadMessageId":1349967276933184,"momentsId":1349965355941920,"userName":"cod_60003138@cod.xinhoo.com","messageId":1349967276933152,"smStatus":1,"createTime":1590399360925,"modifyTime":1590399360925,"fileProperties":"{\"duration\":0,\"filename\":\"IMG_20190808_161639.png\",\"firstpic\":\"\",\"size\":191877,\"filepic\":\"6c5ff874331c46ad8dcfbba7faa138a4\",\"w\":2160,\"h\":1080}","read":0,"momentsType":2,"content":"好的基督教","spreadUserName":"cod_60003138@cod.xinhoo.com","spreadUserNickName":"姚锐凝"},{"spreadUserPic":"208980ff6da8414ebc0dedde94a171b9","messageType":2,"comments":"😍😂😄😂😄好超级超级","spreadMessageId":1349967222407232,"momentsId":1349965355941920,"userName":"cod_60003138@cod.xinhoo.com","messageId":1349967222407200,"smStatus":1,"createTime":1590399334306,"modifyTime":1590399334306,"fileProperties":"{\"duration\":0,\"filename\":\"IMG_20190808_161639.png\",\"firstpic\":\"\",\"size\":191877,\"filepic\":\"6c5ff874331c46ad8dcfbba7faa138a4\",\"w\":2160,\"h\":1080}","read":0,"momentsType":2,"content":"好的基督教","spreadUserName":"cod_60003138@cod.xinhoo.com","spreadUserNickName":"姚锐凝"},{"spreadUserPic":"208980ff6da8414ebc0dedde94a171b9","messageType":2,"comments":"坚持坚持看","spreadMessageId":1349967006400576,"momentsId":1349965355941920,"userName":"cod_60003138@cod.xinhoo.com","messageId":1349967006400544,"smStatus":1,"createTime":1590399231728,"modifyTime":1590399231728,"fileProperties":"{\"duration\":0,\"filename\":\"IMG_20190808_161639.png\",\"firstpic\":\"\",\"size\":191877,\"filepic\":\"6c5ff874331c46ad8dcfbba7faa138a4\",\"w\":2160,\"h\":1080}","read":0,"momentsType":2,"content":"好的基督教","spreadUserName":"cod_60003138@cod.xinhoo.com","spreadUserNickName":"姚锐凝"},{"spreadUserPic":"208980ff6da8414ebc0dedde94a171b9","messageType":1,"comments":null,"spreadMessageId":1349966993817664,"momentsId":1349965355941920,"userName":"cod_60003138@cod.xinhoo.com","messageId":1349966993817632,"smStatus":1,"createTime":1590399225708,"modifyTime":1590399225708,"fileProperties":"{\"duration\":0,\"filename\":\"IMG_20190808_161639.png\",\"firstpic\":\"\",\"size\":191877,\"filepic\":\"6c5ff874331c46ad8dcfbba7faa138a4\",\"w\":2160,\"h\":1080}","read":0,"momentsType":2,"content":"好的基督教","spreadUserName":"cod_60003138@cod.xinhoo.com","spreadUserNickName":"姚锐凝"}]
     */

    private PageBean page;
    private List<ListBean> list;

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class PageBean implements Serializable {
        /**
         * size : 10
         * page : 1
         * total : 4
         * pageCount : 1
         * first : 1
         * hasPre : false
         * nextPage : 1
         * prePage : 1
         * hasNext : false
         */

        private int size;
        private int page;
        private int total;
        private int pageCount;
        private int first;
        private boolean hasPre;
        private int nextPage;
        private int prePage;
        private boolean hasNext;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getFirst() {
            return first;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public boolean isHasPre() {
            return hasPre;
        }

        public void setHasPre(boolean hasPre) {
            this.hasPre = hasPre;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public int getPrePage() {
            return prePage;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public boolean isHasNext() {
            return hasNext;
        }

        public void setHasNext(boolean hasNext) {
            this.hasNext = hasNext;
        }
    }

    public static class ListBean implements Serializable {
        /**
         * spreadUserPic : 208980ff6da8414ebc0dedde94a171b9
         * messageType : 2
         * comments : 发广告哈哈😋🤣🤣
         * spreadMessageId : 1349967276933184
         * momentsId : 1349965355941920
         * userName : cod_60003138@cod.xinhoo.com
         * messageId : 1349967276933152
         * momentsStatus: 朋友圈状态1：正常2：删除
         * smStatus : 1
         * createTime : 1590399360925
         * modifyTime : 1590399360925
         * fileProperties : {"duration":0,"filename":"IMG_20190808_161639.png","firstpic":"","size":191877,"filepic":"6c5ff874331c46ad8dcfbba7faa138a4","w":2160,"h":1080}
         * read : 0
         * momentsType : 2
         * content : 好的基督教
         * spreadReplayUserNickName:评论（点赞）者回复的人昵称
         * spreadUserName : cod_60003138@cod.xinhoo.com
         * spreadUserNickName : 姚锐凝
         */

        private String spreadUserPic;
        //消息类型1：点赞 2：评论 3：艾特（@）
        private int messageType;
        //评论内容
        private String comments;
        private long spreadMessageId;
        //朋友圈id
        private long momentsId;
        //朋友圈状态1：正常2：删除
        private int momentsStatus;
        private String userName;
        private long messageId;
        //评论状态 评论(点赞)状态1：正常2：删除
        private int messageStatus;
        //消息通知状态1：正常 2：删除
        private int smStatus;
        private long createTime;
        private long modifyTime;
        private String fileProperties;
        //是否已读 0:未读 1:已读
        private int read;
        //朋友圈类型 1：文字 2：图片3：视频
        private int momentsType;
        //如果是文字类型。那么会有这条朋友圈的内容
        private String content;
        private String spreadReplayUserNickName;
        private String spreadUserName;
        private String spreadUserNickName;

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

        public String getSpreadUserPic() {
            return spreadUserPic;
        }

        public void setSpreadUserPic(String spreadUserPic) {
            this.spreadUserPic = spreadUserPic;
        }

        public int getMessageType() {
            return messageType;
        }

        public void setMessageType(int messageType) {
            this.messageType = messageType;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }

        public long getSpreadMessageId() {
            return spreadMessageId;
        }

        public void setSpreadMessageId(long spreadMessageId) {
            this.spreadMessageId = spreadMessageId;
        }

        public long getMomentsId() {
            return momentsId;
        }

        public void setMomentsId(long momentsId) {
            this.momentsId = momentsId;
        }

        public int getMomentsStatus() {
            return momentsStatus;
        }

        public void setMomentsStatus(int momentsStatus) {
            this.momentsStatus = momentsStatus;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public long getMessageId() {
            return messageId;
        }

        public void setMessageId(long messageId) {
            this.messageId = messageId;
        }

        public int getMessageStatus() {
            return messageStatus;
        }

        public void setMessageStatus(int messageStatus) {
            this.messageStatus = messageStatus;
        }

        public int getSmStatus() {
            return smStatus;
        }

        public void setSmStatus(int smStatus) {
            this.smStatus = smStatus;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public long getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(long modifyTime) {
            this.modifyTime = modifyTime;
        }

        public String getFileProperties() {
            return fileProperties;
        }

        public void setFileProperties(String fileProperties) {
            this.fileProperties = fileProperties;
        }

        public int getRead() {
            return read;
        }

        public void setRead(int read) {
            this.read = read;
        }

        public int getMomentsType() {
            return momentsType;
        }

        public void setMomentsType(int momentsType) {
            this.momentsType = momentsType;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getSpreadReplayUserNickName() {
            return spreadReplayUserNickName;
        }

        public void setSpreadReplayUserNickName(String spreadReplayUserNickName) {
            this.spreadReplayUserNickName = spreadReplayUserNickName;
        }

        public String getSpreadUserName() {
            return spreadUserName;
        }

        public void setSpreadUserName(String spreadUserName) {
            this.spreadUserName = spreadUserName;
        }

        public String getSpreadUserNickName() {
            return spreadUserNickName;
        }

        public void setSpreadUserNickName(String spreadUserNickName) {
            this.spreadUserNickName = spreadUserNickName;
        }
    }
}
