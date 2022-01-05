package cn.objectspace.webssh.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    SUCCESS(200, "成功"),
    LOGOUT(200, "成功登出"),
    BAD_REQUEST(400, "请求异常"),
    PARAM_NOT_MATCH(400, "参数不匹配"),
    PARAM_NOT_NULL(400, "参数不能为空"),
    UNAUTHORIZED(401, "没有访问权限"),
    ACCESS_DENIED(403, "权限不足"),
    USER_DISABLED(403, "当前用户已被禁用，请联系管理员解锁"),
    NOT_FOUND(404, "请求资源不存在"),
    HTTP_BAD_METHOD(405, "请求方式错误"),
    ERROR(500, "操作异常"),

    TOKEN_EXPIRED(6001, "token已过期，请重新登录"),
    TOKEN_INVALID(6002, "无效token"),
    ROLE_DESCRIPTION_NOT_NULL(6002, "角色描述不能为空"),
    ROLE_NAME_NOT_NULL(6003, "角色名称不能为空"),
    ROLE_ID_NOT_NULL(6004, "角色ID不能为空"),
    ROLE_NULL(6005, "角色不存在"),
    USER_NULL(6006, "用户不存在"),
    PHONE_NUMBER_FORMAT_ERROR(6007, "手机号格式不正确"),
    EMAIL_NUMBER_FORMAT_ERROR(6008, "邮箱格式不正确"),
    SUPER_ADMIN_ACCESS_DENIED(6009, "超级管理员的权限不能改变"),
    OLD_PASSWORD_IS_ERROR(6010, "旧密不正确"),
    OLD_PASSWORD_NOT_NULL(6011, "请输入旧密码"),
    USERNAME_IS_OCCUPY(6012, "用户名已被占用"),
    TEMPLATE_IS_EXIST(6013, "同名模板已存在"),
    PERIOD_NOT_MATCH(6014, "周期不匹配"),
    PERIOD_SUMMARY_ERROR(6015, "周期汇总失败"),
    TEMPLATE_NOT_NULL(6016, "模板内容不能为空"),
    SINGER_NOT_NULL(6017, "填报人不能为空"),
    LOGIN_SERVER_NOT_AVAILABLE(6018, "认证平台不可用"),
    ;


    private final int code;
    public final String message;

}
