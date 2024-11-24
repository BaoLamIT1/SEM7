import zulip
import time
import pandas as pd

# Cấu hình client Zulip
client = zulip.Client(email="ptha03120312@gmail.com", api_key="ltr6DVjrVJxW5xSoAVNq1vsfmNVxNBk6", site="https://utc.zulipchat.com")

# Khởi tạo danh sách lưu dữ liệu
messages_data = []

# Gửi 1000 tin nhắn và đo thời gian
start_time = time.time()

for i in range(1000):
    message_content = f"Tin nhắn {i+1} trong số 1000"
    message_data = {
        "type": "stream",  # Gửi vào stream
        "to": "general",   # Tên của stream muốn gửi
        "subject": "greetings",
        "content": message_content,
    }
    
    # Gửi tin nhắn
    send_start = time.time()
    response = client.send_message(message_data)
    send_end = time.time()
    
    # Lưu thông tin tin nhắn
    messages_data.append({
        "Index": i+1,
        "Content": message_content,
        "Response Status": response.get("result", "unknown"),
        "Time Taken (s)": send_end - send_start
    })

end_time = time.time()

# Tính toán thống kê
min_message = min(messages_data, key=lambda x: len(x["Content"]))
max_message = max(messages_data, key=lambda x: len(x["Content"]))
average_time = sum(x["Time Taken (s)"] for x in messages_data) / len(messages_data)

# Thêm thông tin tổng hợp vào file Excel
summary = {
    "Min Message Content": [min_message["Content"]],
    "Max Message Content": [max_message["Content"]],
    "Average Time (s)": [average_time],
    "Total Time (s)": [end_time - start_time]
}

# Xuất ra file Excel
df_messages = pd.DataFrame(messages_data)
df_summary = pd.DataFrame(summary)

with pd.ExcelWriter("zulip_messages.xlsx") as writer:
    df_messages.to_excel(writer, sheet_name="Messages", index=False)
    df_summary.to_excel(writer, sheet_name="Summary", index=False)

print("Đã xuất dữ liệu ra file 'zulip_messages.xlsx'")
