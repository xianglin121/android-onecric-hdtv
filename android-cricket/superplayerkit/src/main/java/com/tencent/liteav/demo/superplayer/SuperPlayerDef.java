package com.tencent.liteav.demo.superplayer;

public class SuperPlayerDef {

    public enum PlayerMode {
        WINDOW,     // 窗口模式
        FULLSCREEN, // 全屏模式
        FLOAT       // 悬浮窗模式
    }

    public enum PlayerState {
        PLAYING,    // 播放中
        PAUSE,      // 暂停中
        LOADING,    // 缓冲中
        END,         // 结束播放
        NO_NETWORK,         // 没网
        FIRST_LOADING_END         // 首次加载完成，结束loading
    }

    public enum PlayerType {
        VOD,        // 点播
        LIVE,       // 直播
        LIVE_SHIFT  // 直播会看
    }

    public enum Orientation {
        LANDSCAPE,  // 横屏
        PORTRAIT    // 竖屏
    }
}
