package zone.com.zrefreshlayout;

import android.view.View;

/**
 * Created by fuzhipeng on 2017/1/16.
 */

public interface IHeaderView {


    /**
     * 获取头部布局
     *
     * @param zRefreshLayout
     * @return
     */
    View getView(ZRefreshLayout zRefreshLayout);

    /**
     * 下拉准备刷新动作
     *
     * @param fraction   当前下拉高度与头部高度的比  超过头部动画基本保持不变
     * @param headHeight
     */
    void onPullingDown(float fraction, float headHeight);

    /**
     * 可刷新与不可刷新 状态切换监听
     *
     * @param refreshAble
     */
    void refreshAble(boolean refreshAble);

    /**
     * 回弹动画 监听
     *
     * @param animateBack  回弹类型
     * @param fraction
     * @param headHeight
     * @param isPinContent
     */
    void animateBack(AnimateBack animateBack, float fraction, float headHeight, boolean isPinContent);

    /**
     * 拦截滚动
     * 想让其滚动可使用AUtils.smoothScrollTo_NotIntercept(iScroll,0);
     * 参考：demo里的 CircleRefresh
     *
     * @param animateBack
     * @param iScroll
     * @return
     */
    boolean interceptAnimateBack(AnimateBack animateBack, ZRefreshLayout.IScroll iScroll);

    /**
     * 刷新进行时
     *
     * @param headHeight
     * @param isAutoRefresh
     */
    void onRefreshing(float headHeight, boolean isAutoRefresh);

    /**
     * 头部Rest前一刻调用此 用来重置状态
     */
    void onComplete();

    /**
     * 全局更换头的配置
     * 主要是为了复制头部对象，复制想要复制的属性
     * 注意:返回null时候，默认就是新浪头了
     */
    IHeaderView clone_();

}
