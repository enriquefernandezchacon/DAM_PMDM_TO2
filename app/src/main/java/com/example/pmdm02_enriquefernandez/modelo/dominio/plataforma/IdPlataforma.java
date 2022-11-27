package com.example.pmdm02_enriquefernandez.modelo.dominio.plataforma;

//ENUM QUE CLASIFICA LAS POSIBLES PLATAFORMAS DE CONTENIDO
public enum IdPlataforma {
    NETFLIX {
        public String toString() {
            return "Netflix";
        }
    },
    HBO {
        public String toString() {
            return "HBO Max";
        }
    },
    PRIME {
        public String toString() {
            return "Amazon Prime Video";
        }
    },
    DISNEY {
        public String toString() {
            return "Disney+";
        }
    },
    DAZN {
        public String toString() {
            return "Dazn";
        }
    }
}
