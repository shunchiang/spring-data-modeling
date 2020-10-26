package com.salesteam.demo.controllers;

import com.salesteam.demo.models.Agent;
import com.salesteam.demo.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agents")
public class AgentController {
    @Autowired
    AgentService agentService;
    // http://localhost:2020/agents/agents get all agents
    @GetMapping(value = "/agents", produces = {"application/json"})
    public ResponseEntity<?> listAllAgents(){
        List<Agent> rtnList = agentService.findAllAgents();
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }

    // http://localhost:2020/agents/id get agent by id

    // http://localhost:2020/agents/likeness get agent name by likeness

    // http://localhost:2020/agents/customers get agent's customer counts


}
