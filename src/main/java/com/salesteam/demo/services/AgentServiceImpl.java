package com.salesteam.demo.services;

import com.salesteam.demo.models.Agent;
import com.salesteam.demo.repositories.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "agentService")
public class AgentServiceImpl implements AgentService {
    @Autowired
    private AgentsRepository agentrepos;

    @Override
    public List<Agent> findAllAgents() {
        List <Agent> list = new ArrayList<>();
        agentrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
    @Transactional
    @Override
    public Agent save(Agent agent){
        return agentrepos.save(agent);
    }

    @Override
    public Agent findAgentById(long agentcode) {
       return agentrepos.findById(agentcode).orElseThrow(()->new EntityNotFoundException("Agent not found"));
    }
}
