package DemoConnectDB;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/poly/demo/connectdb")
public class GiangVienServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        GiangVienRepository repository =
                new GiangVienRepository();

        resp.getWriter().println(
                "=====TRUOC KHI CHAY INSERT, UPDATE, DELETE====="
        );

        // 1. Lấy tất cả giảng viên
        List<GiangVien> list =
                repository.getAll();

        for (GiangVien gv : list) {

            resp.getWriter().println(gv);
        }

        // 2. Thêm giảng viên
        GiangVien gvNew =
                new GiangVien(
                        0,
                        "TS004",
                        "Toan",
                        30,
                        "HCM"
                );

        repository.insert(gvNew);

        // 3. Update giảng viên
        GiangVien gvUpdate =
                new GiangVien(
                        4,
                        "TS004",
                        "Mai",
                        40,
                        "HCM"
                );

        repository.update(gvUpdate);

        // 4. Xóa giảng viên
        // repository.delete(1);

        // 5. Lấy lại dữ liệu sau khi thao tác
        resp.getWriter().println(
                "=====SAU KHI CHAY INSERT, UPDATE, DELETE====="
        );

        List<GiangVien> list1 =
                repository.getAll();

        for (GiangVien gv : list1) {

            resp.getWriter().println(gv);
        }
    }
}