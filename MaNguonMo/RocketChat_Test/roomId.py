import requests

auth_token = 'q6CwdDPFuBH0njY-u2zRs0J27dSegFUyY1JQOJp5HSJ'
user_id = 'cicBZx2QQ63bhXbj3'
url = 'http://192.168.8.128:3000/api/v1/channels.info?roomName=general'

headers = {
    'X-Auth-Token': auth_token,
    'X-User-Id': user_id,
    'Content-Type': 'application/json'
}

response = requests.get(url, headers=headers)
if response.status_code == 200:
    room_info = response.json()
    room_id = room_info['channel']['_id']
    print(f"Room ID: {room_id}")
else:
    print(f"Failed to retrieve room info. Error: {response.text}")
