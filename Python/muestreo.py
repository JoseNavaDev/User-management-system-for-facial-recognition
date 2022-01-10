import cv2
from tkinter import *

web_cam = cv2.VideoCapture(0)

cascPath = "K:/BaseDeDatosProyecto/haarcascade_frontalface_default.xml"
faceCascade = cv2.CascadeClassifier(cascPath)
nombre = "DanielNavaNava"

count = 0

while(True):
    _, imagen_marco = web_cam.read()

    grises = cv2.cvtColor(imagen_marco, cv2.COLOR_BGR2GRAY)

    rostro = faceCascade.detectMultiScale(grises, 1.15, 5)

    for(x,y,w,h) in rostro:
        cv2.rectangle(imagen_marco, (x,y), (x+w, y+h), (0,255,0), 4)
        count += 1
        cv2.imwrite("K:/BaseDeDatosProyecto/DanielNavaNava/"+nombre+str(count)+".jpg", grises[y:y+h, x:x+w])
        print(count)
        cv2.imshow("Creando dataset", imagen_marco)
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break    
    elif count >= 100:
        break

raiz = Tk()
raiz.title("Captura de imágenes")
raiz.resizable(0,0)
raiz.iconbitmap("C://Users//josem//Desktop//Python//Interfaces graficas//icono.ico")
raiz.geometry("650x350")
raiz.config(bg="white")
raiz.mainloop() 


# Cuando todo está hecho, liberamos la captura
web_cam.release()
cv2.destroyAllWindows()