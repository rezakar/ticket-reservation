package com.example.easynotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.easynotes.model.Ticket;
import com.example.easynotes.repository.ITicketDAO;

@Service
@Transactional
public class TicketService implements ITicketService{
	@Autowired
	private ITicketDAO ticketDAO;
	@Override
	public List<Ticket> getAllTicket(){
		return ticketDAO.getAllTickets();
	}
	@Override
	public Ticket getTicketById(int ticketId) {
		return ticketDAO.getTicketById(ticketId);
	}
	@Override
	public void addTicket(Ticket ticket) {
		ticketDAO.addTicket(ticket);
	}
	@Override
	public void updateTicket(Ticket ticket) {
		ticketDAO.updateTicket(ticket);
	}
	@Override
	public void deleteTicket(int ticketId) {
		ticketDAO.deleteTicket(ticketId);
	}
	@Override
	public void closeTicket(int ticketId) {
		ticketDAO.closeTicket(ticketId);
	}
}
