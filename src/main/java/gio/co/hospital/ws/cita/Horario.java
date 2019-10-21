
package gio.co.hospital.ws.cita;

/**
 *
 * @author migue
 */
public class Horario {
    int hId;
    String hora;

    public int getHorarioId() {
        return hId;
    }

    public void setHorarioId(int hId) {
        this.hId = hId;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Horario(int hId, String hora) {
        this.hId = hId;
        this.hora = hora;
    }
    
}
