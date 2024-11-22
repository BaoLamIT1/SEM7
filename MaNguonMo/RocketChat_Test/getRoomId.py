import requests
import time

# Thay đổi thông tin sau cho phù hợp với cài đặt của bạn
auth_token = 'q6CwdDPFuBH0njY-u2zRs0J27dSegFUyY1JQOJp5HSJ'
user_id = 'cicBZx2QQ63bhXbj3'
channel_name = 'MaNguonMo'  # Dùng tên kênh thay vì roomId
url = 'http://192.168.8.128:3000/api/v1/rooms.info'

delays = 0
headers = {
    'X-Auth-Token': auth_token,
    'X-User-Id': user_id
}
response = requests.get(f'{url}?roomName={channel_name}', headers=headers)
    
if response.status_code == 200:
    print(response.json())
else:
    print("Failed to :", response.text)