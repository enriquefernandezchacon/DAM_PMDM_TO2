package com.example.pmdm02_enriquefernandez.modelo.dominio.plataforma;

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
            return "Diseny+";
        }
    },
    DAZN {
        public String toString() {
            return "Dazn";
        }
    }
}
