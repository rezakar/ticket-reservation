package com.example.easynotes.repository;

import java.util.List;

import com.example.easynotes.model.Ticket;

public interface ITicketDAO {

	List<Ticket> getAllTickets();

	void addTicket(Ticket ticket);

	Ticket getTicketById(int ticketId);

	void deleteTicket(int ticketId);

	void updateTicket(Ticket ticket);

	void closeTicket(int ticketId);

}
