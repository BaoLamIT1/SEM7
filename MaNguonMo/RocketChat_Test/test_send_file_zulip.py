import requests
import time
import os
import zulip
# Pass the path to your zuliprc file here.
client = zulip.Client(
    email="ptha03120312@gmail.com", 
    api_key="PlTcDA5oCbg6o928vA27hqFeX6tC59Wn", 
    site="https://utc.zulipchat.com")

file_path = "file_1MB.bin"
file_size = os.path.getsize(file_path)

# Upload a file.
with open("file_1MB.bin", "rb") as fp:
    start_time = time.time()
    result = client.upload_file(fp)
    end_time = time.time()
    
elapsed_time = end_time - start_time  # Thời gian gửi (giây)
speed = file_size / (1024 * 1024) / elapsed_time  # Tốc độ (MB/s)

print(f"Tệp đã được gửi với kích thước: {file_size / (1024 * 1024):.2f} MB")
print(f"Thời gian gửi: {elapsed_time:.2f} giây")
print(f"Tốc độ gửi: {speed:.2f} MB/s")

# Share the file by including it in a message.
client.send_message(
    {
        "type": "stream",
        "to": "general",
        "topic": "Test2",
        "content": "Check out [this file]({}) of my castle!".format(result["url"]),
    }
)
print(result)