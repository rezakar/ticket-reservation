package com.example.easynotes.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.easynotes.model.Ticket;

@Transactional
@Repository
public class TicketDAO implements ITicketDAO{
	@PersistenceContext
	private EntityManager entityManager;
	//note Ticket is the class name; not the table name; class name is 
	//case sensitive; use class field names - column names
	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getAllTickets() {
		String query = "select t from Ticket t order by t.title";
		return (List<Ticket>) entityManager.createQuery(query).getResultList();
	}
	@Override
	public void addTicket(Ticket ticket) {
		entityManager.persist(ticket);
	}
	@Override
	public void updateTicket(Ticket ticket) {
		Ticket ticket1 = getTicketById(ticket.getId());
		ticket1.setDescription(ticket.getDescription());
		ticket1.setApplication(ticket.getApplication());
		ticket1.setTitle(ticket.getTitle());
		entityManager.flush();
	}
	@Override
	public Ticket getTicketById(int ticketId) {
		return entityManager.find(Ticket.class, ticketId);
	}
	@Override
	public void deleteTicket(int ticketId) {
		entityManager.remove(getTicketById(ticketId));
	}
	@Override
	public void closeTicket(int ticketId) {
		Ticket ticket = getTicketById(ticketId);
		ticket.setStatus("Resolved");
	}
}
