package com.example.easynotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.easynotes.exception.Bug;
import com.example.easynotes.exception.Enhancement;
import com.example.easynotes.model.Application;
import com.example.easynotes.model.Release;
import com.example.easynotes.model.Ticket;
import com.example.easynotes.service.*;


@RestController
@RequestMapping("/tza")
public class TrackController {
	@Autowired
    private IApplicationService applicationService;

    @Autowired
    private ITicketService ticketService;

    @Autowired
    private IReleaseService releaseService;

    @Autowired
    private IBugService bugService;

    @Autowired
    private IEnhancementService enhancementService;

    @PostMapping("/enhancement")
    public ResponseEntity<Void> addEnhancement(@RequestBody Enhancement enhancement, UriComponentsBuilder builder) {
       enhancementService.addEnhancement(enhancement);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/enhancement").buildAndExpand(enhancement.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PostMapping("/bug")
    public ResponseEntity<Void> addBug(@RequestBody Bug bug, UriComponentsBuilder builder) {
        bugService.addBug(bug);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/bug").buildAndExpand(bug.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @PostMapping("/application")
    public ResponseEntity<Void> addApplication(@RequestBody Application application, UriComponentsBuilder builder){
    	boolean flag = applicationService.addApplication(application);
    	if (!flag) return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    	HttpHeaders headers = new HttpHeaders();
    	headers.setLocation(builder.path("/application/{id}").buildAndExpand(application.getId()).toUri());
    	return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @GetMapping("/application/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable("id") Integer id){
    	Application app = applicationService.getApplicationByID(id);
    	return new ResponseEntity<Application>(app, HttpStatus.OK);
    }
    @PutMapping("/application")
    public ResponseEntity<Application> updateApplication(@RequestBody Application application){
    	applicationService.updateApplication(application);
    	return new ResponseEntity<Application>(application, HttpStatus.OK);
    }
    @DeleteMapping("/application/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable("id") Integer id){
    	applicationService.deleteApplication(id);
    	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/ticket/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable("id") Integer id){
    	Ticket ticket = ticketService.getTicketById(id);
    	return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
    }
    @GetMapping(" /tickets")
    public ResponseEntity<List<Ticket>> getAllTickets() {
    	List<Ticket> list = ticketService.getAllTicket();
    	return new ResponseEntity<List<Ticket>>(list, HttpStatus.OK);
    }
    @PostMapping(" /ticket ")
    public ResponseEntity<Void> addTicket(@RequestBody Ticket ticket, UriComponentsBuilder builder) {
    	ticketService.addTicket(ticket);
    	HttpHeaders headers = new HttpHeaders();
    	headers.setLocation(builder.path("/ticket/{id}").buildAndExpand(ticket.getId()).toUri());
    	return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @PutMapping("/ticket")
    public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket ){
    	ticketService.updateTicket(ticket);
    	return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
    }
    @DeleteMapping("/ticket/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable("id") Integer id){
    	ticketService.deleteTicket(id);
    	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/ticket/{id}")
    public ResponseEntity<Ticket> closeTicket(@PathVariable("id") Integer id){
    	ticketService.closeTicket(id);
    	return new ResponseEntity<Ticket>(HttpStatus.OK);
    }
    @PostMapping("/release")
    public ResponseEntity<Void> addRelease(@RequestBody Release release, UriComponentsBuilder builder) {
    	releaseService.addRelease(release);
    	HttpHeaders headers = new HttpHeaders();
    	headers.setLocation(builder.path("/release").buildAndExpand(release.getId()).toUri());
    	return new ResponseEntity<Void> (headers, HttpStatus.CREATED);
    }
    @PutMapping("/release/{appid}/{releaseid}")
    public ResponseEntity<Void> addApptoRelease(@PathVariable("appid") Integer appid,
    		@PathVariable("releaseid") Integer releaseid, UriComponentsBuilder builder) {
    	releaseService.addApplication(appid, releaseid);
    	return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
