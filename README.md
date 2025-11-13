#  Tích hợp mini app sử dụng uni-app vào Android Native

Repo này trình bày phương pháp để tích hợp một mini app sử dụng uni-app vào một ứng dụng Android Native (Kotlin hoặc Java).
---

##  Cấu trúc Repository

Repo này chứa 4 thư mục:

1.   **`uniapp`**: Đây là một mini app sử dụng uni-app, là 1 ứng dụng đơn giản có 1 màn hình hiển thị danh sách bao gồm 10 ảnh được lấy từ API list photos của unsplash.

2.   **`SDK-Android@4.85-20251106`**: Đây là bộ SDK hỗ trợ cho việc tích hợp mini app vào trong app android native (lưu ý: bộ sdk này không áp dụng cho toàn bộ các phiên bản uni app khác nhau, việc sử dụng bộ sdk nào còn phụ thuộc vào việc bạn build mini app trên HBuilderX phiên bản bao nhiêu)

3.   **`My_kotlin_groovydsl_uniappx_app`**: Ứng dụng Android Native (Host) tích hợp mini app, ứng dụng sử dụng ngôn ngữ kotlin và groovy dsl, là 1 ứng dụng đơn giản, khi khởi động ứng dụng sẽ có 1 button, khi nhấn vào button này sẽ tiến hành chuyển qua giao diện của mini app.

4.   **`My_java_kotlindsl_uniappx_app`**: Ứng dụng Android Native (Host) tích hợp mini app, ứng dụng sử dụng ngôn ngữ java và kotlin dsl, là 1 ứng dụng đơn giản, khi khởi động ứng dụng sẽ có 1 button, khi nhấn vào button này sẽ tiến hành chuyển qua giao diện của mini app.

---
##  Cài đặt
Dưới đây là hướng dẫn để clone và chạy cả hai phiên bản demo.
### Bước 1: Tải mã nguồn (Clone)
Tải repo:
```text
git clone https://github.com/HoangHuuTinIT/add-uni-mini-app-to-android-native-app.git
```
### Bước 2:Chạy Demo

### Cách chạy Demo My_kotlin_groovydsl_uniappx_app
1. Mở Android Studio.

2. Chọn "Open" (hoặc "Open an existing project").

3. Tìm đến thư mục My_kotlin_groovydsl_uniappx_app trong repo bạn vừa clone.

4. Mở lên và đợi Android Studio đồng bộ (Sync) Gradle.

5. Nhấn nút "Run 'app'" để build và chạy ứng dụng.


### Cách chạy Demo My_java_kotlindsl_uniappx_app

1. Mở Android Studio (bạn có thể mở một cửa sổ mới).

2. Chọn "Open".

3. Tìm đến thư mục My_kotlin_groovydsl_uniappx_app trong repo bạn vừa clone.

4. Mở lên và đợi Android Studio đồng bộ (Sync) Gradle.

5. Nhấn nút "Run 'app'" để build và chạy ứng dụng.

```
---
## Cách tích hợp chi tiết:
Tham khảo tại đường link:
https://docs.google.com/document/d/12zPp3s2hAV8dgjWk00OBRQQlk-KHnuk-JYq3lDY6PaU/edit?tab=t.0

Hoặc tham khảo tại:
https://nativesupport.dcloud.net.cn/
