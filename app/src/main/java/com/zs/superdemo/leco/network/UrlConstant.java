package com.zs.superdemo.leco.network;

/**
 * 接口地址
 *
 * @author Administrator
 */
public class UrlConstant {

    /**
     * 服务器地址
     */
//    public static String SERVER_BASE_URL = "http://192.168.10.23";//本地接口
//    public static String SERVER_IMAGE_URL = "http://192.168.10.23:8080";//本地接口

    public static String SERVER_BASE_URL = "http://114.115.141.25:80/hy";//服务器接口
    public static String SERVER_IMAGE_URL = "http://114.115.141.25:80";//服务器接口

//     public static String SERVER_BASE_URL = "http://houtai.haiyouwang.com:80/hy";//服务器接口
//    public static String SERVER_IMAGE_URL = "http://houtai.haiyouwang.com:80";//服务器接口

    //----------------------------订单退货退款接口---------------------------------
    /**
     * 退货退款申请
     */
    public static final String ReturnsAndRefundsApply = "/mobile/api/user/access/ReturnsAndRefundsApply.htm";
    /**
     * 取消退货申请
     */
    public static final String callOffReturnsAndRefundsApply = "/mobile/api/user/access/callOffReturnsAndRefundsApply.htm";
    /**
     * 退货原因
     */
    public static final String findBackCause = "/mobile/api/user/access/findBackCause.htm";
    /**
     * 退货退款申请添加物流信息
     */
    public static final String returnsAndRefundsApplyAddLogisticsInformation = "/mobile/api/user/access/returnsAndRefundsApplyAddLogisticsInformation.htm";
    /**
     * 用户退货单详情
     */
    public static final String userBackgoodsDetails = "/mobile/api/user/access/userBackgoodsDetails.htm";

    //----------------------------百家联盟商品分类品牌接口---------------------------------
    /**
     * 分页查询分类下的品牌 √
     */
    public static final String queryGoodsCategoryAndBrand = "/mobile/api/user/access/queryGoodsCategoryAndBrand.htm";

    //----------------------------订单接口---------------------------------
    /**
     * 取消我的订单/确认收货/确认收货
     */
    public static final String abrogateUserOrder = "/mobile/api/user/access/abrogateUserOrder.htm";
    /**
     * 评论订单商品
     */
    public static final String addOrderGoodsComment = "/mobile/api/user/access/addOrderGoodsComment.htm";
    /**
     * 支付接口
     */
    public static final String alipayOrder = "/mobile/api/user/access/alipayOrder.htm";
    /**
     * 查询订单详情
     */
    public static final String findOrderDetails = "/mobile/api/user/access/findOrderDetails.htm";
    /**
     * 订单商品可用优惠券
     */
    public static final String findUserCouponByGoods = "/mobile/api/user/access/findUserCouponByGoods.htm";
    /**
     * 查询我的全部/待支付/待发货/待收货/退款订单
     */
    public static final String findUserOrderByCondition = "/mobile/api/user/access/findUserOrderByCondition.htm";
    /**
     * 查询我的待评价订单
     */
    public static final String findUserOrderByIsAppraise = "/mobile/api/user/access/findUserOrderByIsAppraise.htm";
    /**
     * 查询我的退款退货申请列表
     */
    public static final String findUserSalesReturnOrder = "/mobile/api/user/access/findUserSalesReturnOrder.htm";
    /**
     * 全额退款接口
     */
    public static final String fullRefundOrder = "/mobile/api/user/access/fullRefundOrder.htm";
    /**
     * 创建/更改订单
     */
    public static final String creatOrUpdateOrder = "/mobile/api/user/open/creatOrUpdateOrder.htm";

    //----------------------------购物车接口---------------------------------
    /**
     * 添加商品到购物车
     * 购物车数量修改也是调这个接口
     */
    public static final String addGoodsToShoppingCar = "/mobile/api/user/access/addGoodsToShoppingCar.htm";

    /**
     * 删除购物商品
     */
    public static final String deleteShoppingCarGoods = "/mobile/api/user/access/deleteShoppingCarGoods.htm";
    /**
     * 分页查询用户购物车
     */
    public static final String findShoppingCarGoodsPage = "/mobile/api/user/access/findShoppingCarGoodsPage.htm";


