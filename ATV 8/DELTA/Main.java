package DELTA;

public class Main {

    public static void main(String[] args) {

        Medico medico = new Medico(
                "Dr. Shepherd",
                "Cardiologia",
                "CRM-12345"
        );

        Paciente paciente = new Paciente(
                "Simon Riley",
                20,
                "741.336.320-87"
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