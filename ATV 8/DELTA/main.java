package DELTA;

public class main {

    public static void main(String[] args) {

        Medico medico = new Medico(
                "Dr. Carlos Silva",
                "Cardiologia",
                "CRM-12345"
        );

        Paciente paciente = new Paciente(
                "Lucas Bellini",
                20,
                "123.456.789-00"
        );

        medico.apresentarMedico();

        System.out.println();

        paciente.apresentarPaciente();

        System.out.println();

        paciente.realizarConsulta(medico);

        System.out.println();

        System.out.println("Após a consulta:");

        medico.apresentarMedico();

        System.out.println();

        paciente.apresentarPaciente();
    }
}