    //----------------------------家装接口---------------------------------
    /**
     * 查询家装详情 √
     */
    public static final String queryHomeDecorationDetails = "/mobile/api/user/access/queryHomeDecorationDetails.htm";
    /**
     * 查询家装列表 √
     */
    public static final String queryHomeDecorationPage = "/mobile/api/user/access/queryHomeDecorationPage.htm";
    //----------------------------动态接口---------------------------------
    /**
     * 发布动态
     */
    public static final String createDynamicForApp = "/mobile/api/user/access/createDynamicForApp.htm";
    /**
     * 收藏动态
     */
    public static final String dynamicCollectForApp = "/mobile/api/user/access/dynamicCollectForApp.htm";
    /**
     * 评论动态
     */
    public static final String dynamicCommentForApp = "/mobile/api/user/access/dynamicCommentForApp.htm";
    /**
     * 点赞动态
     */
    public static final String dynamicLikeForApp = "/mobile/api/user/access/dynamicLikeForApp.htm";
    /**
     * 取消点赞
     */
    public static final String dynamicCancelLikeForApp = "/mobile/api/user/access/dynamicCancelLikeForApp.htm";
    /**
     * 分页查询收藏动态
     */
    public static final String queryDynamicCollectForApp = "/mobile/api/user/access/queryDynamicCollectForApp.htm";
    /**
     * 分页查询动态
     */
    public static final String queryDynamicForApp = "/mobile/api/user/access/queryDynamicForApp.htm";
    /**
     * 分页查询点赞动态
     */
    public static final String queryDynamicLikeForApp = "/mobile/api/user/access/queryDynamicLikeForApp.htm";
    /**
     * 分页查询动态
     */
    public static final String queryDynamicListForApp = "/mobile/api/user/access/queryDynamicListForApp.htm";
    /**
     * 查询评论
     */
    public static final String querydynamicCommentpageForApp = "/mobile/api/user/access/querydynamicCommentpageForApp.htm";

    //----------------------------房屋买卖和海优社区接口---------------------------------
    /**
     * 查询新房分类
     */
    public static final String queryNewHouseCategoryforApp = "/mobile/api/user/open/queryNewHouseCategoryforApp.htm";
    /**
     * 查询二手房分类
     */
    public static final String querySecondHandCategoryforApp = "/mobile/api/user/open/querySecondHandCategoryforApp.htm";
    /**
     * 查询房屋买卖楼盘详情
     */
    public static final String queryfwagenthomedetailforApp = "/mobile/api/user/open/queryfwagenthomedetailforApp.htm";
    /**
     * 分页查询房屋买卖新房列表
     */
    public static final String queryfwagenthomepageforApp = "/mobile/api/user/open/queryfwagenthomepageforApp.htm";
    /**
     * 查询房屋买卖户型详情
     */
    public static final String queryfwhomestyledetailforApp = "/mobile/api/user/open/queryfwhomestyledetailforApp.htm";
    /**
     * 分页查询房屋买卖全部户型
     */
    public static final String queryfwhomestylepageforApp = "/mobile/api/user/open/queryfwhomestylepageforApp.htm";
    /**
     * 查询房屋买卖二手房详情
     */
    public static final String queryfwsecondhandhomedetailforApp = "/mobile/api/user/open/queryfwsecondhandhomedetailforApp.htm";
    /**
     * 分页查询房屋买卖二手房列表
     */
    public static final String queryfwsecondhandhomepageforApp = "/mobile/api/user/open/queryfwsecondhandhomepageforApp.htm";
    /**
     * 分页查询海优社区地产商列表
     */
    public static final String queryhyagentpageforApp = "/mobile/api/user/open/queryhyagentpageforApp.htm";
    /**
     * 分页查询海优社区小区
     */
    public static final String queryhyagenthomepageforApp = "/mobile/api/user/open/queryhyagenthomepageforApp.htm";
    /**
     * 查询海优社区户型案例详细
     */
    public static final String queryhyhomedecDetailforApp = "/mobile/api/user/open/queryhyhomedecDetailforApp.htm";
    /**
     * 分页查询海优社区户型案例列表
     */
    public static final String queryhyhomedecpageforApp = "/mobile/api/user/open/queryhyhomedecpageforApp.htm";
    /**
     * 查询海优社区户型
     */
    public static final String queryhyhometypeforApp = "/mobile/api/user/open/queryhyhometypeforApp.htm";
    //----------------------------广告接口---------------------------------
    /**
     * 查询所有广告
     */
    public static final String queryAdforApp = "/mobile/api/user/open/queryAdforApp.htm";

