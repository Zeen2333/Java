package sdu.zeen.pojo;

import java.util.Objects;

public class Order {
    private int ID1;
    private int num1;
    private int ID2;
    private int num2;
    private int ID3;
    private int num3;
    private int ID4;
    private int num4;
    private int userID;
    private String date;

    public Order(int userID, String date) {
        this.userID = userID;
        this.date = date;
    }

    public int getID1() {
        return ID1;
    }

    public void setID1(int ID1) {
        this.ID1 = ID1;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getID2() {
        return ID2;
    }

    public void setID2(int ID2) {
        this.ID2 = ID2;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getID3() {
        return ID3;
    }

    public void setID3(int ID3) {
        this.ID3 = ID3;
    }

    public int getNum3() {
        return num3;
    }

    public void setNum3(int num3) {
        this.num3 = num3;
    }

    public int getID4() {
        return ID4;
    }

    public void setID4(int ID4) {
        this.ID4 = ID4;
    }

    public int getNum4() {
        return num4;
    }

    public void setNum4(int num4) {
        this.num4 = num4;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getID1() == order.getID1() &&
                getNum1() == order.getNum1() &&
                getID2() == order.getID2() &&
                getNum2() == order.getNum2() &&
                getID3() == order.getID3() &&
                getNum3() == order.getNum3() &&
                getID4() == order.getID4() &&
                getNum4() == order.getNum4() &&
                getUserID() == order.getUserID() &&
                Objects.equals(getDate(), order.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID1(), getNum1(), getID2(), getNum2(), getID3(), getNum3(), getID4(), getNum4(), getUserID(), getDate());
    }

    @Override
    public String toString() {
        return "Order{" +
                "ID1=" + ID1 +
                ", num1=" + num1 +
                ", ID2=" + ID2 +
                ", num2=" + num2 +
                ", ID3=" + ID3 +
                ", num3=" + num3 +
                ", ID4=" + ID4 +
                ", num4=" + num4 +
                ", userID=" + userID +
                ", date='" + date + '\'' +
                '}';
    }
}
