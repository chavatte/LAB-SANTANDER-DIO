package com.chavate.hotelReservation;

import com.chavate.hotelReservation.model.Cliente;
import com.chavate.hotelReservation.model.Quarto;
import com.chavate.hotelReservation.model.Reserva;
import com.chavate.hotelReservation.repository.ClienteRepository;
import com.chavate.hotelReservation.repository.QuartoRepository;
import com.chavate.hotelReservation.repository.ReservaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final QuartoRepository quartoRepository;
    private final ClienteRepository clienteRepository;
    private final ReservaRepository reservaRepository;

    public DataLoader(QuartoRepository quartoRepository,
            ClienteRepository clienteRepository,
            ReservaRepository reservaRepository) {
        this.quartoRepository = quartoRepository;
        this.clienteRepository = clienteRepository;
        this.reservaRepository = reservaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Quarto quarto1 = quartoRepository.save(new Quarto(Quarto.TipoQuarto.STANDARD, 101, 300.00, true));
        Quarto quarto2 = quartoRepository.save(new Quarto(Quarto.TipoQuarto.STANDARD, 102, 300.00, true));
        Quarto quarto3 = quartoRepository.save(new Quarto(Quarto.TipoQuarto.LUXO, 201, 450.00, true));
        Quarto quarto4 = quartoRepository.save(new Quarto(Quarto.TipoQuarto.LUXO, 202, 450.00, true));
        Quarto quarto5 = quartoRepository.save(new Quarto(Quarto.TipoQuarto.SUITE, 301, 600.00, true));

        Cliente cliente1 = new Cliente();
        cliente1.setNome("João Silva");
        cliente1.setEmail("joao.silva@email.com");
        cliente1.setTelefone("123456789");
        clienteRepository.save(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Maria Souza");
        cliente2.setEmail("maria.souza@email.com");
        cliente2.setTelefone("987654321");
        clienteRepository.save(cliente2);

        Cliente cliente3 = new Cliente();
        cliente3.setNome("Pedro Alves");
        cliente3.setEmail("pedro.alves@email.com");
        cliente3.setTelefone("555555555");
        clienteRepository.save(cliente3);

        Cliente cliente4 = new Cliente();
        cliente4.setNome("Ana Oliveira");
        cliente4.setEmail("ana.oliveira@email.com");
        cliente4.setTelefone("444444444");
        clienteRepository.save(cliente4);

        Cliente cliente5 = new Cliente();
        cliente5.setNome("Carlos Santos");
        cliente5.setEmail("carlos.santos@email.com");
        cliente5.setTelefone("333333333");
        clienteRepository.save(cliente5);

        Reserva reserva1 = new Reserva();
        reserva1.setQuarto(quarto1);
        reserva1.setCliente(cliente1);
        reserva1.setDataEntrada(LocalDate.now().minusDays(10));
        reserva1.setDataSaida(LocalDate.now().minusDays(5));
        reservaRepository.save(reserva1);

        Reserva reserva2 = new Reserva();
        reserva2.setQuarto(quarto3);
        reserva2.setCliente(cliente2);
        reserva2.setDataEntrada(LocalDate.now().minusDays(15));
        reserva2.setDataSaida(LocalDate.now().minusDays(10));
        reservaRepository.save(reserva2);

        Reserva reserva3 = new Reserva();
        reserva3.setQuarto(quarto2);
        reserva3.setCliente(cliente3);
        reserva3.setDataEntrada(LocalDate.now().minusDays(2));
        reserva3.setDataSaida(LocalDate.now().plusDays(5));
        reservaRepository.save(reserva3);

        Reserva reserva4 = new Reserva();
        reserva4.setQuarto(quarto4);
        reserva4.setCliente(cliente4);
        reserva4.setDataEntrada(LocalDate.now());
        reserva4.setDataSaida(LocalDate.now().plusDays(3));
        reservaRepository.save(reserva4);

        Reserva reserva5 = new Reserva();
        reserva5.setQuarto(quarto5);
        reserva5.setCliente(cliente5);
        reserva5.setDataEntrada(LocalDate.now().plusDays(1));
        reserva5.setDataSaida(LocalDate.now().plusDays(4));
        reservaRepository.save(reserva5);
    }
}