    //----------------------------海优生活及发现文章接口---------------------------------
    /**
     * 查询发现文章分类
     */
    public static final String queryArticleCategoryforApp = "/mobile/api/user/open/queryArticleCategoryforApp.htm";
    /**
     * 分页查询发现文章列表
     */
    public static final String queryArticlePageforApp = "/mobile/api/user/open/queryArticlePageforApp.htm";
    /**
     * 分页查询海优生活列表
     */
    public static final String queryhaiyouLifeArticlePageforApp = "/mobile/api/user/open/queryhaiyouLifeArticlePageforApp.htm";
    /**
     * 查询海优生活分类
     */
    public static final String queryhaiyouLifeCategoryforApp = "/mobile/api/user/open/queryhaiyouLifeCategoryforApp.htm";
    /**
     * 查询海优生活/发现文章详细
     */
    public static final String queryhaiyouLifeDetailforApp = "/mobile/api/user/open/queryhaiyouLifeDetailforApp.htm";
    /**
     * 查询海优生活标签(暂时没用)
     */
    public static final String queryhaiyouLifeLabelforApp = "/mobile/api/user/open/queryhaiyouLifeLabelforApp.htm";

    //---------------------------今日推荐接口---------------------------------
    /**
     * 查询今日推荐
     */
    public static final String queryRecommendsforApp = "/mobile/api/user/open/queryRecommendsforApp.htm";

    //----------------------------提成接口---------------------------------
    /**
     * 按月查询提成明细
     */
    public static final String queryRebateDetail = "/mobile/api/user/access/queryRebateDetail.htm";
    /**
     * 查询提成
     */
    public static final String queryRebateList = "/mobile/api/user/access/queryRebateList.htm";
    /**
     * 提交反馈
     */
    public static final String submitFeedBackforApp = "/mobile/api/user/access/submitFeedBackforApp.htm";
    /**
     * 提交申请
     */
    public static final String submitRebateApplyforApp = "/mobile/api/user/access/submitRebateApplyforApp.htm";


    //----------------------------免费家装设计申请接口---------------------------------
    /**
     * 添加案例申请 √
     */
    public static final String addDesignApply = "/mobile/api/user/access/addDesignApply.htm";
    /**
     * 统计申请数量
     */
    public static final String queryDesignApplyAlreadyCount = "/mobile/api/user/access/queryDesignApplyAlreadyCount.htm";

    //----------------------------前台家装分类接口 ---------------------------------
    /**
     * 查询家装分类 √
     */
    public static final String queryHomeCategory = "/mobile/api/user/access/queryHomeCategory.htm";

    //----------------------------前台家装风格接口 ---------------------------------
    /**
     * 查询家装风格 √
     */
    public static final String queryHomeStyle = "/mobile/api/user/access/queryHomeStyle.htm";

    //----------------------------前台验证码接口 ---------------------------------
    /**
     * 根据手机号获得验证码
     * {0登录验证 ，1注册验证 √，2修改密码验证 √ }
     */
    public static final String sendVerifyCode = "/mobile/api/open/sendVerifyCode.htm";

    //----------------------------前台用户登录接口 ---------------------------------
    /**
     * 移动端登录 √
     */
    public static final String login = "/mobile/api/user/open/login.htm";
    /**
     * 上传client_id
     */
    public static final String geTuiClientId = "/mobile/api/user/access/geTuiClientId.htm";

    //----------------------------前台用户注册接口 ---------------------------------
    /**
     * 修改密码
     * 忘记密码传phone √ 修改密码传userID和token
     */
    public static final String changeUserPswd = "/mobile/api/user/open/changeUserPswd.htm";
    /**
     * 移动端注册 √
     */
    public static final String register = "/mobile/api/user/register.htm";

