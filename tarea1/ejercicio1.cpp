#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main() {
ifstream archivo("/Users/macbook/proyectos/tarea1/estudiantes.txt");
    string nombre;
    double n1, n2, n3;
    int total = 0, aprobados = 0;
    double suma = 0;

    if (!archivo.is_open()) {
        cout << "Error: no se pudo abrir el archivo." << endl;
        return 1;
    }

    while (archivo >> nombre >> n1 >> n2 >> n3) {
        double promedio = (n1 + n2 + n3) / 3.0;
        string estado;
        if (promedio >= 9)       estado = "Excelente";
        else if (promedio >= 7)  estado = "Bueno";
        else                     estado = "Reprobado";

        cout << "Nombre: " << nombre << endl;
        cout << "Promedio: " << promedio << endl;
        cout << "Estado: " << estado << endl;
        cout << "----------------------------" << endl;

        if (promedio >= 7) aprobados++;
        suma += promedio;
        total++;
    }

    archivo.close();
    cout << "Total estudiantes: " << total << endl;
    cout << "Total aprobados: " << aprobados << endl;
    cout << "Promedio general: " << suma / total << endl;
    return 0;
}
