package com.brightkut.walley_v2.constant;

public class CommonConstant {
    // Command
    public static final String VIEW_WALLET = "ต้องการเรียกดูเงินในกระเป๋า";
    public static final String UPDATE_WALLET = "ต้องการเพิ่มลดข้อมูลรายการใช้จ่าย";
    public static final String SUMMARIZE_WALLET = "สรุปผลการเงิน";
    public static final String UPDATE_WALLET_BY_BILL = "ต้องการ Upload รูปภาพบิลค่าใช้จ่าย";
    public static final String MANAGE_CATEGORY ="ต้องการเพิ่ม , ลด, หรือ ดูหมวดหมู่ทั้งหมด";

    // Wallet
    public static final String CREATE_WALLET_RES = "สร้างกระเป๋าเงินใหม่ และมีจำนวณเงินในกระเป๋า %s บาท";
    public static final String VIEW_WALLET_RES = "มีจำนวณเงินในกระเป๋า %s บาท";

    //Category
    public static final String MANAGE_CATEGORY_RES ="""
            โปรดพิมพ์ข้อความต่อไปนี้ 
            #5 เพิ่ม <ชื่อหมวดหมู่>
            #5 ลบ <ชื่อหมวดหมู่>
            #5 ดู 
            """;;

    // Status
    public static String ERROR_COMMAND_NOT_FOUND = "ไม่พบข้อมูลของคำสั่งนี้ในระบบ";
    public static String SUCCESS_STATUS_FROM_LINE = "Success";
}
