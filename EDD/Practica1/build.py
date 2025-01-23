import glob
import subprocess
import sys
import os

def compilar_y_ejecutar():
    try:
        # Encontrar todos los archivos .java en el directorio src y subdirectorios
        archivos_java = glob.glob("src/**/*.java", recursive=True)
        if not archivos_java:
            sys.exit(1)

        # Crear el directorio de salida si no existe
        if not os.path.exists("./bin"):
            os.makedirs("./bin")

        # Compilar los archivos encontrados
        compilacion = subprocess.run(
            ["javac", "-d", "./bin"] + archivos_java,
            check=True
        )

        # Ejecutar la clase principal
        ejecucion = subprocess.run(
            ["java", "-cp", "bin", "App"], 
            check=True
        )

    except subprocess.CalledProcessError as e:
        print(e)
        sys.exit(1)
    except Exception as e:
        print(e)
        sys.exit(1)

if __name__ == "__main__":
    compilar_y_ejecutar()

