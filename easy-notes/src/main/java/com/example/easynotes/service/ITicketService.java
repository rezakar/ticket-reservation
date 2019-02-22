package com.example.easynotes.service;

import java.util.List;

import com.example.easynotes.model.Ticket;

public interface ITicketService {

	List<Ticket> getAllTicket();

	Ticket getTicketById(int ticketId);

	void addTicket(Ticket ticket);

	void updateTicket(Ticket ticket);

	void deleteTicket(int ticketId);

	void closeTicket(int ticketId);

}
