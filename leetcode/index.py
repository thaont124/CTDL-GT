import requests
from faker import Faker
import random

# Khởi tạo Faker
fake = Faker()

# Địa chỉ endpoint
url = "http://localhost:8080/api/categories"

# Số lượng bản ghi
num_records = 1_000_000

# Function để tạo dữ liệu giả
def create_fake_data():
    name = fake.name()
    description = fake.text(max_nb_chars=200)  # Giới hạn mô tả không quá 200 ký tự
    return {"name": name, "description": description}

# Function để gửi dữ liệu
def send_data(data):
    try:
        response = requests.post(url, json=data)
        response.raise_for_status()
        print(f"Success: {response.status_code}")
    except requests.exceptions.RequestException as e:
        print(f"Error: {e}")

# Tạo và gửi dữ liệu theo batch để tránh quá tải
batch_size = 1000
for i in range(0, num_records, batch_size):
    batch = [create_fake_data() for _ in range(batch_size)]
    for record in batch:
        send_data(record)

print("All data sent!")
