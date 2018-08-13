package com.artmall.response;

/**标识常量
 * @author
 * @create 2018-08-06 15:05
 **/

public class Const {
    public static final String CURRENT_USER = "currentUser";

    public enum LoginType {

        STUDENT("Student"),BUSINESS("Business"),ADMIN("Admin");

        private String type;

        private LoginType(String type) {
            this.type = type;
        }

        @Override
        public String toString(){
            return this.type.toString();
        }
    }

    public interface is_fistlogin{
        int STUDENT_FIRST = 0;//未登入的
        int STUDENT_NOTFIRST = 1;//已登入过了
    }

    public enum OrderStatusEnum{
        CANCELED(0,"已取消"),
        NO_PAY(10,"未支付"),;

        OrderStatusEnum(int code, String value) {
            this.code = code;
            this.value = value;

        }
        private String value;
        private int code;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
        public static OrderStatusEnum codeOf(int code){
            for(OrderStatusEnum orderStatusEnum : values()){
                if(orderStatusEnum.getCode() == code){
                    return orderStatusEnum;
                }
            }
            throw new RuntimeException("没有找到对应的枚举");
        }

    }
    //是否通过登录
    public static boolean isPass=false;
}
