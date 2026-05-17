package DemoConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GiangVienRepository {

    // 1. Lấy tất cả giảng viên
    public List<GiangVien> getAll() {

        List<GiangVien> list = new ArrayList<>();

        String sql = "SELECT * FROM giang_vien";

        try (
                Connection con = DBConnect.getConnection();

                PreparedStatement ps =
                        con.prepareStatement(sql);

                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                GiangVien gv = new GiangVien();

                gv.setId(rs.getInt("id"));

                gv.setMa(
                        rs.getString("ma_giang_vien")
                );

                gv.setTen(
                        rs.getString("ten")
                );

                gv.setTuoi(
                        rs.getInt("tuoi")
                );

                gv.setNoiLamViec(
                        rs.getString("noi_lam_viec")
                );

                list.add(gv);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }

    // 2. Tìm theo nơi làm việc
    public List<GiangVien> getGiangVienTheoNoiLamViec(
            String noiLamViec
    ) {

        List<GiangVien> list =
                new ArrayList<>();

        String sql =
                "SELECT * FROM giang_vien WHERE noi_lam_viec = ?";

        try (
                Connection con = DBConnect.getConnection();

                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setString(1, noiLamViec);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    GiangVien gv = new GiangVien();

                    gv.setId(rs.getInt("id"));

                    gv.setMa(
                            rs.getString("ma_giang_vien")
                    );

                    gv.setTen(
                            rs.getString("ten")
                    );

                    gv.setTuoi(
                            rs.getInt("tuoi")
                    );

                    gv.setNoiLamViec(
                            rs.getString("noi_lam_viec")
                    );

                    list.add(gv);
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }

    // 3. Thêm giảng viên
    public boolean insert(GiangVien gv) {

        String sql =
                "INSERT INTO giang_vien(ma_giang_vien, ten, tuoi, noi_lam_viec) VALUES (?, ?, ?, ?)";

        try (
                Connection con = DBConnect.getConnection();

                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setString(1, gv.getMa());

            ps.setString(2, gv.getTen());

            ps.setInt(3, gv.getTuoi());

            ps.setString(4, gv.getNoiLamViec());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    // 4. Update
    public boolean update(GiangVien gv) {

        String sql =
                "UPDATE giang_vien SET ma_giang_vien=?, ten=?, tuoi=?, noi_lam_viec=? WHERE id=?";

        try (
                Connection con = DBConnect.getConnection();

                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setString(1, gv.getMa());

            ps.setString(2, gv.getTen());

            ps.setInt(3, gv.getTuoi());

            ps.setString(4, gv.getNoiLamViec());

            ps.setInt(5, gv.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    // 5. Xóa
    public boolean delete(int id) {

        String sql =
                "DELETE FROM giang_vien WHERE id=?";

        try (
                Connection con = DBConnect.getConnection();

                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
}