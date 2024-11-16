import cv2
import numpy as np
import matplotlib.pyplot as plt

# Đọc ảnh và chuyển sang ảnh xám nếu cần
img = cv2.imread('church_salt_pepper_noise.png', cv2.IMREAD_GRAYSCALE)

# Kiểm tra nếu ảnh được đọc đúng
if img is None:
    print("Error: Image not found or unable to read.")
else:
    print("Image shape:", img.shape)
    print("Image dtype:", img.dtype)

# Hiển thị ảnh gốc
plt.figure(figsize=(10, 6))
plt.subplot(1, 3, 1)
plt.imshow(img, cmap='gray', vmin=0, vmax=255)  # Đặt giá trị tối thiểu và tối đa
plt.title('Original Image with Salt and Pepper Noise')
plt.axis('off')

# Biến đổi Fourier 2D
dft = np.fft.fft2(img)
dft_shift = np.fft.fftshift(dft)

# Tạo mặt nạ Low Pass Filter (LPF) để lọc tần số cao
rows, cols = img.shape
crow, ccol = rows // 2, cols // 2
r = 50  # Bán kính của bộ lọc, điều chỉnh giá trị này để lọc nhiễu

# Tạo mặt nạ LPF
mask = np.zeros((rows, cols), np.uint8)
X, Y = np.ogrid[:rows, :cols]
mask_area = (X - crow) ** 2 + (Y - ccol) ** 2 <= r ** 2
mask[mask_area] = 1

# Áp dụng mặt nạ lọc vào phổ tần số
fshift_filtered = dft_shift * mask

# Tính phổ biên độ sau khi lọc
magnitude_spectrum = np.log(np.abs(fshift_filtered) + 1)
plt.subplot(1, 3, 2)
plt.imshow(magnitude_spectrum, cmap='gray')
plt.title('Magnitude Spectrum after LPF')
plt.axis('off')

# Biến đổi ngược để tái tạo ảnh
f_ishift = np.fft.ifftshift(fshift_filtered)
img_filtered = np.fft.ifft2(f_ishift)
img_filtered = np.abs(img_filtered)

# Hiển thị ảnh sau khi lọc
plt.subplot(1, 3, 3)
plt.imshow(img_filtered, cmap='gray', vmin=0, vmax=255)  # Đặt giá trị tối thiểu và tối đa
plt.title('Filtered Image')
plt.axis('off')

# Lưu ảnh đã lọc
cv2.imwrite('filtered_image.jpg', cv2.normalize(img_filtered, None, 0, 255, cv2.NORM_MINMAX).astype(np.uint8))
print('Filtered image saved as filtered_image.jpg')

plt.show()
