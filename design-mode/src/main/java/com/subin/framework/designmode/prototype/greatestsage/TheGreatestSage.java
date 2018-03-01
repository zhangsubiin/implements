package com.subin.framework.designmode.prototype.greatestsage;

import java.io.*;
import java.util.Date;

/**
 * @author: subiin
 * @date: 2018/2/4 下午3:47
 * @description: 齐天大圣
 */
public class TheGreatestSage extends Monkey implements Cloneable, Serializable {

    private GoldRingedStaff staff;

    public TheGreatestSage() {
        this.staff = new GoldRingedStaff();
        this.birthday = new Date();
        this.height = 150;
        this.weight = 30;
        System.out.println("--------");
    }

    @Override
    protected Object clone() {
        //深度克隆
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            //return super.clone();//默认浅克隆，只克隆八大基本数据类型和String
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            TheGreatestSage copy = (TheGreatestSage) ois.readObject();
            copy.birthday = new Date();

            return copy;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void change() {
        TheGreatestSage copySage = (TheGreatestSage) clone();
        System.out.println("birthday：" + this.getBirthday().getTime());
        System.out.println("birthday：" + copySage.getBirthday().getTime());
        System.out.println("是否同一个对象：" + (this == copySage));
        System.out.println("是否同一个金箍棒：" + (this.getStaff() == copySage.getStaff()));
    }

    public GoldRingedStaff getStaff() {
        return staff;
    }

    public void setStaff(GoldRingedStaff staff) {
        this.staff = staff;
    }
}