    //----------------------------前台用户收货地址接口 ---------------------------------
    /**
     * 添加收货地址
     */
    public static final String addAddress = "/mobile/api/user/access/addAddress.htm";
    /**
     * 删除收货地址
     */
    public static final String deleteAddress = "/mobile/api/user/access/deleteAddress.htm";
    /**
     * 根据id 查询收货地址详情
     */
    public static final String queryAddressDetailById = "/mobile/api/user/access/queryAddressDetailById.htm";
    /**
     * 根据用户Id查询收货地址列表
     */
    public static final String queryUserAddress = "/mobile/api/user/access/queryUserAddress.htm";
    /**
     * 编辑收货地址
     */
    public static final String updateAddressInfo = "/mobile/api/user/access/updateAddressInfo.htm";
    /**
     * 修改收货地址状态(设置为莫认收货地址)
     */
    public static final String updateAddressStatus = "/mobile/api/user/access/updateAddressStatus.htm";
    //----------------------------商品定制接口 ---------------------------------
    /**
     * 添加商品定制信息
     */
    public static final String addGoodsCustom = "/mobile/api/user/access/addGoodsCustom.htm";


    //----------------------------商品风格接口 ---------------------------------
    /**
     * 查询商品风格
     */
    public static final String queryGoodsStyle = "/mobile/api/user/access/queryGoodsStyle.htm";

    //----------------------------商品分类接口 ---------------------------------
    /**
     * 商品第一级分类 TGoodsCategory
     * token  client_type
     */
    public static final String queryGoodsFirstOrderCategory = "/mobile/api/user/access/queryGoodsFirstOrderCategory.htm";
    /**
     * 根据分类ID查询第二级分类
     * token client_type goodsCategoryId page pageSize
     */
    public static final String queryGoodsSecondOrderCategory = "/mobile/api/user/access/queryGoodsSecondOrderCategory.htm";
    /**
     * 根据风格ID查询第二级分类
     * token client_type styleId page pageSize
     */
    public static final String queryGoodsSecondOrderCategoryByStyleId = "/mobile/api/user/access/queryGoodsSecondOrderCategoryByStyleId.htm";

    //----------------------------商品接口 ---------------------------------
    /**
     * 商品添加收藏/转发/添加评论
     */
    public static final String addGoodsCollectOrCommentOrTranspond = "/mobile/api/user/access/addGoodsCollectOrCommentOrTranspond.htm";
    /**
     * 查看商品评论
     */
    public static final String queryGoodsCommentPage = "/mobile/api/user/access/queryGoodsCommentPage.htm";

    /**
     * 查询商品详情
     */
    public static final String queryGoodsDetailsByGoodsId = "/mobile/api/user/access/queryGoodsDetailsByGoodsId.htm";

    /**
     * 根据{分类ID}/{品牌 ID}/{风格 ID} 分页查询商品
     */
    public static final String queryGoodsPageByCategoryIdOrBrandId = "//mobile/api/user/access/queryGoodsPageByCategoryIdOrBrandId.htm";
    /**
     * 根据 {分类名} 查询商品 √ （家居）
     */
    public static final String queryGoodsPageByCondition = "/mobile/api/user/access/queryGoodsPageByCondition.htm";
    /**
     * 查询精选商品
     */
    public static final String queryIs_selectionGoodsPage = "/mobile/api/user/access/queryIs_selectionGoodsPage.htm";

    //----------------------------商品品牌接口 ---------------------------------
    /**
     * 分页查询所有品牌
     */
    public static final String queryGoodsAllBrandPage = "/mobile/api/user/access/queryGoodsAllBrandPage.htm";

    //----------------------------设计师接口 ---------------------------------
    /**
     * 根据设计师ID分页查询设计师作品 √
     */
    public static final String queryStylistArtPage = "/mobile/api/user/access/queryStylistArtPage.htm";

    /**
     * 设计师详情 √
     */
    public static final String queryStylistDetails = "/mobile/api/user/access/queryStylistDetails.htm";

    /**
     * 设计师列表 √
     */
    public static final String queryStylistPage = "/mobile/api/user/access/queryStylistPage.htm";

    /**
     * 查询设计师作品详情 √
     */
    public static final String queryStylistProduction = "/mobile/api/user/access/queryStylistProduction.htm";

    //----------------------------省市区接口  ---------------------------------

    /**
     * 按条件查询城市列表
     */
    public static final String getCityListByCondition_app = "/api/getCityListByCondition_app.htm";
    /**
     * 按条件查询地区信息
     */
    public static final String getDistrictListByCondition_app = "/api/getDistrictListByCondition_app.htm";
    /**
     * 按条件查询省份列表
     */
    public static final String getProvinceListByCondition_app = "/api/getProvinceListByCondition_app.htm";

