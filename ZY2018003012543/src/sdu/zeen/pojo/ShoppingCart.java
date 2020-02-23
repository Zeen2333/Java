package sdu.zeen.pojo;

import java.util.Objects;

public class ShoppingCart {
    private int ID1=1;
    private int num1;
    private int ID2=2;
    private int num2;
    private int ID3=3;
    private int num3;
    private int ID4=4;
    private int num4;
    private int userID;

    public ShoppingCart(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "ID1=" + ID1 +
                ", num1=" + num1 +
                ", ID2=" + ID2 +
                ", num2=" + num2 +
                ", ID3=" + ID3 +
                ", num3=" + num3 +
                ", ID4=" + ID4 +
                ", num4=" + num4 +
                ", userID=" + userID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingCart)) return false;
        ShoppingCart that = (ShoppingCart) o;
        return getID1() == that.getID1() &&
                getNum1() == that.getNum1() &&
                getID2() == that.getID2() &&
                getNum2() == that.getNum2() &&
                getID3() == that.getID3() &&
                getNum3() == that.getNum3() &&
                getID4() == that.getID4() &&
                getNum4() == that.getNum4() &&
                getUserID() == that.getUserID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID1(), getNum1(), getID2(), getNum2(), getID3(), getNum3(), getID4(), getNum4(), getUserID());
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public void setNum3(int num3) {
        this.num3 = num3;
    }

    public void setNum4(int num4) {
        this.num4 = num4;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getID1() {
        return ID1;
    }

    public int getNum1() {
        return num1;
    }

    public int getID2() {
        return ID2;
    }

    public int getNum2() {
        return num2;
    }

    public int getID3() {
        return ID3;
    }

    public int getNum3() {
        return num3;
    }

    public int getID4() {
        return ID4;
    }

    public int getNum4() {
        return num4;
    }

    public int getUserID() {
        return userID;
    }
}
