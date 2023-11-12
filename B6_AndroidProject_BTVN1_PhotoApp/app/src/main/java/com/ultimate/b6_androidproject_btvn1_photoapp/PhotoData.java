package com.ultimate.b6_androidproject_btvn1_photoapp;

import java.util.ArrayList;

public class PhotoData {
    public static ArrayList<Photo> generatePhotoData() {
        ArrayList<Photo> photos = new ArrayList<>();

        photos.add(new Photo(0,
                "https://upload.wikimedia.org/wikipedia/vi/thumb/a/a1/Man_Utd_FC_.svg/1200px-Man_Utd_FC_.svg.png",
                "Manchester United",
                "Câu lạc bộ bóng đá Manchester United (tiếng Anh: Manchester United Football Club, hay ngắn gọn là MU hay Man Utd) là một câu lạc bộ bóng đá chuyên nghiệp có trụ sở tại Old Trafford, Đại Manchester, Anh. Câu lạc bộ hiện đang chơi tại Giải bóng đá Ngoại hạng Anh, giải đấu hàng đầu trong hệ thống bóng đá Anh. Với biệt danh Quỷ Đỏ, câu lạc bộ được thành lập dưới tên Newton Heath LYR Football Club vào năm 1878, đổi tên thành Manchester United vào năm 1902 và chuyển đến sân vận động hiện tại, Old Trafford, vào năm 1910.\n" +
                        "\n" +
                        "Manchester United là câu lạc bộ thành công nhất lịch sử bóng đá Anh khi giữ kỷ lục 20 lần vô địch bóng đá Anh, đoạt 12 Cúp FA, 6 Cúp Liên đoàn và giữ kỷ lục 21 lần đoạt Siêu cúp Anh. Câu lạc bộ đã giành được 3 Cúp C1 châu Âu/UEFA Champions League, 1 UEFA Cup Winners' Cup, 1 UEFA Europa league, 1 Siêu cúp châu Âu, 1 Cúp Liên lục địa và 1 FIFA Club World Cup. Trong mùa giải 1998–99, Manchester United trở thành đội bóng Anh đầu tiên giành cú ăn ba trong một mùa giải, gồm các chức vô địch Ngoại hạng Anh, cúp FA và UEFA Champions League."
        ));

        photos.add(new Photo(1,
                "https://upload.wikimedia.org/wikipedia/vi/thumb/1/1d/Manchester_City_FC_logo.svg/285px-Manchester_City_FC_logo.svg.png",
                "Manchester City",
                "Câu lạc bộ bóng đá Manchester City (tiếng Anh: Manchester City Football Club) là một câu lạc bộ bóng đá Anh có trụ sở tại Manchester, thi đấu tại Giải bóng đá Ngoại hạng Anh, giải đấu hàng đầu của bóng đá Anh. Được thành lập vào ngày 16 tháng 4 năm 1880 với tên gọi St. Mark's (West Gorton), họ trở thành Câu lạc bộ bóng đá Ardwick vào năm 1887 và Manchester City vào năm 1894. Sân nhà của câu lạc bộ là Sân vận động Etihad ở phía đông Manchester, nơi họ chuyển đến vào năm 2003 sau khi thi đấu tại Maine Road kể từ năm 1923. Manchester City sử dụng áo thi đấu sân nhà màu xanh da trời của họ vào năm 1894, trong mùa giải đầu tiên với tên hiện tại. Trong suốt lịch sử của mình, câu lạc bộ đã giành được chín chức vô địch quốc gia, bảy Cúp FA, tám Cúp EFL, sáu Siêu cúp Anh, một UEFA Champions League, một UEFA Cup Winners' Cup và một UEFA Super Cup.\n" +
                        "\n" +
                        "Câu lạc bộ tham gia Liên đoàn bóng đá năm 1892 và giành được danh hiệu lớn đầu tiên, Cúp FA, năm 1904. Manchester City đã có giai đoạn thành công lớn đầu tiên vào cuối những năm 1960 và đầu những năm 1970, giành chức vô địch quốc gia, Cúp FA, League Cup và European Cup Winners Cup dưới sự huấn luyện của Joe Mercer và Malcolm Allison. Sau khi thua trận Chung kết Cúp FA 1981, Manchester City đã trải qua một thời kỳ sa sút, với đỉnh điểm là việc xuống hạng ba của bóng đá Anh lần đầu tiên trong lịch sử vào năm 1998. Kể từ đó, họ giành lại quyền thăng hạng lên hạng cao nhất vào năm 2001–02 và tiếp tục là một đội xuất hiện thường xuyên ở Premier League kể từ mùa giải 2002–03."
        ));


        return photos;
    }

    public static Photo getPhotoFromId(int id, ArrayList<Photo> photos) {
        for (int i = 0; i < photos.size(); i++) {
            if (photos.get(i).getId() == id) {
                return photos.get(i);
            }
        }

        return null;
    }
}
