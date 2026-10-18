import java.sql.*;

public class Bitacora {

        static String todos = "SELECT * FROM bitacora ORDER BY folio DESC";

    
    // folio, tiempo, tipo, observaciones, infantes_curp, responsables_curpr, educadores_curpe
    String folio, tiempo, tipo, observaciones, infantes_curp, responsables_curpr, educadores_curpe;

    public Bitacora() {

    }

    public Bitacora(String folio, String tiempo, String tipo, String observaciones, String infantes_curp, String responsables_curpr, String educadores_curpe) {
        this.folio = folio;
        this.tiempo = tiempo;
        this.tipo = tipo;
        this.observaciones = observaciones;
        this.infantes_curp = infantes_curp;
        this.responsables_curpr = responsables_curpr;
        this.educadores_curpe = educadores_curpe;
    }

    public int insertar(Connection con) {
        int resultado = 0;
        try {
            String sql = "INSERT INTO bitacora (tiempo, tipo, observaciones, infantes_curp, responsables_curpr, educadores_curpe) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tiempo);
            ps.setString(2, tipo);
            ps.setString(3, observaciones);
            ps.setString(4, infantes_curp);
            ps.setString(5, responsables_curpr);
            ps.setString(6, educadores_curpe);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int borrar(Connection con) {
        int resultado = 0;
        try {
            String sql = "DELETE FROM bitacora WHERE folio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int actualizar(Connection con) {
        int resultado = 0;
        try {
            String sql = "UPDATE bitacora SET tiempo = ?, tipo = ?, observaciones = ?, infantes_curp = ?, responsables_curpr = ?, educadores_curpe = ? WHERE folio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tiempo);
            ps.setString(2, tipo);
            ps.setString(3, observaciones);
            ps.setString(4, infantes_curp);
            ps.setString(5, responsables_curpr);
            ps.setString(6, educadores_curpe);
            ps.setString(7, folio);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
            return resultado;
        }
    }

}