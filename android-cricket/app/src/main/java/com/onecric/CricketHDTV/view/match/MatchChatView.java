package com.onecric.CricketHDTV.view.match;

import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.view.BaseView;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageInfo;

public interface MatchChatView extends BaseView<JsonBean> {
    void onGroupForceExit(String groupId);

    void exitGroupChat(String chatId);

    void onApplied(int unHandledSize);

    void handleRevoke(String msgId);

    void onRecvNewMessage(MessageInfo messageInfo);

    void onGroupNameChanged(String groupId, String newName);
}
