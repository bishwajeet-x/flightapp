package com.fbs.ticket.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fbs.ticket.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Long> {

	Optional<Ticket> findByPnr(String pnr);

	Optional<List<Ticket>> findByEmail(String email);

}
