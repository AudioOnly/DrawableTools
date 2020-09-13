package com.yrn.drawableemple.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yrn.drawableemple.R;
import com.yrn.drawableemple.bean.CommentModel;
import com.yrn.drawableemple.bean.MomentMsgBean;
import com.yrn.drawableemple.util.TimeUtils;
import com.yrn.drawableemple.view.CommentTextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Cod
 * <p>
 * Created by Xinhoo on 2020/5/19
 * Describe: 朋友圈--新消息列表-适配器
 */
public class CircleOfFriendsMsgAdapter extends RecyclerView.Adapter<CircleOfFriendsMsgAdapter.ViewHolder> {
    private Context mContext;
    private List<MomentMsgBean.ListBean> mData = new ArrayList<>();
    //评论的点击事件
    private final int TYPE_HEADER = 0;
    private final int TYPE_NORMAL = 1;
    private final int TYPE_FOOTER = 2;
    private ItemCircleOfFriendsMsgOnClickListener itemOnClickListener;
    private Gson gson = new GsonBuilder().create();

    //加载更多
    private FooterShowListener footerShowListener;


    //HeaderView
    private View mHeaderView;
    private View mFooterView;

    public View getHeaderView() {
        return mHeaderView;
    }

    public void setHeaderView(View mHeaderView) {
        this.mHeaderView = mHeaderView;
        notifyItemInserted(0);
    }

    public void removeHeaderView() {
        this.mHeaderView = null;
        notifyDataSetChanged();
    }

    public View getFooterView() {
        return mFooterView;
    }

    public void setFooterView(View mFooterView) {
        this.mFooterView = mFooterView;
        notifyItemInserted(getItemCount() - 1);
    }

    public void setItemOnClickListener(ItemCircleOfFriendsMsgOnClickListener itemOnClickListener) {
        this.itemOnClickListener = itemOnClickListener;
    }

    public void setFooterShowListener(FooterShowListener footerShowListener) {
        this.footerShowListener = footerShowListener;
    }

    @Override
    public int getItemViewType(int position) {
        if (mHeaderView == null && mFooterView == null) {
            return TYPE_NORMAL;
        }
        if (position == 0) {
            //第一个item应该加载Header
            return mHeaderView == null ? TYPE_NORMAL : TYPE_HEADER;
        }
        if (position == getItemCount() - 1) {
            //最后一个,应该加载Footer
            return mFooterView == null ? TYPE_NORMAL : TYPE_FOOTER;
        }
        return TYPE_NORMAL;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivHeader;
        TextView tvFriendName;
        ImageView ivLikeTag;
        CommentTextView ctvComment;
        TextView tvRemindMeTag;
        TextView tvTime;
        TextView tvDel;
        RelativeLayout rlMultiMedia;
        ImageView ivMultiMedia;
        ImageView ivMultiMediaType;
        TextView etvCommentCon;

        ViewHolder(View view) {
            super(view);
            if (view == mHeaderView) {
                return;
            }
            if (view == mFooterView) {
                return;
            }
            ivHeader = (ImageView) view.findViewById(R.id.iv_header);
            tvFriendName = (TextView) view.findViewById(R.id.friend_name);
            etvCommentCon = (TextView) view.findViewById(R.id.tv_comment_content);
            tvRemindMeTag = (TextView)view.findViewById(R.id.tv_moments_msg_remind_me);
            ivLikeTag = view.findViewById(R.id.iv_only_like_tag);
            ctvComment = (CommentTextView) view.findViewById(R.id.tv_comment_reply);
            tvTime = (TextView) view.findViewById(R.id.time_text);
            tvDel = (TextView) view.findViewById(R.id.tv_del);
            rlMultiMedia = (RelativeLayout) view.findViewById(R.id.rl_multi_media);
            ivMultiMedia = (ImageView) view.findViewById(R.id.iv_multi_media);
            ivMultiMediaType = (ImageView) view.findViewById(R.id.iv_multi_media_type);
        }
    }



