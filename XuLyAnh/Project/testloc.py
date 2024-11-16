import cv2
import numpy as np
import matplotlib.pyplot as plt

# Đọc ảnh và chuyển sang ảnh xám
img = cv2.imread('church.png', cv2.IMREAD_GRAYSCALE)

# Biến đổi Fourier 2D
dft = np.fft.fft2(img)
dft_shift = np.fft.fftshift(dft)  # Dịch chuyển thành phần tần số không về giữa

# Hiển thị ảnh gốc
plt.figure(figsize=(10, 6))
plt.subplot(2, 3, 1)
plt.imshow(img, cmap='gray')
plt.title('Original Image')
plt.axis('off')

# Tạo phổ biên độ
magnitude_spectrum = np.log(np.abs(dft_shift) + 1)  # Tránh log(0)
plt.subplot(2, 3, 2)
plt.imshow(magnitude_spectrum, cmap='gray')
plt.title('Magnitude Spectrum')
plt.axis('off')

# Kích thước ảnh
rows, cols = img.shape
crow, ccol = rows // 2, cols // 2

# Lựa chọn bộ lọc
filter_type = 'HPF'  # Chọn 'HPF' cho High Pass Filter hoặc 'LPF' cho Low Pass Filter

if filter_type == 'HPF':
    # Tạo mặt nạ High Pass Filter (HPF)
    r = 50  # Bán kính của bộ lọc
    mask = np.ones((rows, cols), np.uint8)
    X, Y = np.ogrid[:rows, :cols]
    mask_area = (X - crow) ** 2 + (Y - ccol) ** 2 <= r ** 2
    mask[mask_area] = 0  # HPF: loại bỏ tần số thấp
elif filter_type == 'LPF':
    # Tạo mặt nạ Low Pass Filter (LPF)
    r = 50  # Bán kính của bộ lọc
    mask = np.zeros((rows, cols), np.uint8)
    X, Y = np.ogrid[:rows, :cols]
    mask_area = (X - crow) ** 2 + (Y - ccol) ** 2 <= r ** 2
    mask[mask_area] = 1  # LPF: chỉ giữ lại tần số thấp

# Áp dụng bộ lọc
fshift_masked = dft_shift * mask

# Hiển thị phổ sau khi áp dụng bộ lọc
fshift_mask_mag = np.log(np.abs(fshift_masked) + 1)
plt.subplot(2, 3, 3)
plt.imshow(fshift_mask_mag, cmap='gray')
plt.title('Filtered Spectrum')
plt.axis('off')

# Biến đổi ngược (Inverse FFT) để tái tạo ảnh
dft_ishift = np.fft.ifftshift(fshift_masked)  # Đảo ngược fftshift
img_back = np.fft.ifft2(dft_ishift)
img_back = np.abs(img_back)

# Hiển thị ảnh sau khi biến đổi ngược
plt.subplot(2, 3, 4)
plt.imshow(img_back, cmap='gray')
plt.title('Reconstructed Image')
plt.axis('off')

# Hiển thị mặt nạ lọc được sử dụng
plt.subplot(2, 3, 5)
plt.imshow(mask, cmap='gray')
plt.title('Filter Mask')
plt.axis('off')

# Lưu ảnh tái tạo (Reconstructed Image)
reconstructed_img = cv2.normalize(img_back, None, 0, 255, cv2.NORM_MINMAX).astype(np.uint8)
cv2.imwrite('output_img_spe.jpg', reconstructed_img)  # Lưu ảnh dưới dạng JPG
print('Reconstructed image saved as output_img_spe.jpg')

plt.show()