    //----------------------------团购商品接口  ---------------------------------
    /**
     * 查询团购商品 √
     */
    public static final String queryGroupGoodsPage = "/mobile/api/user/access/queryGroupGoodsPage.htm";

    //----------------------------文章接口  ---------------------------------
    /**
     * 文章添加收藏/转发/添加评论
     */
    public static final String addCollectOrCommentOrTranspond = "/mobile/api/user/access/addCollectOrCommentOrTranspond.htm";
    /**
     * 查看文章评论
     */
    public static final String queryArticleCommentPage = "/mobile/api/user/access/queryArticleCommentPage.htm";
    //----------------------------限时活动接口   ---------------------------------
    /**
     * 分页查询限时优惠活动商品 √
     */
    public static final String queryActivtiyGoodsPage = "/mobile/api/user/access/queryActivtiyGoodsPage.htm";
    //----------------------------验证码效验接口   ---------------------------------
    /**
     * 移动端效验验证码
     */
    public static final String verificationCode = "/mobile/api/user/verificationCode.htm";
    //----------------------------用户中心   ---------------------------------
    /**
     * 成为销售
     */
    public static final String becomeSell = "/mobile/api/user/access/becomeSell.htm";
    /**
     * 个人中心足迹
     */
    public static final String browseHistory = "/mobile/api/user/access/browseHistory.htm";
    /**
     * 修改用户手机号
     */
    public static final String changeUserPhone = "/mobile/api/user/access/changeUserPhone.htm";
    /**
     * 个人中心管理收藏
     */
    public static final String deleteUserEnshrine = "/mobile/api/user/access/deleteUserEnshrine.htm";
    /**
     * 个人信息详情
     */
    public static final String findPersonalDetails = "/mobile/api/user/access/findPersonalDetails.htm";
    /**
     * 我的定制
     */
    public static final String myCustom = "/mobile/api/user/access/myCustom.htm";
    /**
     * 我的互动
     */
    public static final String myInteraction = "/mobile/api/user/access/myInteraction.htm";
    /**
     * 个人中心足迹管理
     */
    public static final String updateBrowseHistory = "/mobile/api/user/access/updateBrowseHistory.htm";
    /**
     * 修改个人信息
     */
    public static final String updatePersonalDetails = "/mobile/api/user/access/updatePersonalDetails.htm";
    /**
     * 用户优惠券
     */
    public static final String userAllCoupon = "/mobile/api/user/access/userAllCoupon.htm";
    /**
     * 个人中心基础信息
     */
    public static final String userCenterBasicInformation = "/mobile/api/user/access/userCenterBasicInformation.htm";
    /**
     * 个人中心收藏
     */
    public static final String userEnshrine = "/mobile/api/user/access/userEnshrine.htm";
    //----------------------------优惠卷   ---------------------------------
    /**
     * 查询所有优惠券
     */
    public static final String findAllCoupon = "/mobile/api/user/access/findAllCoupon.htm";
    /**
     * 用户领取优惠券
     */
    public static final String userGetCoupon = "/mobile/api/user/access/userGetCoupon.htm";
    /**
     * 装修报价
     */
    public static final String addDecorationQuote = "/mobile/api/user/access/addDecorationQuote.htm";
    /**
     * 精选分类 page pageSize
     */
    public static final String findChoicenessGoodsCategory = "/mobile/api/user/open/findChoicenessGoodsCategory.htm";
    //----------------------------系统消息   ---------------------------------
    /**
     * 分页查询系统消息
     */
    public static final String querySystemMessagePage = "/mobile/api/user/access/querySystemMessagePage.htm";
    //----------------------------微信登录   ---------------------------------
    /**
     * 移动端微信登录
     */
    public static final String wxlogin = "/mobile/api/user/open/wxlogin.htm";
    /**
     * 微信绑定
     */
    public static final String wxbind = "/mobile/api/user/wxbind.htm";
    /**
     * 微信注册
     */
    public static final String wxregister = "/mobile/api/user/wxregister.htm";
    /**
     * 物业
     */
    public static final String findResidentialPropertyAppApiPage = "/mobile/api/user/open/findResidentialPropertyAppApiPage.htm";

    /**
     * 传图片
     */
    public static final String signleImageUpload = "/signleImageUpload.htm";
    /**
     * 版本更新
     */
    public static final String getNewVersion = "/mobile/api/open/getNewVersion.htm";

}
