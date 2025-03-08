package com.brightkut.walley_v2.constant;

public class CommonConstant {
    // Command Wallet Req
    public static final String VIEW_WALLET = "ต้องการเรียกดูเงินในกระเป๋า";
    public static final String UPDATE_WALLET = "ต้องการเพิ่มลดข้อมูลรายการใช้จ่าย";
    public static final String SUMMARIZE_WALLET = "สรุปผลการเงิน";
    public static final String UPDATE_WALLET_BY_BILL = "ต้องการ Upload รูปภาพบิลค่าใช้จ่าย";

    // Command Wallet Res
    public static final String CREATE_WALLET_RES = "สร้างกระเป๋าเงินใหม่ และมีจำนวณเงินในกระเป๋า %s บาท";
    public static final String VIEW_WALLET_RES = "มีจำนวณเงินในกระเป๋า %s บาท";
    
    // Command Category Req
    public static final String MANAGE_CATEGORY ="ต้องการเพิ่ม , ลด, หรือ ดูหมวดหมู่ทั้งหมด";
    public static final String CREATE_CATEGORY = "#5 เพิ่ม";
    public static final String DELETE_CATEGORY = "#5 ลบ";
    public static final String VIEW_CATEGORY = "#5 ดู";
    
    // Command Category Res
    public static final String MANAGE_CATEGORY_RES ="""
            โปรดพิมพ์ข้อความต่อไปนี้ 
            #5 เพิ่ม <ชื่อหมวดหมู่>
            #5 ลบ <ชื่อหมวดหมู่>
            #5 ดู 
            """;            
    public static String CREATE_CATEGORY_DUPLICATE_RES = "หมวดหมู่นี้มีอยู่แล้ว";
    public static String CREATE_CATEGORY_INVALID_RES = "คำสั่งที่ใช้เพิ่มหมวดหมู่ไม่ถูกต้อง";
    public static String CREATE_CATEGORY_RES = "สร้างหมวดหมู่ %s สำเร็จ";
    public static String DELETE_CATEGORY_RES = "";
    public static String VIEW_CATEGORY_RES = "";

    // Status
    public static String ERROR_COMMAND_NOT_FOUND = "ไม่พบข้อมูลของคำสั่งนี้ในระบบ";
    public static String SUCCESS_STATUS_FROM_LINE = "Success";
    
    // Common
    public static String ADD = "เพิ่ม";
    public static String DELETE = "ลบ";
    public static String VIEW = "ดู";
}
