import cv2
from math import cos, sin
import matplotlib.pyplot as plt
import numpy as np


def rotacion(a):
    x1 = a[0]
    x2 = a[1]
    a[0] = cos(0.08726646)*(x1)+(-sin(0.08726646))*x2
    a[1] = (x1*sin(0.08726646))+(x2*cos(0.08726646))
    return a


img = cv2.imread('img_prueba.jpeg')
rows, cols, ch = img.shape
input_matriz = [[-26.62, 39.33], [-23.37, -25.33], [16.42, 39.33]]

pts1 = np.float32(input_matriz)
pts2 = np.float32([rotacion(input_matriz[0]), rotacion(input_matriz[1]), input_matriz[2]])
M = cv2.getAffineTransform(pts1, pts2)
dst = cv2.warpAffine(img, M, (cols, rows))
plt.subplot(121), plt.imshow(img), plt.title('Input')
plt.subplot(122), plt.imshow(dst), plt.title('Output')
plt.show()

