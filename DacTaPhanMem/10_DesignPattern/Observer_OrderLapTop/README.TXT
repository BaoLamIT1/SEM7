1. Subject (WeatherStation): Là đối tượng lưu trữ trạng thái nhiệt độ và thông báo cho các observer khi nhiệt độ thay đổi.
Khi nhiệt độ được cập nhật qua phương thức setTemperature(), nó gọi notifyObservers() để thông báo cho tất cả các observer đã đăng ký.
2. Observer (PhoneDisplay và WindowDisplay): Đây là các đối tượng muốn theo dõi sự thay đổi của WeatherStation. 
Khi nhận được thông báo từ WeatherStation, chúng thực hiện hành động phù hợp (như hiển thị nhiệt độ mới).
Các observer đăng ký theo dõi bằng cách gọi registerObserver() và có thể hủy đăng ký bằng removeObserver().
3. Khi nhiệt độ thay đổi:
WeatherStation sẽ thông báo cho tất cả các observer bằng cách gọi update() trên từng observer.
Các observer sẽ thực hiện hành động tương ứng (trong ví dụ là hiển thị nhiệt độ).