    public CircleOfFriendsMsgAdapter() {
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (mContext == null) {
            mContext = viewGroup.getContext();
        }
        //HeaderView;
        if (mHeaderView != null && viewType == TYPE_HEADER) {
            return new ViewHolder(mHeaderView);
        }
        if (mFooterView != null && viewType == TYPE_FOOTER) {
            return new ViewHolder(mFooterView);
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_circle_of_friends_msg, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_NORMAL) {
            MomentMsgBean.ListBean momentMsgBean = mData.get(position);
            //好友头像
            holder.ivHeader.setImageResource(R.drawable.chat_head_friend);
            //好友名称
            holder.tvFriendName.setText(momentMsgBean.getSpreadUserNickName());
            //是否点赞
            if (1 == momentMsgBean.getMessageType()) {//点赞
                holder.ivLikeTag.setVisibility(View.VISIBLE);
                holder.ctvComment.setVisibility(View.GONE);
                holder.tvRemindMeTag.setVisibility(View.GONE);
            } else if (2==momentMsgBean.getMessageType()){//评论
                holder.ivLikeTag.setVisibility(View.GONE);
                holder.ctvComment.setVisibility(View.VISIBLE);
                holder.tvRemindMeTag.setVisibility(View.GONE);
                //消息内容
                CommentModel model = new CommentModel(momentMsgBean.getMomentsId()+"",momentMsgBean.getMessageId()+"");
                holder.ctvComment.setShowCommentName(false);
                if (2 != momentMsgBean.getMessageStatus()) {
                    //被回复者
                    if (!TextUtils.isEmpty(momentMsgBean.getSpreadReplayUserNickName())) {
                        model.setReplyUid("");
                        model.setReplyUName(momentMsgBean.getSpreadReplayUserNickName());
                    }
                    //回复者
                    model.setReviewUid(momentMsgBean.getSpreadUserName());
                    model.setReviewUName(momentMsgBean.getSpreadUserNickName());
                    //回复内容
                    model.setReviewContent(TextUtils.isEmpty(momentMsgBean.getComments()) ? "" : momentMsgBean.getComments());
                } else {
                    //评论已经删除
                    model.setCommentStatus(2);
                }
                holder.ctvComment.setReply(model);

            } else if (3 == momentMsgBean.getMessageType()) {//提醒我
                holder.ivLikeTag.setVisibility(View.GONE);
                holder.ctvComment.setVisibility(View.GONE);
                holder.tvRemindMeTag.setVisibility(View.VISIBLE);
            }
            //时间
            holder.tvTime.setText(TimeUtils.daysFormatForMomentsMsg(mContext,momentMsgBean.getCreateTime()));
            //是否显示删除
            holder.tvDel.setVisibility(View.GONE);
            //多媒体类型
            if (1 == momentMsgBean.getMomentsType()) {//文字
                holder.rlMultiMedia.setVisibility(View.INVISIBLE);
                holder.etvCommentCon.setVisibility(View.VISIBLE);
                holder.etvCommentCon.setText(TextUtils.isEmpty(momentMsgBean.getContent()) ? "--" : momentMsgBean.getContent());
            } else {//多媒体
                holder.rlMultiMedia.setVisibility(View.VISIBLE);
                holder.etvCommentCon.setVisibility(View.GONE);
                holder.ivMultiMediaType.setVisibility(3 == momentMsgBean.getMomentsType() ? View.VISIBLE : View.GONE);
                holder.ivMultiMedia.setImageResource(R.drawable.chat_img_default);
                //解析多媒体资源
                if (!TextUtils.isEmpty(momentMsgBean.getFileProperties())) {
                    holder.ivMultiMedia.setImageResource(R.drawable.timg02);
//                    MomentsDetailBean.FilePropertiesDetail filePropertiesDetail = gson.fromJson(momentMsgBean.getFileProperties(), MomentsDetailBean.FilePropertiesDetail.class);
//                    if (filePropertiesDetail != null && (!TextUtils.isEmpty(filePropertiesDetail.getFilepic()) || !TextUtils.isEmpty(filePropertiesDetail.getFirstpic()))) {
//                        String imgUrl =(2 == momentMsgBean.getMomentsType() ? filePropertiesDetail.getFilepic() : filePropertiesDetail.getFirstpic());
//                        if (!imgUrl.contains("/")) {
//                            imgUrl = FileApiConstants.IMG_DOWNLOAD + imgUrl + CgiUrlPrefix.IMG_MOMENT_THUMBNAIL;
//                        }
//                        MultiMediaUtil.momentsMultiMediaLoad(mContext, imgUrl, holder.ivMultiMedia, -1, R.drawable.chat_img_default, null);
//                    }
                }
            }
            //点击事件
            if (itemOnClickListener != null) {
                holder.ctvComment.setOnClickListener(v -> itemOnClickListener.itemOnClick(v, position, momentMsgBean));
                holder.itemView.setOnClickListener(v -> itemOnClickListener.itemOnClick(v, position, momentMsgBean));
            }
        }
        if (getItemViewType(position) == TYPE_HEADER) {
            return;
        }
        if (getItemViewType(position) == TYPE_FOOTER) {
            if (footerShowListener != null) {
                footerShowListener.onFooterShow();
            }
            return;
        }
    }

    @Override
    public int getItemCount() {
        if (mHeaderView != null && mFooterView == null) {
            return mData.size() + 1;
        }
        if (mFooterView != null && mHeaderView == null) {
            return mData.size() + 1;
        }
        if (mFooterView != null && mHeaderView != null) {
            return mData.size() + 2;
        }
        return mData.size();
    }


    public List<MomentMsgBean.ListBean> getData() {
        return mData;
    }

    public interface ItemCircleOfFriendsMsgOnClickListener {
        void itemOnClick(View view, int position, Object data);
    }

    public interface FooterShowListener {
        void onFooterShow();
    }

}
