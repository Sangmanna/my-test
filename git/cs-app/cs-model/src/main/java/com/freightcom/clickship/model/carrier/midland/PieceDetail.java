package com.freightcom.clickship.model.carrier.midland;

public class PieceDetail {
    private int pieceNo;
    private double weightLbs;
    private double weightKgs;
    private String pieceDimsUOM;
    private double pieceLength;
    private double pieceWidth;
    private double pieceHeight;

    public int getPieceNo() {
        return pieceNo;
    }

    public void setPieceNo(int pieceNo) {
        this.pieceNo = pieceNo;
    }

    public double getWeightLbs() {
        return weightLbs;
    }

    public void setWeightLbs(double weightLbs) {
        this.weightLbs = weightLbs;
    }

    public double getWeightKgs() {
        return weightKgs;
    }

    public void setWeightKgs(double weightKgs) {
        this.weightKgs = weightKgs;
    }

    public String getPieceDimsUOM() {
        return pieceDimsUOM;
    }

    public void setPieceDimsUOM(String pieceDimsUOM) {
        this.pieceDimsUOM = pieceDimsUOM;
    }

    public double getPieceLength() {
        return pieceLength;
    }

    public void setPieceLength(double pieceLength) {
        this.pieceLength = pieceLength;
    }

    public double getPieceWidth() {
        return pieceWidth;
    }

    public void setPieceWidth(double pieceWidth) {
        this.pieceWidth = pieceWidth;
    }

    public double getPieceHeight() {
        return pieceHeight;
    }

    public void setPieceHeight(double pieceHeight) {
        this.pieceHeight = pieceHeight;
    }
}
