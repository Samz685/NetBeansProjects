package com.mycompany.loginfxml;

import models.Alumno;
import models.Empresa;
import models.Profesor;

public class SessionData {

    private static Alumno alumno;

    private static Profesor profesor;

    private static Empresa empresa;

    public static Alumno getAlumno() {
        return alumno;
    }

    public static void setAlumno(Alumno alumno) {
        SessionData.alumno = alumno;
    }

    public static Profesor getProfesor() {
        return profesor;
    }

    public static void setProfesor(Profesor profesor) {
        SessionData.profesor = profesor;
    }

    public static Empresa getEmpresa() {
        return empresa;
    }

    public static void setEmpresa(Empresa empresa) {
        SessionData.empresa = empresa;
    }

}
