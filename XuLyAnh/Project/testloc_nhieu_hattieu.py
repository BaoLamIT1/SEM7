import cv2
import numpy as np
import matplotlib.pyplot as plt

# Hàm thêm nhiễu hạt tiêu vào ảnh
def add_pepper_noise(image, noise_level=0.02):
    noisy_image = np.copy(image)
    # Tạo ngẫu nhiên các chỉ số cho các pixel bị nhiễu
    num_noise_pixels = int(noise_level * image.size)
    coords = [np.random.randint(0, i - 1, num_noise_pixels) for i in image.shape]
    noisy_image[coords[0], coords[1]] = 0  # Thay đổi giá trị pixel thành 0 (đen)
    return noisy_image

# Đọc ảnh và chuyển sang ảnh xám
img = cv2.imread('church.png', cv2.IMREAD_GRAYSCALE)

# Thêm nhiễu hạt tiêu vào ảnh
noisy_img = add_pepper_noise(img, noise_level=0.05)

# Biến đổi Fourier 2D
dft = np.fft.fft2(noisy_mg)
dft_shift = np.fft.fftshift(dft)

# Kích thước ảnh
rows, cols = noisy_img.shape
crow, ccol = rows // 2, cols // 2

# Tạo mặt nạ Gaussian Filter
x = np.linspace(-ccol, ccol - 1, cols)
y = np.linspace(-crow, crow - 1, rows)
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
cv2.imwrite('filtered_image_pepper_noise.jpg', img_filtered)
print('Filtered image saved as filtered_image_pepper_noise.jpg')

# Hiển thị ảnh gốc, ảnh nhiễu và ảnh đã lọc
plt.figure(figsize=(15, 5))
plt.subplot(1, 4, 1)
plt.imshow(img, cmap='gray', vmin=0, vmax=255)
plt.title('Original Image')
plt.axis('off')

plt.subplot(1, 4, 2)
plt.imshow(noisy_img, cmap='gray', vmin=0, vmax=255)
plt.title('Noisy Image with Pepper Noise')
plt.axis('off')

plt.subplot(1, 4, 3)
plt.imshow(img_filtered, cmap='gray', vmin=0, vmax=255)
plt.title('Filtered Image')
plt.axis('off')

# Hiển thị phổ biên độ
magnitude_spectrum = np.log(np.abs(dft_shift) + 1)
plt.subplot(1, 4, 4)
plt.imshow(magnitude_spectrum, cmap='gray')
plt.title('Magnitude Spectrum')
plt.axis('off')

plt.tight_layout()
plt.show()
