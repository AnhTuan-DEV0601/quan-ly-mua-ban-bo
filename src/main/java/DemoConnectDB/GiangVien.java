package DemoConnectDB;

public class GiangVien {
    private int id;
    private String ma;
    private String ten;
    private int tuoi;
    private String noiLamViec;

    // ✅ Constructor rỗng (BẮT BUỘC)
    public GiangVien() {
    }

    // ✅ Constructor đầy đủ (khuyên dùng)
    public GiangVien(int id, String ma, String ten, int tuoi, String noiLamViec) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.tuoi = tuoi;
        this.noiLamViec = noiLamViec;
    }

    // ✅ Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getNoiLamViec() {
        return noiLamViec;
    }

    public void setNoiLamViec(String noiLamViec) {
        this.noiLamViec = noiLamViec;
    }

    // (tuỳ chọn) in ra cho dễ test
    @Override
    public String toString() {
        return id + " - " + ma + " - " + ten + " - " + tuoi + " - " + noiLamViec;
    }
}