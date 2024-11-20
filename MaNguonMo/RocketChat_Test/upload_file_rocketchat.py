from rocketchat_API.rocketchat import RocketChat
import time
import os
# Rocket.Chat credentials
rocket_url = 'http://192.168.80.135:3000/'
username = 'ptha03120312@gmail.com'
password = 'utc@123'
room_id = '670cbfd9d6cac2c4551f489b'  # You can also use 'room_name' instead of 'room_id'

# File to be uploaded
file_path = "file_1MB.bin"
file_size = os.path.getsize(file_path)  
start_time = time.time()
# Authenticate with Rocket.Chat
rocket = RocketChat(username, password, server_url=rocket_url)
    
response = rocket.rooms_upload(rid= room_id, file=file_path)
end_time = time.time()

# Bước 3: Tính toán tốc độ
elapsed_time = end_time - start_time  # Thời gian gửi (giây)
speed = file_size / (1024 * 1024) / elapsed_time  # Tốc độ (MB/s)

print(f"Tệp đã được gửi với kích thước: {file_size / (1024 * 1024):.2f} MB")
print(f"Thời gian gửi: {elapsed_time:.2f} giây")
print(f"Tốc độ gửi: {speed:.2f} MB/s")

# Check the response
if response.status_code == 200:
    print('File uploaded successfully!')
else:
    print(f'Failed to upload file: {response.json()}')
