import cv2
import numpy as np
import matplotlib.pyplot as plt

# Đọc ảnh và chuyển sang ảnh xám
img = cv2.imread('Anh_nhieu_muoi.tif', cv2.IMREAD_GRAYSCALE)

# Kiểm tra nếu ảnh được đọc đúng
if img is None:
    print("Error: Image not found or unable to read.")
else:
    print("Image shape:", img.shape)
    print("Image dtype:", img.dtype)

# Hiển thị ảnh gốc
plt.figure(figsize=(12, 6))
plt.subplot(1, 3, 1)
plt.imshow(img, cmap='gray', vmin=0, vmax=255)
plt.title('Original Image with Salt Noise')
plt.axis('off')

# Biến đổi Fourier 2D
dft = np.fft.fft2(img)
dft_shift = np.fft.fftshift(dft)

# Kích thước ảnh
rows, cols = img.shape
crow, ccol = rows // 2, cols // 2

# Tạo mặt nạ Gaussian Filter
x = np.linspace(-ccol, ccol-1, cols)
y = np.linspace(-crow, crow-1, rows)
X, Y = np.meshgrid(x, y)
sigma = 30  # Độ rộng của Gaussian
mask = np.exp(-(X**2 + Y**2) / (2 * sigma**2))

# Áp dụng mặt nạ lọc vào phổ tần số
fshift_filtered = dft_shift * mask

# Biến đổi ngược để tái tạo ảnh
f_ishift = np.fft.ifftshift(fshift_filtered)
img_filtered = np.fft.ifft2(f_ishift)
img_filtered = np.abs(img_filtered)

# Chuyển đổi về kiểu uint8 và lưu ảnh
img_filtered = cv2.normalize(img_filtered, None, 0, 255, cv2.NORM_MINMAX).astype(np.uint8)
cv2.imwrite('filtered_image_salt_noise.jpg', img_filtered)
print('Filtered image saved as filtered_image_salt_noise.jpg')

# Hiển thị ảnh đã lọc
plt.subplot(1, 3, 2)
plt.imshow(img_filtered, cmap='gray', vmin=0, vmax=255)
plt.title('Filtered Image')
plt.axis('off')

# Hiển thị phổ biên độ
magnitude_spectrum = np.log(np.abs(dft_shift) + 1)
plt.subplot(1, 3, 3)
plt.imshow(magnitude_spectrum, cmap='gray')
plt.title('Magnitude Spectrum')
plt.axis('off')

plt.tight_layout()
plt.show()
